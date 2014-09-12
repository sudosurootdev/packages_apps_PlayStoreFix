
package android.support.v4.media;



class this._cls0
    implements android.view.angeListener
{

    public void onWindowFocusChanged(boolean flag)
    {
        if(flag)
        {
            gainFocus();
            return;
        } else
        {
            loseFocus();
            return;
        }
    }

    final TransportMediatorJellybeanMR2 this$0;

    ()
    {
        this$0 = TransportMediatorJellybeanMR2.this;
        super();
    }
}
