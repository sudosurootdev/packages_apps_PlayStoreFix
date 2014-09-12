
package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


static interface A
{

    public abstract int getLayoutMode(ViewGroup viewgroup);

    public abstract boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent);

    public abstract void setLayoutMode(ViewGroup viewgroup, int i);

    public abstract void setMotionEventSplittingEnabled(ViewGroup viewgroup, boolean flag);
}
