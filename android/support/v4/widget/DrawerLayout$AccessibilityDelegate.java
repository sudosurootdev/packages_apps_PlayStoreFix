
package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


class this._cls0 extends AccessibilityDelegateCompat
{

    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilitynodeinfocompat, ViewGroup viewgroup)
    {
        int i = viewgroup.getChildCount();
        for(int j = 0; j < i; j++)
        {
            View view = viewgroup.getChildAt(j);
            if(!filter(view))
                switch(ViewCompat.getImportantForAccessibility(view))
                {
                case 3: // '\003'
                case 4: // '\004'
                default:
                    break;

                case 2: // '\002'
                    if(view instanceof ViewGroup)
                        addChildrenForAccessibility(accessibilitynodeinfocompat, (ViewGroup)view);
                    break;

                case 0: // '\0'
                    ViewCompat.setImportantForAccessibility(view, 1);
                    // fall through

                case 1: // '\001'
                    accessibilitynodeinfocompat.addChild(view);
                    break;
                }
        }

    }

    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilitynodeinfocompat, AccessibilityNodeInfoCompat accessibilitynodeinfocompat1)
    {
        Rect rect = mTmpRect;
        accessibilitynodeinfocompat1.getBoundsInParent(rect);
        accessibilitynodeinfocompat.setBoundsInParent(rect);
        accessibilitynodeinfocompat1.getBoundsInScreen(rect);
        accessibilitynodeinfocompat.setBoundsInScreen(rect);
        accessibilitynodeinfocompat.setVisibleToUser(accessibilitynodeinfocompat1.isVisibleToUser());
        accessibilitynodeinfocompat.setPackageName(accessibilitynodeinfocompat1.getPackageName());
        accessibilitynodeinfocompat.setClassName(accessibilitynodeinfocompat1.getClassName());
        accessibilitynodeinfocompat.setContentDescription(accessibilitynodeinfocompat1.getContentDescription());
        accessibilitynodeinfocompat.setEnabled(accessibilitynodeinfocompat1.isEnabled());
        accessibilitynodeinfocompat.setClickable(accessibilitynodeinfocompat1.isClickable());
        accessibilitynodeinfocompat.setFocusable(accessibilitynodeinfocompat1.isFocusable());
        accessibilitynodeinfocompat.setFocused(accessibilitynodeinfocompat1.isFocused());
        accessibilitynodeinfocompat.setAccessibilityFocused(accessibilitynodeinfocompat1.isAccessibilityFocused());
        accessibilitynodeinfocompat.setSelected(accessibilitynodeinfocompat1.isSelected());
        accessibilitynodeinfocompat.setLongClickable(accessibilitynodeinfocompat1.isLongClickable());
        accessibilitynodeinfocompat.addAction(accessibilitynodeinfocompat1.getActions());
    }

    public boolean filter(View view)
    {
        View view1 = findOpenDrawer();
        return view1 != null && view1 != view;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat1 = AccessibilityNodeInfoCompat.obtain(accessibilitynodeinfocompat);
        super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat1);
        accessibilitynodeinfocompat.setSource(view);
        android.view.ViewParent viewparent = ViewCompat.getParentForAccessibility(view);
        if(viewparent instanceof View)
            accessibilitynodeinfocompat.setParent((View)viewparent);
        copyNodeInfoNoChildren(accessibilitynodeinfocompat, accessibilitynodeinfocompat1);
        accessibilitynodeinfocompat1.recycle();
        addChildrenForAccessibility(accessibilitynodeinfocompat, (ViewGroup)view);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        if(!filter(view))
            return super.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
        else
            return false;
    }

    private final Rect mTmpRect = new Rect();
    final DrawerLayout this$0;

    mpat()
    {
        this$0 = DrawerLayout.this;
        super();
    }
}
