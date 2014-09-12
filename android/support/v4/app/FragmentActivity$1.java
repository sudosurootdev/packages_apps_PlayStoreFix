
package android.support.v4.app;

import android.os.Handler;
import android.os.Message;


class this._cls0 extends Handler
{

    public void handleMessage(Message message)
    {
        switch(message.what)
        {
        case 2: // '\002'
            onResumeFragments();
            mFragments.execPendingActions();
            return;

        case 1: // '\001'
            if(mStopped)
            {
                doReallyStop(false);
                return;
            }
            break;

        default:
            super.handleMessage(message);
            break;
        }
    }

    final FragmentActivity this$0;

    ()
    {
        this$0 = FragmentActivity.this;
        super();
    }
}
