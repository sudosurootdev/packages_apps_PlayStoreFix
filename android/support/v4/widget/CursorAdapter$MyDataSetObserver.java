
package android.support.v4.widget;

import android.database.DataSetObserver;


private class <init> extends DataSetObserver
{

    public void onChanged()
    {
        mDataValid = true;
        notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        mDataValid = false;
        notifyDataSetInvalidated();
    }

    final CursorAdapter this$0;

    private ()
    {
        this$0 = CursorAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
