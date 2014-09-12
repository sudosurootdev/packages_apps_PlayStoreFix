
package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;


static class deInfoCompat extends deInfoCompat
{

    public boolean canScrollHorizontally(View view, int i)
    {
        return ViewCompatICS.canScrollHorizontally(view, i);
    }

    public boolean canScrollVertically(View view, int i)
    {
        return ViewCompatICS.canScrollVertically(view, i);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        ViewCompatICS.onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        ViewCompatICS.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat.getInfo());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        ViewCompatICS.onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
        ViewCompatICS.setAccessibilityDelegate(view, accessibilitydelegatecompat.getBridge());
    }

    deInfoCompat()
    {
    }
}
