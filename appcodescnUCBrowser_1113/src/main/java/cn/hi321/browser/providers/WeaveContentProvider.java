/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.providers;

import cn.hi321.browser.providers.WeaveColumns;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class WeaveContentProvider extends ContentProvider {
	
	public static final String AUTHORITY = "org.zirco.providers.weavecontentprovider";
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "weave.db";
	
	public static final String WEAVE_BOOKMARKS_TABLE = "WEAVE_BOOKMARKS";
	
	private static final String WEAVE_BOOKMARKS_TABLE_CREATE = "CREATE TABLE " + WEAVE_BOOKMARKS_TABLE + " (" + 
		WeaveColumns.WEAVE_BOOKMARKS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		WeaveColumns.WEAVE_BOOKMARKS_WEAVE_ID + " TEXT, " +
		WeaveColumns.WEAVE_BOOKMARKS_WEAVE_PARENT_ID + " TEXT, " +
		WeaveColumns.WEAVE_BOOKMARKS_TITLE + " TEXT, " +
		WeaveColumns.WEAVE_BOOKMARKS_URL + " TEXT, " +
		WeaveColumns.WEAVE_BOOKMARKS_FOLDER + " BOOLEAN);";
	
	private static final int WEAVE_BOOKMARKS = 1;
	private static final int WEAVE_BOOKMARKS_BY_ID = 2;
	
	private static final UriMatcher sUriMatcher;
	
	private SQLiteDatabase mDb;
	private DatabaseHelper mDbHelper;
	
	private Context mContext;
	
	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(AUTHORITY, WEAVE_BOOKMARKS_TABLE, WEAVE_BOOKMARKS);
		sUriMatcher.addURI(AUTHORITY, WEAVE_BOOKMARKS_TABLE + "/#", WEAVE_BOOKMARKS_BY_ID);
	}
	
	@Override
	public boolean onCreate() {
		mContext = getContext();
		mDbHelper = new DatabaseHelper(mContext);
		mDb = mDbHelper.getWritableDatabase();
		return true;
	}

	@Override
	public int delete(Uri uri, String whereClause, String[] whereArgs) {
		int count = 0;
		
		switch (sUriMatcher.match(uri)) {
		case WEAVE_BOOKMARKS:
			count = mDb.delete(WEAVE_BOOKMARKS_TABLE, whereClause, whereArgs);
			break;
			
		default: throw new IllegalArgumentException("Unknown URI " + uri);
		}		
		
		if (count > 0) {
			mContext.getContentResolver().notifyChange(uri, null);
		}
		
		return count;
	}

	@Override
	public String getType(Uri uri) {
		switch (sUriMatcher.match(uri)) {
		case WEAVE_BOOKMARKS:
			return WeaveColumns.CONTENT_TYPE;
		case WEAVE_BOOKMARKS_BY_ID:
			return WeaveColumns.CONTENT_ITEM_TYPE;

		default: throw new IllegalArgumentException("Unknown URI " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		switch (sUriMatcher.match(uri)) {
		case WEAVE_BOOKMARKS:
			long rowId = mDb.insert(WEAVE_BOOKMARKS_TABLE, null, values);
			if (rowId > 0) {
				Uri rowUri = ContentUris.withAppendedId(WeaveColumns.CONTENT_URI, rowId);
				mContext.getContentResolver().notifyChange(rowUri, null);
				return rowUri;
			}
			
			throw new SQLException("Failed to insert row into " + uri);
			
		default: throw new IllegalArgumentException("Unknown URI " + uri);
		}										
	}	

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		
		switch (sUriMatcher.match(uri)) {
		case WEAVE_BOOKMARKS:
			qb.setTables(WEAVE_BOOKMARKS_TABLE);			
			break;
		case WEAVE_BOOKMARKS_BY_ID:
			qb.setTables(WEAVE_BOOKMARKS_TABLE);
			qb.appendWhere(WeaveColumns.WEAVE_BOOKMARKS_ID + " = " + uri.getPathSegments().get(1));
			break;		
		default: throw new IllegalArgumentException("Unknown URI " + uri);
		}
		
		Cursor c = qb.query(mDb, projection, selection, selectionArgs, null, null, sortOrder);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		int count = 0;
		switch (sUriMatcher.match(uri)) {
		case WEAVE_BOOKMARKS:
			count = mDb.update(WEAVE_BOOKMARKS_TABLE, values, selection, selectionArgs);
			break;
			
		default: throw new IllegalArgumentException("Unknown URI " + uri);
		}
						
		if (count > 0) {
			mContext.getContentResolver().notifyChange(uri, null);
		}
		
		return count;
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(WEAVE_BOOKMARKS_TABLE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }		
	}

}