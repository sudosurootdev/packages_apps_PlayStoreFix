
package android.support.v4.view;

import android.os.Handler;
import android.os.Message;


private class this._cls0 extends Handler
{

    public void handleMessage(Message message)
    {
label0:
        {
            switch(message.what)
            {
            default:
                break label0;

            case 3: // '\003'
                if(this._mth0(this._cls0.this) != null)
                    if(!this._mth0(this._cls0.this))
                    {
                        this._mth0(this._cls0.this)._mth0(this._mth0(this._cls0.this));
                        return;
                    } else
                    {
                        this._mth0(this._cls0.this, true);
                        return;
                    }
                break;

            case 2: // '\002'
                this._mth0(this._cls0.this);
                return;

            case 1: // '\001'
                this._mth0(this._cls0.this)._mth0(this._mth0(this._cls0.this));
                break;
            }
            return;
        }
        throw new RuntimeException((new StringBuilder()).append("Unknown message ").append(message).toString());
    }

    final this._cls0 this$0;

    ()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(Handler handler)
    {
        this$0 = this._cls0.this;
        super(handler.getLooper());
    }
}
