
package android.support.v4.widget;

import android.database.Cursor;


static interface 
{

    public abstract void changeCursor(Cursor cursor);

    public abstract CharSequence convertToString(Cursor cursor);

    public abstract Cursor getCursor();

    public abstract Cursor runQueryOnBackgroundThread(CharSequence charsequence);
}
