
package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;


class  extends AccessibilityDelegateCompat
{

    private boolean canScroll()
    {
        return ViewPager.access$200(ViewPager.this) != null && ViewPager.access$200(ViewPager.this).getCount() > 1;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/view/ViewPager.getName());
        AccessibilityRecordCompat accessibilityrecordcompat = AccessibilityRecordCompat.obtain();
        accessibilityrecordcompat.setScrollable(canScroll());
        if(accessibilityevent.getEventType() == 4096 && ViewPager.access$200(ViewPager.this) != null)
        {
            accessibilityrecordcompat.setItemCount(ViewPager.access$200(ViewPager.this).getCount());
            accessibilityrecordcompat.setFromIndex(ViewPager.access$300(ViewPager.this));
            accessibilityrecordcompat.setToIndex(ViewPager.access$300(ViewPager.this));
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
        accessibilitynodeinfocompat.setClassName(android/support/v4/view/ViewPager.getName());
        accessibilitynodeinfocompat.setScrollable(canScroll());
        if(canScrollHorizontally(1))
            accessibilitynodeinfocompat.addAction(4096);
        if(canScrollHorizontally(-1))
            accessibilitynodeinfocompat.addAction(8192);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if(super.performAccessibilityAction(view, i, bundle))
            return true;
        switch(i)
        {
        case 8192: 
            if(canScrollHorizontally(-1))
            {
                setCurrentItem(-1 + ViewPager.access$300(ViewPager.this));
                return true;
            } else
            {
                return false;
            }

        case 4096: 
            if(canScrollHorizontally(1))
            {
                setCurrentItem(1 + ViewPager.access$300(ViewPager.this));
                return true;
            } else
            {
                return false;
            }
        }
        return false;
    }

    final ViewPager this$0;

    oCompat()
    {
        this$0 = ViewPager.this;
        super();
    }
}
