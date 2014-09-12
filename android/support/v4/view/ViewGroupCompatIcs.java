
package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class ViewGroupCompatIcs
{

    ViewGroupCompatIcs()
    {
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return viewgroup.onRequestSendAccessibilityEvent(view, accessibilityevent);
    }
}
