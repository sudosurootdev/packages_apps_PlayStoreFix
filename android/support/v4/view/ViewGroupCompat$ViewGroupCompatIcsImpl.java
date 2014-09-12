
package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


static class  extends 
{

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    ()
    {
    }
}
