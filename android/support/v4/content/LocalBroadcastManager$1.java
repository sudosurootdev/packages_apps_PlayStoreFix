
package android.support.v4.content;

import android.os.*;


class this._cls0 extends Handler
{

    public void handleMessage(Message message)
    {
        switch(message.what)
        {
        case 1: // '\001'
            LocalBroadcastManager.access$000(LocalBroadcastManager.this);
            return;
        }
        super.handleMessage(message);
    }

    final LocalBroadcastManager this$0;

    (Looper looper)
    {
        this$0 = LocalBroadcastManager.this;
        super(looper);
    }
}
