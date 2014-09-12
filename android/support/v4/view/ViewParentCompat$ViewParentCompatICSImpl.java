
package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;


static class  extends 
{

    public boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
    {
        return ViewParentCompatICS.requestSendAccessibilityEvent(viewparent, view, accessibilityevent);
    }

    ()
    {
    }
}
