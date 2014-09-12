
package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;


private class <init> extends AccessibilityNodeProviderCompat
{

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i)
    {
        return ExploreByTouchHelper.access$100(ExploreByTouchHelper.this, i);
    }

    public boolean performAction(int i, int j, Bundle bundle)
    {
        return ExploreByTouchHelper.access$200(ExploreByTouchHelper.this, i, j, bundle);
    }

    final ExploreByTouchHelper this$0;

    private ()
    {
        this$0 = ExploreByTouchHelper.this;
        super();
    }

    t>(t> t>)
    {
        this();
    }
}
