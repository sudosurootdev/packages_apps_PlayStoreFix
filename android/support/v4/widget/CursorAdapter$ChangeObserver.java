
package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;


private class this._cls0 extends ContentObserver
{

    public boolean deliverSelfNotifications()
    {
        return true;
    }

    public void onChange(boolean flag)
    {
        onContentChanged();
    }

    final CursorAdapter this$0;

    public ()
    {
        this$0 = CursorAdapter.this;
        super(new Handler());
    }
}
