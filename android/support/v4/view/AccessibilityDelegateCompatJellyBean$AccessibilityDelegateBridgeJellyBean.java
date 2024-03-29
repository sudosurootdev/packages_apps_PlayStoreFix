
package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


public static interface 
{

    public abstract boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent);

    public abstract Object getAccessibilityNodeProvider(View view);

    public abstract void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent);

    public abstract void onInitializeAccessibilityNodeInfo(View view, Object obj);

    public abstract void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent);

    public abstract boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent);

    public abstract boolean performAccessibilityAction(View view, int i, Bundle bundle);

    public abstract void sendAccessibilityEvent(View view, int i);

    public abstract void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent);
}
