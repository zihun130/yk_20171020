package cn.hi321.browser.model.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.provider.Browser;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import cn.hi321.browser2.R;

/**
 * Cursor adapter for bookmarks.
 */
public class BookmarksCursorAdapter extends SimpleCursorAdapter {
	
	private int mFaviconSize;
	
	/**
	 * Constructor.
	 * @param context The context.
	 * @param layout The layout.
	 * @param c The Cursor. 
	 * @param from Input array.
	 * @param to Output array.
	 */
	public BookmarksCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int faviconSize) {
		super(context, layout, c, from, to);
		mFaviconSize = faviconSize;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View superView = super.getView(position, convertView, parent);

		ImageView thumbnailView = (ImageView) superView.findViewById(R.id.BookmarkRow_Thumbnail);
		
		byte[] favicon = getCursor().getBlob(getCursor().getColumnIndex(Browser.BookmarkColumns.FAVICON));
		if (favicon != null) {
			BitmapDrawable icon = new BitmapDrawable(BitmapFactory.decodeByteArray(favicon, 0, favicon.length));
			
			Bitmap bm = Bitmap.createBitmap(mFaviconSize, mFaviconSize, Bitmap.Config.ARGB_4444);
			Canvas canvas = new Canvas(bm);
			
			icon.setBounds(0, 0, mFaviconSize, mFaviconSize);
			icon.draw(canvas);
			
			thumbnailView.setImageBitmap(bm);
		} else {
			thumbnailView.setImageResource(R.drawable.fav_icn_unknown);
		}
		
		return superView;
	}	

}