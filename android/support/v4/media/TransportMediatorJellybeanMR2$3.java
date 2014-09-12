
package android.support.v4.media;

import android.content.*;
import android.util.Log;
import android.view.KeyEvent;


class this._cls0 extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            KeyEvent keyevent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            mTransportCallback.handleKey(keyevent);
            return;
        }
        catch(ClassCastException classcastexception)
        {
            Log.w("TransportController", classcastexception);
        }
    }

    final TransportMediatorJellybeanMR2 this$0;

    ()
    {
        this$0 = TransportMediatorJellybeanMR2.this;
        super();
    }
}
