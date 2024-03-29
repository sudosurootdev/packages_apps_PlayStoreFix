
package android.support.v4.view;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class ViewCompatICS
{

    ViewCompatICS()
    {
    }

    public static boolean canScrollHorizontally(View view, int i)
    {
        return view.canScrollHorizontally(i);
    }

    public static boolean canScrollVertically(View view, int i)
    {
        return view.canScrollVertically(i);
    }

    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        view.onInitializeAccessibilityEvent(accessibilityevent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, Object obj)
    {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)obj);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        view.onPopulateAccessibilityEvent(accessibilityevent);
    }

    public static void setAccessibilityDelegate(View view, Object obj)
    {
        view.setAccessibilityDelegate((android.view.View.AccessibilityDelegate)obj);
    }
}
