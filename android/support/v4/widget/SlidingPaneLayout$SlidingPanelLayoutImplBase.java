
package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;


static class 
    implements 
{

    public void invalidateChildRegion(SlidingPaneLayout slidingpanelayout, View view)
    {
        ViewCompat.postInvalidateOnAnimation(slidingpanelayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    ()
    {
    }
}
