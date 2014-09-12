
package android.support.v4.view;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;


public class ViewParentCompat
{
    static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl
    {

        public boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
        {
            return ViewParentCompatICS.requestSendAccessibilityEvent(viewparent, view, accessibilityevent);
        }

        ViewParentCompatICSImpl()
        {
        }
    }

    static interface ViewParentCompatImpl
    {

        public abstract boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent);
    }

    static class ViewParentCompatStubImpl
        implements ViewParentCompatImpl
    {

        public boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
        {
            if(view == null)
            {
                return false;
            } else
            {
                ((AccessibilityManager)view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityevent);
                return true;
            }
        }

        ViewParentCompatStubImpl()
        {
        }
    }


    private ViewParentCompat()
    {
    }

    public static boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
    {
        return IMPL.requestSendAccessibilityEvent(viewparent, view, accessibilityevent);
    }

    static final ViewParentCompatImpl IMPL;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT >= 14)
            IMPL = new ViewParentCompatICSImpl();
        else
            IMPL = new ViewParentCompatStubImpl();
    }
}
