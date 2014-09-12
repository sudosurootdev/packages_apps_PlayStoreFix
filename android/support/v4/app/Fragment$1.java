
package android.support.v4.app;

import android.view.View;


class this._cls0
    implements FragmentContainer
{

    public View findViewById(int i)
    {
        if(mView == null)
            throw new IllegalStateException("Fragment does not have a view");
        else
            return mView.findViewById(i);
    }

    final Fragment this$0;

    tainer()
    {
        this$0 = Fragment.this;
        super();
    }
}
