
package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.ArrayList;


private class mChildView
    implements Runnable
{

    public void run()
    {
        if(mChildView.getParent() == SlidingPaneLayout.this)
        {
            ViewCompat.setLayerType(mChildView, 0, null);
            SlidingPaneLayout.access$900(SlidingPaneLayout.this, mChildView);
        }
        SlidingPaneLayout.access$1000(SlidingPaneLayout.this).remove(this);
    }

    final View mChildView;
    final SlidingPaneLayout this$0;

    (View view)
    {
        this$0 = SlidingPaneLayout.this;
        super();
        mChildView = view;
    }
}
