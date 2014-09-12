
package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


class val.compat
    implements val.compat
{

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return val$compat.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        val$compat.onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, Object obj)
    {
        val$compat.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(obj));
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        val$compat.onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return val$compat.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        val$compat.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        val$compat.sendAccessibilityEventUnchecked(view, accessibilityevent);
    }

    final  this$0;
    final AccessibilityDelegateCompat val$compat;

    ()
    {
        this$0 = final_;
        val$compat = AccessibilityDelegateCompat.this;
        super();
    }
}
