
package android.support.v4.view;

import android.view.ViewGroup;

class ViewGroupCompatHC
{

    private ViewGroupCompatHC()
    {
    }

    public static void setMotionEventSplittingEnabled(ViewGroup viewgroup, boolean flag)
    {
        viewgroup.setMotionEventSplittingEnabled(flag);
    }
}
