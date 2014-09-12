
package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.*;
import android.support.v4.view.accessibility.*;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.*;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat
{
    private class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat
    {

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i)
        {
            return createNode(i);
        }

        public boolean performAction(int i, int j, Bundle bundle)
        {
            return ExploreByTouchHelper.this.performAction(i, j, bundle);
        }

        final ExploreByTouchHelper this$0;

        private ExploreByTouchNodeProvider()
        {
            this$0 = ExploreByTouchHelper.this;
            super();
        }

    }


    public ExploreByTouchHelper(View view)
    {
        mFocusedVirtualViewId = 0x80000000;
        mHoveredVirtualViewId = 0x80000000;
        if(view == null)
        {
            throw new IllegalArgumentException("View may not be null");
        } else
        {
            mView = view;
            mManager = (AccessibilityManager)view.getContext().getSystemService("accessibility");
            return;
        }
    }

    private boolean clearAccessibilityFocus(int i)
    {
        if(isAccessibilityFocused(i))
        {
            mFocusedVirtualViewId = 0x80000000;
            mView.invalidate();
            sendEventForVirtualView(i, 0x10000);
            return true;
        } else
        {
            return false;
        }
    }

    private AccessibilityEvent createEvent(int i, int j)
    {
        switch(i)
        {
        case -1: 
            return createEventForHost(j);
        }
        return createEventForChild(i, j);
    }

    private AccessibilityEvent createEventForChild(int i, int j)
    {
        AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(j);
        accessibilityevent.setEnabled(true);
        accessibilityevent.setClassName(DEFAULT_CLASS_NAME);
        onPopulateEventForVirtualView(i, accessibilityevent);
        if(accessibilityevent.getText().isEmpty() && accessibilityevent.getContentDescription() == null)
        {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        } else
        {
            accessibilityevent.setPackageName(mView.getContext().getPackageName());
            AccessibilityEventCompat.asRecord(accessibilityevent).setSource(mView, i);
            return accessibilityevent;
        }
    }

    private AccessibilityEvent createEventForHost(int i)
    {
        AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(i);
        ViewCompat.onInitializeAccessibilityEvent(mView, accessibilityevent);
        return accessibilityevent;
    }

    private AccessibilityNodeInfoCompat createNode(int i)
    {
        switch(i)
        {
        case -1: 
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i)
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat = AccessibilityNodeInfoCompat.obtain();
        accessibilitynodeinfocompat.setEnabled(true);
        accessibilitynodeinfocompat.setClassName(DEFAULT_CLASS_NAME);
        onPopulateNodeForVirtualView(i, accessibilitynodeinfocompat);
        if(accessibilitynodeinfocompat.getText() == null && accessibilitynodeinfocompat.getContentDescription() == null)
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        accessibilitynodeinfocompat.getBoundsInParent(mTempParentRect);
        if(mTempParentRect.isEmpty())
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        int j = accessibilitynodeinfocompat.getActions();
        if((j & 0x40) != 0)
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        if((j & 0x80) != 0)
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        accessibilitynodeinfocompat.setPackageName(mView.getContext().getPackageName());
        accessibilitynodeinfocompat.setSource(mView, i);
        accessibilitynodeinfocompat.setParent(mView);
        if(mFocusedVirtualViewId == i)
        {
            accessibilitynodeinfocompat.setAccessibilityFocused(true);
            accessibilitynodeinfocompat.addAction(128);
        } else
        {
            accessibilitynodeinfocompat.setAccessibilityFocused(false);
            accessibilitynodeinfocompat.addAction(64);
        }
        if(intersectVisibleToUser(mTempParentRect))
        {
            accessibilitynodeinfocompat.setVisibleToUser(true);
            accessibilitynodeinfocompat.setBoundsInParent(mTempParentRect);
        }
        mView.getLocationOnScreen(mTempGlobalRect);
        int k = mTempGlobalRect[0];
        int l = mTempGlobalRect[1];
        mTempScreenRect.set(mTempParentRect);
        mTempScreenRect.offset(k, l);
        accessibilitynodeinfocompat.setBoundsInScreen(mTempScreenRect);
        return accessibilitynodeinfocompat;
    }

    private AccessibilityNodeInfoCompat createNodeForHost()
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat = AccessibilityNodeInfoCompat.obtain(mView);
        ViewCompat.onInitializeAccessibilityNodeInfo(mView, accessibilitynodeinfocompat);
        LinkedList linkedlist = new LinkedList();
        getVisibleVirtualViews(linkedlist);
        Integer integer;
        for(Iterator iterator = linkedlist.iterator(); iterator.hasNext(); accessibilitynodeinfocompat.addChild(mView, integer.intValue()))
            integer = (Integer)iterator.next();

        return accessibilitynodeinfocompat;
    }

    private boolean intersectVisibleToUser(Rect rect)
    {
label0:
        {
            if(rect == null || rect.isEmpty() || mView.getWindowVisibility() != 0)
                break label0;
            android.view.ViewParent viewparent;
            View view;
            for(viewparent = mView.getParent(); viewparent instanceof View; viewparent = view.getParent())
            {
                view = (View)viewparent;
                if(ViewCompat.getAlpha(view) <= 0.0F || view.getVisibility() != 0)
                    break label0;
            }

            if(viewparent != null && mView.getLocalVisibleRect(mTempVisibleRect))
                return rect.intersect(mTempVisibleRect);
        }
        return false;
    }

    private boolean isAccessibilityFocused(int i)
    {
        return mFocusedVirtualViewId == i;
    }

    private boolean manageFocusForChild(int i, int j, Bundle bundle)
    {
        switch(j)
        {
        case 128: 
            return clearAccessibilityFocus(i);

        case 64: // '@'
            return requestAccessibilityFocus(i);
        }
        return false;
    }

    private boolean performAction(int i, int j, Bundle bundle)
    {
        switch(i)
        {
        case -1: 
            return performActionForHost(j, bundle);
        }
        return performActionForChild(i, j, bundle);
    }

    private boolean performActionForChild(int i, int j, Bundle bundle)
    {
        switch(j)
        {
        case 64: // '@'
        case 128: 
            return manageFocusForChild(i, j, bundle);
        }
        return onPerformActionForVirtualView(i, j, bundle);
    }

    private boolean performActionForHost(int i, Bundle bundle)
    {
        return ViewCompat.performAccessibilityAction(mView, i, bundle);
    }

    private boolean requestAccessibilityFocus(int i)
    {
        if(mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(mManager) && !isAccessibilityFocused(i))
        {
            mFocusedVirtualViewId = i;
            mView.invalidate();
            sendEventForVirtualView(i, 32768);
            return true;
        } else
        {
            return false;
        }
    }

    private void updateHoveredVirtualView(int i)
    {
        if(mHoveredVirtualViewId == i)
        {
            return;
        } else
        {
            int j = mHoveredVirtualViewId;
            mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(j, 256);
            return;
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionevent)
    {
label0:
        {
            boolean flag;
label1:
            {
                flag = true;
                if(mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(mManager))
                    switch(motionevent.getAction())
                    {
                    case 8: // '\b'
                    default:
                        break label0;

                    case 7: // '\007'
                    case 9: // '\t'
                        break label1;

                    case 10: // '\n'
                        if(mFocusedVirtualViewId != 0x80000000)
                        {
                            updateHoveredVirtualView(0x80000000);
                            return flag;
                        }
                        break;
                    }
                return false;
            }
            int i = getVirtualViewAt(motionevent.getX(), motionevent.getY());
            updateHoveredVirtualView(i);
            if(i == 0x80000000)
                flag = false;
            return flag;
        }
        return false;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view)
    {
        if(mNodeProvider == null)
            mNodeProvider = new ExploreByTouchNodeProvider();
        return mNodeProvider;
    }

    public int getFocusedVirtualView()
    {
        return mFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float f, float f1);

    protected abstract void getVisibleVirtualViews(List list);

    public void invalidateRoot()
    {
        invalidateVirtualView(-1);
    }

    public void invalidateVirtualView(int i)
    {
        sendEventForVirtualView(i, 2048);
    }

    protected abstract boolean onPerformActionForVirtualView(int i, int j, Bundle bundle);

    protected abstract void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityevent);

    protected abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilitynodeinfocompat);

    public boolean sendEventForVirtualView(int i, int j)
    {
        if(i != 0x80000000 && mManager.isEnabled())
        {
            android.view.ViewParent viewparent = mView.getParent();
            if(viewparent != null)
            {
                AccessibilityEvent accessibilityevent = createEvent(i, j);
                return ViewParentCompat.requestSendAccessibilityEvent(viewparent, mView, accessibilityevent);
            }
        }
        return false;
    }

    private static final String DEFAULT_CLASS_NAME = android/view/View.getName();
    public static final int INVALID_ID = 0x80000000;
    private int mFocusedVirtualViewId;
    private int mHoveredVirtualViewId;
    private final AccessibilityManager mManager;
    private ExploreByTouchNodeProvider mNodeProvider;
    private final int mTempGlobalRect[] = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final View mView;



}
