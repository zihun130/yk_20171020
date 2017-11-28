/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.ui.runnables;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import cn.hi321.browser.providers.BookmarksProviderWrapper;
import cn.hi321.browser.utils.ApplicationUtils;
import cn.hi321.browser.utils.DateUtils;
import cn.hi321.browser.utils.IOUtils;
import cn.hi321.browser2.R;

/**
 * Runnable to import history and bookmarks from an XML file.
 */
public class XmlHistoryBookmarksImporter implements Runnable {	
	
	private Context mContext;
	private String mFileName;
	
	private ProgressDialog mProgressDialog;
	
	private String mErrorMessage = null;
	
	/**
	 * Constructor.
	 * @param context The current context.
	 * @param fileName The file to import.
	 * @param progressDialog The progress dialog shown during import.
	 */
	public XmlHistoryBookmarksImporter(Context context, String fileName, ProgressDialog progressDialog) {
		mContext = context;
		mFileName = fileName;
		mProgressDialog = progressDialog;
	}
	
	/**
	 * Get the content of a node, why Android does not include Node.getTextContent() ?
	 * @param node The node.
	 * @return The node content.
	 */
	private String getNodeContent(Node node) {
		StringBuffer buffer = new StringBuffer();
		NodeList childList = node.getChildNodes();
		for (int i = 0; i < childList.getLength(); i++) {
		    Node child = childList.item(i);
		    if (child.getNodeType() != Node.TEXT_NODE) {
		        continue; // skip non-text nodes
		    }
		    buffer.append(child.getNodeValue());
		}

		return buffer.toString(); 
	}
	
	@Override
	public void run() {
		
		File file = new File(IOUtils.getBookmarksExportFolder(), mFileName);
		
		if ((file != null) &&
				(file.exists()) &&
				(file.canRead())) {
			
			try {
			
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();				
				DocumentBuilder builder;

				builder = factory.newDocumentBuilder();

				Document document = builder.parse(file);
				
				Element root = document.getDocumentElement();
				
				if ((root != null) &&
						(root.getNodeName().equals("itemlist"))) {
					
					NodeList itemsList = root.getElementsByTagName("item");
					
					Node item;
					NodeList record;
					Node dataItem;
					
					for (int i = 0; i < itemsList.getLength(); i++) {
						
						item = itemsList.item(i);
						
						if (item != null) {
							record = item.getChildNodes();
							
							String title = null;
							String url = null;
							int visits = 0;
							long date = -1;
							long created = -1;
							int bookmark = 0;
							
							for (int j = 0; j < record.getLength(); j++) {
								dataItem = record.item(j);																
								
								if ((dataItem != null) &&
										(dataItem.getNodeName() != null)) {
									
									if (dataItem.getNodeName().equals("title")) {
										title = URLDecoder.decode(getNodeContent(dataItem));										
									} else if (dataItem.getNodeName().equals("url")) {
										url = URLDecoder.decode(getNodeContent(dataItem));
									} else if (dataItem.getNodeName().equals("visits")) {
										try {
											visits = Integer.parseInt(getNodeContent(dataItem));
										} catch (Exception e) {
											visits = 0;
										}
									} else if (dataItem.getNodeName().equals("date")) {
										try {
											date = Long.parseLong(getNodeContent(dataItem));
										} catch (Exception e) {
											date = -1;
										}
									} else if (dataItem.getNodeName().equals("created")) {
										try {
											created = Long.parseLong(getNodeContent(dataItem));
										} catch (Exception e) {
											created = -1;
										}
									} else if (dataItem.getNodeName().equals("bookmark")) {
										try {
											bookmark = Integer.parseInt(getNodeContent(dataItem));
										} catch (Exception e) {
											bookmark = 0;
										}
									}
								}
							}
							
							BookmarksProviderWrapper.insertRawRecord(mContext.getContentResolver(), title, url, visits, date, created, bookmark);
						}
					}
					
				} else if ((root != null) &&
						(root.getNodeName().equals("bookmarkslist"))) {
					// Old export format (before 0.4.0).
					
					NodeList bookmarksList = root.getElementsByTagName("bookmark");
					
					Node bookmark;
					NodeList bookmarkItems;
					String title;
					String url;
					String creationDate;
					int count;
					long date = -1;
					long created = -1;
					Node item;
					
					for (int i = 0; i < bookmarksList.getLength(); i++) {
						
						bookmark = bookmarksList.item(i);
						
						if (bookmark != null) {
							
							title = null;
							url = null;
							creationDate = null;
							count = 0;
							
							bookmarkItems = bookmark.getChildNodes();
							
							for (int j = 0; j < bookmarkItems.getLength(); j++) {
								
								item = bookmarkItems.item(j);
								
								if ((item != null) &&
										(item.getNodeName() != null)) {
									if (item.getNodeName().equals("title")) {
										title = getNodeContent(item);										
									} else if (item.getNodeName().equals("url")) {
										url = URLDecoder.decode(getNodeContent(item));
									} else if (item.getNodeName().equals("creationdate")) {
										creationDate = getNodeContent(item);
										
										date = DateUtils.convertFromDatabase(mContext, creationDate).getTime();
										created = date;
										
									} else if (item.getNodeName().equals("count")) {
										try {
											count = Integer.parseInt(getNodeContent(item));
										} catch (Exception e) {
											count = 0;
										}
									}
								}
								
							}
							
							BookmarksProviderWrapper.insertRawRecord(mContext.getContentResolver(), title, url, count, date, created, 1);								
						}
					}
				}
			
			} catch (ParserConfigurationException e) {
				Log.w("Bookmark import failed", e.getMessage());
				mErrorMessage = e.toString();
			} catch (SAXException e) {
				Log.w("Bookmark import failed", e.getMessage());
				mErrorMessage = e.toString();
			} catch (IOException e) {
				Log.w("Bookmark import failed", e.getMessage());
				mErrorMessage = e.toString();
			}			
		}
		
		mHandler.sendEmptyMessage(0);
	}
	
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (mProgressDialog != null) {
				mProgressDialog.dismiss();
			}
			
			if (mErrorMessage != null) {
				ApplicationUtils.showOkDialog(mContext,
						android.R.drawable.ic_dialog_alert,
						mContext.getResources().getString(R.string.Commons_HistoryBookmarksImportSDCardFailedTitle),
						String.format(mContext.getResources().getString(R.string.Commons_HistoryBookmarksFailedMessage), mErrorMessage));
				
			}
		}
	};

}