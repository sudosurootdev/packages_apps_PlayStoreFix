
package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;


static interface 
{

    public abstract boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent);
}
