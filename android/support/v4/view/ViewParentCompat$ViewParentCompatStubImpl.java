
package android.support.v4.view;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;


static class 
    implements 
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

    ()
    {
    }
}
