
package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


static interface 
{

    public abstract boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityevent);

    public abstract AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object obj, View view);

    public abstract Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilitydelegatecompat);

    public abstract Object newAccessiblityDelegateDefaultImpl();

    public abstract void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityevent);

    public abstract void onInitializeAccessibilityNodeInfo(Object obj, View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat);

    public abstract void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityevent);

    public abstract boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent);

    public abstract boolean performAccessibilityAction(Object obj, View view, int i, Bundle bundle);

    public abstract void sendAccessibilityEvent(Object obj, View view, int i);

    public abstract void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityevent);
}
