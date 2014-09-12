
package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;


static interface 
{

    public abstract void appendRecord(AccessibilityEvent accessibilityevent, Object obj);

    public abstract Object getRecord(AccessibilityEvent accessibilityevent, int i);

    public abstract int getRecordCount(AccessibilityEvent accessibilityevent);
}
