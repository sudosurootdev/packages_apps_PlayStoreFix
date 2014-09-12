
package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;


static class  extends 
{

    public void appendRecord(AccessibilityEvent accessibilityevent, Object obj)
    {
        AccessibilityEventCompatIcs.appendRecord(accessibilityevent, obj);
    }

    public Object getRecord(AccessibilityEvent accessibilityevent, int i)
    {
        return AccessibilityEventCompatIcs.getRecord(accessibilityevent, i);
    }

    public int getRecordCount(AccessibilityEvent accessibilityevent)
    {
        return AccessibilityEventCompatIcs.getRecordCount(accessibilityevent);
    }

    ()
    {
    }
}
