
package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityEventCompatIcs
{

    AccessibilityEventCompatIcs()
    {
    }

    public static void appendRecord(AccessibilityEvent accessibilityevent, Object obj)
    {
        accessibilityevent.appendRecord((AccessibilityRecord)obj);
    }

    public static Object getRecord(AccessibilityEvent accessibilityevent, int i)
    {
        return accessibilityevent.getRecord(i);
    }

    public static int getRecordCount(AccessibilityEvent accessibilityevent)
    {
        return accessibilityevent.getRecordCount();
    }
}
