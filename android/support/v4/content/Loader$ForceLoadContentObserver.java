
package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;


public final class this._cls0 extends ContentObserver
{

    public boolean deliverSelfNotifications()
    {
        return true;
    }

    public void onChange(boolean flag)
    {
        onContentChanged();
    }

    final Loader this$0;

    public ()
    {
        this$0 = Loader.this;
        super(new Handler());
    }
}
