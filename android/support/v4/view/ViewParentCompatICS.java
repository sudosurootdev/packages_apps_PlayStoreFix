
package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewParentCompatICS
{

    public ViewParentCompatICS()
    {
    }

    public static boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
    {
        return viewparent.requestSendAccessibilityEvent(view, accessibilityevent);
    }
}
