
package android.support.v4.media;

import android.view.KeyEvent;


class this._cls0
    implements android.view.tMediator._cls2
{

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if(TransportMediator.isMediaKey(i))
            return mCallbacks.onMediaButtonDown(i, keyevent);
        else
            return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if(TransportMediator.isMediaKey(i))
            return mCallbacks.onMediaButtonUp(i, keyevent);
        else
            return false;
    }

    final TransportMediator this$0;

    ()
    {
        this$0 = TransportMediator.this;
        super();
    }
}
