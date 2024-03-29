
package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


public class ViewGroupCompat
{
    static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl
    {

        public void setMotionEventSplittingEnabled(ViewGroup viewgroup, boolean flag)
        {
            ViewGroupCompatHC.setMotionEventSplittingEnabled(viewgroup, flag);
        }

        ViewGroupCompatHCImpl()
        {
        }
    }

    static class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl
    {

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
        {
            return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
        }

        ViewGroupCompatIcsImpl()
        {
        }
    }

    static interface ViewGroupCompatImpl
    {

        public abstract int getLayoutMode(ViewGroup viewgroup);

        public abstract boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent);

        public abstract void setLayoutMode(ViewGroup viewgroup, int i);

        public abstract void setMotionEventSplittingEnabled(ViewGroup viewgroup, boolean flag);
    }

    static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl
    {

        public int getLayoutMode(ViewGroup viewgroup)
        {
            return ViewGroupCompatJellybeanMR2.getLayoutMode(viewgroup);
        }

        public void setLayoutMode(ViewGroup viewgroup, int i)
        {
            ViewGroupCompatJellybeanMR2.setLayoutMode(viewgroup, i);
        }

        ViewGroupCompatJellybeanMR2Impl()
        {
        }
    }

    static class ViewGroupCompatStubImpl
        implements ViewGroupCompatImpl
    {

        public int getLayoutMode(ViewGroup viewgroup)
        {
            return 0;
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
        {
            return true;
        }

        public void setLayoutMode(ViewGroup viewgroup, int i)
        {
        }

        public void setMotionEventSplittingEnabled(ViewGroup viewgroup, boolean flag)
        {
        }

        ViewGroupCompatStubImpl()
        {
        }
    }


    private ViewGroupCompat()
    {
    }

    public static int getLayoutMode(ViewGroup viewgroup)
    {
        return IMPL.getLayoutMode(viewgroup);
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return IMPL.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public static void setLayoutMode(ViewGroup viewgroup, int i)
    {
        IMPL.setLayoutMode(viewgroup, i);
    }

    public static void setMotionEventSplittingEnabled(ViewGroup viewgroup, boolean flag)
    {
        IMPL.setMotionEventSplittingEnabled(viewgroup, flag);
    }

    static final ViewGroupCompatImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if(i >= 18)
            IMPL = new ViewGroupCompatJellybeanMR2Impl();
        else
        if(i >= 14)
            IMPL = new ViewGroupCompatIcsImpl();
        else
        if(i >= 11)
            IMPL = new ViewGroupCompatHCImpl();
        else
            IMPL = new ViewGroupCompatStubImpl();
    }
}
