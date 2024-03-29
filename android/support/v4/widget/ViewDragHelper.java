
package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.*;
import android.util.DisplayMetrics;
import android.view.*;
import android.view.animation.Interpolator;
import java.util.Arrays;


public class ViewDragHelper
{
    public static abstract class Callback
    {

        public int clampViewPositionHorizontal(View view, int i, int j)
        {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int j)
        {
            return 0;
        }

        public int getOrderedChildIndex(int i)
        {
            return i;
        }

        public int getViewHorizontalDragRange(View view)
        {
            return 0;
        }

        public int getViewVerticalDragRange(View view)
        {
            return 0;
        }

        public void onEdgeDragStarted(int i, int j)
        {
        }

        public boolean onEdgeLock(int i)
        {
            return false;
        }

        public void onEdgeTouched(int i, int j)
        {
        }

        public void onViewCaptured(View view, int i)
        {
        }

        public void onViewDragStateChanged(int i)
        {
        }

        public void onViewPositionChanged(View view, int i, int j, int k, int l)
        {
        }

        public void onViewReleased(View view, float f, float f1)
        {
        }

        public abstract boolean tryCaptureView(View view, int i);

        public Callback()
        {
        }
    }


    private ViewDragHelper(Context context, ViewGroup viewgroup, Callback callback)
    {
        mActivePointerId = -1;
        if(viewgroup == null)
            throw new IllegalArgumentException("Parent view may not be null");
        if(callback == null)
        {
            throw new IllegalArgumentException("Callback may not be null");
        } else
        {
            mParentView = viewgroup;
            mCallback = callback;
            ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
            mEdgeSize = (int)(0.5F + 20F * context.getResources().getDisplayMetrics().density);
            mTouchSlop = viewconfiguration.getScaledTouchSlop();
            mMaxVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
            mMinVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
            mScroller = ScrollerCompat.create(context, sInterpolator);
            return;
        }
    }

    private boolean checkNewEdgeDrag(float f, float f1, int i, int j)
    {
        float f2 = Math.abs(f);
        float f3 = Math.abs(f1);
        if((j & mInitialEdgesTouched[i]) == j && (j & mTrackingEdges) != 0 && (j & mEdgeDragsLocked[i]) != j && (j & mEdgeDragsInProgress[i]) != j && (f2 > (float)mTouchSlop || f3 > (float)mTouchSlop))
        {
            if(f2 < 0.5F * f3 && mCallback.onEdgeLock(j))
            {
                int ai[] = mEdgeDragsLocked;
                ai[i] = j | ai[i];
                return false;
            }
            if((j & mEdgeDragsInProgress[i]) == 0 && f2 > (float)mTouchSlop)
                return true;
        }
        return false;
    }

    private boolean checkTouchSlop(View view, float f, float f1)
    {
label0:
        {
            boolean flag = true;
            if(view == null)
            {
                flag = false;
            } else
            {
                boolean flag1;
                if(mCallback.getViewHorizontalDragRange(view) > 0)
                    flag1 = flag;
                else
                    flag1 = false;
                boolean flag2;
                if(mCallback.getViewVerticalDragRange(view) > 0)
                    flag2 = flag;
                else
                    flag2 = false;
                if(flag1 && flag2)
                {
                    if(f * f + f1 * f1 <= (float)(mTouchSlop * mTouchSlop))
                        return false;
                } else
                if(flag1)
                {
                    if(Math.abs(f) <= (float)mTouchSlop)
                        return false;
                } else
                {
                    if(!flag2)
                        break label0;
                    if(Math.abs(f1) <= (float)mTouchSlop)
                        return false;
                }
            }
            return flag;
        }
        return false;
    }

    private float clampMag(float f, float f1, float f2)
    {
label0:
        {
            float f3 = Math.abs(f);
            if(f3 < f1)
            {
                f2 = 0.0F;
            } else
            {
                if(f3 <= f2)
                    break label0;
                if(f <= 0.0F)
                    return -f2;
            }
            return f2;
        }
        return f;
    }

    private int clampMag(int i, int j, int k)
    {
label0:
        {
            int l = Math.abs(i);
            if(l < j)
            {
                k = 0;
            } else
            {
                if(l <= k)
                    break label0;
                if(i <= 0)
                    return -k;
            }
            return k;
        }
        return i;
    }

    private void clearMotionHistory()
    {
        if(mInitialMotionX == null)
        {
            return;
        } else
        {
            Arrays.fill(mInitialMotionX, 0.0F);
            Arrays.fill(mInitialMotionY, 0.0F);
            Arrays.fill(mLastMotionX, 0.0F);
            Arrays.fill(mLastMotionY, 0.0F);
            Arrays.fill(mInitialEdgesTouched, 0);
            Arrays.fill(mEdgeDragsInProgress, 0);
            Arrays.fill(mEdgeDragsLocked, 0);
            mPointersDown = 0;
            return;
        }
    }

    private void clearMotionHistory(int i)
    {
        if(mInitialMotionX == null)
        {
            return;
        } else
        {
            mInitialMotionX[i] = 0.0F;
            mInitialMotionY[i] = 0.0F;
            mLastMotionX[i] = 0.0F;
            mLastMotionY[i] = 0.0F;
            mInitialEdgesTouched[i] = 0;
            mEdgeDragsInProgress[i] = 0;
            mEdgeDragsLocked[i] = 0;
            mPointersDown = mPointersDown & (-1 ^ 1 << i);
            return;
        }
    }

    private int computeAxisDuration(int i, int j, int k)
    {
        if(i == 0)
            return 0;
        int l = mParentView.getWidth();
        int i1 = l / 2;
        float f = Math.min(1.0F, (float)Math.abs(i) / (float)l);
        float f1 = (float)i1 + (float)i1 * distanceInfluenceForSnapDuration(f);
        int j1 = Math.abs(j);
        int k1;
        if(j1 > 0)
            k1 = 4 * Math.round(1000F * Math.abs(f1 / (float)j1));
        else
            k1 = (int)(256F * (1.0F + (float)Math.abs(i) / (float)k));
        return Math.min(k1, 600);
    }

    private int computeSettleDuration(View view, int i, int j, int k, int l)
    {
        int i1 = clampMag(k, (int)mMinVelocity, (int)mMaxVelocity);
        int j1 = clampMag(l, (int)mMinVelocity, (int)mMaxVelocity);
        int k1 = Math.abs(i);
        int l1 = Math.abs(j);
        int i2 = Math.abs(i1);
        int j2 = Math.abs(j1);
        int k2 = i2 + j2;
        int l2 = k1 + l1;
        float f;
        if(i1 != 0)
            f = (float)i2 / (float)k2;
        else
            f = (float)k1 / (float)l2;
        float f1;
        if(j1 != 0)
            f1 = (float)j2 / (float)k2;
        else
            f1 = (float)l1 / (float)l2;
        int i3 = computeAxisDuration(i, i1, mCallback.getViewHorizontalDragRange(view));
        int j3 = computeAxisDuration(j, j1, mCallback.getViewVerticalDragRange(view));
        return (int)(f * (float)i3 + f1 * (float)j3);
    }

    public static ViewDragHelper create(ViewGroup viewgroup, float f, Callback callback)
    {
        ViewDragHelper viewdraghelper = create(viewgroup, callback);
        viewdraghelper.mTouchSlop = (int)((float)viewdraghelper.mTouchSlop * (1.0F / f));
        return viewdraghelper;
    }

    public static ViewDragHelper create(ViewGroup viewgroup, Callback callback)
    {
        return new ViewDragHelper(viewgroup.getContext(), viewgroup, callback);
    }

    private void dispatchViewReleased(float f, float f1)
    {
        mReleaseInProgress = true;
        mCallback.onViewReleased(mCapturedView, f, f1);
        mReleaseInProgress = false;
        if(mDragState == 1)
            setDragState(0);
    }

    private float distanceInfluenceForSnapDuration(float f)
    {
        return (float)Math.sin((float)(0.4712389167638204D * (double)(f - 0.5F)));
    }

    private void dragTo(int i, int j, int k, int l)
    {
        int i1 = i;
        int j1 = j;
        int k1 = mCapturedView.getLeft();
        int l1 = mCapturedView.getTop();
        if(k != 0)
        {
            i1 = mCallback.clampViewPositionHorizontal(mCapturedView, i, k);
            mCapturedView.offsetLeftAndRight(i1 - k1);
        }
        if(l != 0)
        {
            j1 = mCallback.clampViewPositionVertical(mCapturedView, j, l);
            mCapturedView.offsetTopAndBottom(j1 - l1);
        }
        if(k != 0 || l != 0)
        {
            int i2 = i1 - k1;
            int j2 = j1 - l1;
            mCallback.onViewPositionChanged(mCapturedView, i1, j1, i2, j2);
        }
    }

    private void ensureMotionHistorySizeForId(int i)
    {
        if(mInitialMotionX == null || mInitialMotionX.length <= i)
        {
            float af[] = new float[i + 1];
            float af1[] = new float[i + 1];
            float af2[] = new float[i + 1];
            float af3[] = new float[i + 1];
            int ai[] = new int[i + 1];
            int ai1[] = new int[i + 1];
            int ai2[] = new int[i + 1];
            if(mInitialMotionX != null)
            {
                System.arraycopy(mInitialMotionX, 0, af, 0, mInitialMotionX.length);
                System.arraycopy(mInitialMotionY, 0, af1, 0, mInitialMotionY.length);
                System.arraycopy(mLastMotionX, 0, af2, 0, mLastMotionX.length);
                System.arraycopy(mLastMotionY, 0, af3, 0, mLastMotionY.length);
                System.arraycopy(mInitialEdgesTouched, 0, ai, 0, mInitialEdgesTouched.length);
                System.arraycopy(mEdgeDragsInProgress, 0, ai1, 0, mEdgeDragsInProgress.length);
                System.arraycopy(mEdgeDragsLocked, 0, ai2, 0, mEdgeDragsLocked.length);
            }
            mInitialMotionX = af;
            mInitialMotionY = af1;
            mLastMotionX = af2;
            mLastMotionY = af3;
            mInitialEdgesTouched = ai;
            mEdgeDragsInProgress = ai1;
            mEdgeDragsLocked = ai2;
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int j, int k, int l)
    {
        int i1 = mCapturedView.getLeft();
        int j1 = mCapturedView.getTop();
        int k1 = i - i1;
        int l1 = j - j1;
        if(k1 == 0 && l1 == 0)
        {
            mScroller.abortAnimation();
            setDragState(0);
            return false;
        } else
        {
            int i2 = computeSettleDuration(mCapturedView, k1, l1, k, l);
            mScroller.startScroll(i1, j1, k1, l1, i2);
            setDragState(2);
            return true;
        }
    }

    private int getEdgesTouched(int i, int j)
    {
        int k = mParentView.getLeft() + mEdgeSize;
        int l = 0;
        if(i < k)
            l = false | true;
        if(j < mParentView.getTop() + mEdgeSize)
            l |= 4;
        if(i > mParentView.getRight() - mEdgeSize)
            l |= 2;
        if(j > mParentView.getBottom() - mEdgeSize)
            l |= 8;
        return l;
    }

    private void releaseViewForPointerUp()
    {
        mVelocityTracker.computeCurrentVelocity(1000, mMaxVelocity);
        dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), mMinVelocity, mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId), mMinVelocity, mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f, float f1, int i)
    {
        boolean flag = checkNewEdgeDrag(f, f1, i, 1);
        int j = 0;
        if(flag)
            j = false | true;
        if(checkNewEdgeDrag(f1, f, i, 4))
            j |= 4;
        if(checkNewEdgeDrag(f, f1, i, 2))
            j |= 2;
        if(checkNewEdgeDrag(f1, f, i, 8))
            j |= 8;
        if(j != 0)
        {
            int ai[] = mEdgeDragsInProgress;
            ai[i] = j | ai[i];
            mCallback.onEdgeDragStarted(j, i);
        }
    }

    private void saveInitialMotion(float f, float f1, int i)
    {
        ensureMotionHistorySizeForId(i);
        float af[] = mInitialMotionX;
        mLastMotionX[i] = f;
        af[i] = f;
        float af1[] = mInitialMotionY;
        mLastMotionY[i] = f1;
        af1[i] = f1;
        mInitialEdgesTouched[i] = getEdgesTouched((int)f, (int)f1);
        mPointersDown = mPointersDown | 1 << i;
    }

    private void saveLastMotion(MotionEvent motionevent)
    {
        int i = MotionEventCompat.getPointerCount(motionevent);
        for(int j = 0; j < i; j++)
        {
            int k = MotionEventCompat.getPointerId(motionevent, j);
            float f = MotionEventCompat.getX(motionevent, j);
            float f1 = MotionEventCompat.getY(motionevent, j);
            mLastMotionX[k] = f;
            mLastMotionY[k] = f1;
        }

    }

    public void abort()
    {
        cancel();
        if(mDragState == 2)
        {
            int i = mScroller.getCurrX();
            int j = mScroller.getCurrY();
            mScroller.abortAnimation();
            int k = mScroller.getCurrX();
            int l = mScroller.getCurrY();
            mCallback.onViewPositionChanged(mCapturedView, k, l, k - i, l - j);
        }
        setDragState(0);
    }

    protected boolean canScroll(View view, boolean flag, int i, int j, int k, int l)
    {
        if(view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = view.getScrollX();
            int j1 = view.getScrollY();
            for(int k1 = -1 + viewgroup.getChildCount(); k1 >= 0; k1--)
            {
                View view1 = viewgroup.getChildAt(k1);
                if(k + i1 >= view1.getLeft() && k + i1 < view1.getRight() && l + j1 >= view1.getTop() && l + j1 < view1.getBottom() && canScroll(view1, true, i, j, (k + i1) - view1.getLeft(), (l + j1) - view1.getTop()))
                    return true;
            }

        }
        return flag && (ViewCompat.canScrollHorizontally(view, -i) || ViewCompat.canScrollVertically(view, -j));
    }

    public void cancel()
    {
        mActivePointerId = -1;
        clearMotionHistory();
        if(mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    public void captureChildView(View view, int i)
    {
        if(view.getParent() != mParentView)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (").append(mParentView).append(")").toString());
        } else
        {
            mCapturedView = view;
            mActivePointerId = i;
            mCallback.onViewCaptured(view, i);
            setDragState(1);
            return;
        }
    }

    public boolean checkTouchSlop(int i)
    {
        int j = mInitialMotionX.length;
        for(int k = 0; k < j; k++)
            if(checkTouchSlop(i, k))
                return true;

        return false;
    }

    public boolean checkTouchSlop(int i, int j)
    {
label0:
        {
            boolean flag = true;
            if(!isPointerDown(j))
            {
                flag = false;
            } else
            {
                int k;
                if((i & 1) == flag)
                    k = ((flag) ? 1 : 0);
                else
                    k = 0;
                int l;
                if((i & 2) == 2)
                    l = ((flag) ? 1 : 0);
                else
                    l = 0;
                float f = mLastMotionX[j] - mInitialMotionX[j];
                float f1 = mLastMotionY[j] - mInitialMotionY[j];
                if(k != 0 && l != 0)
                {
                    if(f * f + f1 * f1 <= (float)(mTouchSlop * mTouchSlop))
                        return false;
                } else
                if(k != 0)
                {
                    if(Math.abs(f) <= (float)mTouchSlop)
                        return false;
                } else
                {
                    if(l == 0)
                        break label0;
                    if(Math.abs(f1) <= (float)mTouchSlop)
                        return false;
                }
            }
            return flag;
        }
        return false;
    }

    public boolean continueSettling(boolean flag)
    {
        if(mDragState == 2)
        {
            boolean flag1 = mScroller.computeScrollOffset();
            int i = mScroller.getCurrX();
            int j = mScroller.getCurrY();
            int k = i - mCapturedView.getLeft();
            int l = j - mCapturedView.getTop();
            if(k != 0)
                mCapturedView.offsetLeftAndRight(k);
            if(l != 0)
                mCapturedView.offsetTopAndBottom(l);
            if(k != 0 || l != 0)
                mCallback.onViewPositionChanged(mCapturedView, i, j, k, l);
            if(flag1 && i == mScroller.getFinalX() && j == mScroller.getFinalY())
            {
                mScroller.abortAnimation();
                flag1 = mScroller.isFinished();
            }
            if(!flag1)
                if(flag)
                    mParentView.post(mSetIdleRunnable);
                else
                    setDragState(0);
        }
        return mDragState == 2;
    }

    public View findTopChildUnder(int i, int j)
    {
        for(int k = -1 + mParentView.getChildCount(); k >= 0; k--)
        {
            View view = mParentView.getChildAt(mCallback.getOrderedChildIndex(k));
            if(i >= view.getLeft() && i < view.getRight() && j >= view.getTop() && j < view.getBottom())
                return view;
        }

        return null;
    }

    public void flingCapturedView(int i, int j, int k, int l)
    {
        if(!mReleaseInProgress)
        {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        } else
        {
            mScroller.fling(mCapturedView.getLeft(), mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId), i, k, j, l);
            setDragState(2);
            return;
        }
    }

    public int getActivePointerId()
    {
        return mActivePointerId;
    }

    public View getCapturedView()
    {
        return mCapturedView;
    }

    public int getEdgeSize()
    {
        return mEdgeSize;
    }

    public float getMinVelocity()
    {
        return mMinVelocity;
    }

    public int getTouchSlop()
    {
        return mTouchSlop;
    }

    public int getViewDragState()
    {
        return mDragState;
    }

    public boolean isCapturedViewUnder(int i, int j)
    {
        return isViewUnder(mCapturedView, i, j);
    }

    public boolean isEdgeTouched(int i)
    {
        int j = mInitialEdgesTouched.length;
        for(int k = 0; k < j; k++)
            if(isEdgeTouched(i, k))
                return true;

        return false;
    }

    public boolean isEdgeTouched(int i, int j)
    {
        return isPointerDown(j) && (i & mInitialEdgesTouched[j]) != 0;
    }

    public boolean isPointerDown(int i)
    {
        return (mPointersDown & 1 << i) != 0;
    }

    public boolean isViewUnder(View view, int i, int j)
    {
        return view != null && i >= view.getLeft() && i < view.getRight() && j >= view.getTop() && j < view.getBottom();
    }

    public void processTouchEvent(MotionEvent motionevent)
    {
        int i;
        int j;
        i = MotionEventCompat.getActionMasked(motionevent);
        j = MotionEventCompat.getActionIndex(motionevent);
        if(i == 0)
            cancel();
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(motionevent);
        i;
        JVM INSTR tableswitch 0 6: default 685
    //                   0 599
    //                   1 103
    //                   2 255
    //                   3 84
    //                   4 685
    //                   5 483
    //                   6 120;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        if(mDragState == 1)
            dispatchViewReleased(0.0F, 0.0F);
        cancel();
        return;
_L3:
        if(mDragState == 1)
            releaseViewForPointerUp();
        cancel();
        return;
_L7:
        int i3 = MotionEventCompat.getPointerId(motionevent, j);
        if(mDragState != 1 || i3 != mActivePointerId) goto _L9; else goto _L8
_L8:
        int j3;
        int k3;
        int l3;
        j3 = -1;
        k3 = MotionEventCompat.getPointerCount(motionevent);
        l3 = 0;
_L16:
        if(l3 >= k3) goto _L11; else goto _L10
_L10:
        int i4 = MotionEventCompat.getPointerId(motionevent, l3);
        if(i4 == mActivePointerId) goto _L13; else goto _L12
_L12:
        float f10;
        float f11;
        f10 = MotionEventCompat.getX(motionevent, l3);
        f11 = MotionEventCompat.getY(motionevent, l3);
        if(findTopChildUnder((int)f10, (int)f11) != mCapturedView || !tryCaptureViewForDrag(mCapturedView, i4)) goto _L13; else goto _L14
_L14:
        j3 = mActivePointerId;
_L11:
        if(j3 == -1)
            releaseViewForPointerUp();
_L9:
        clearMotionHistory(i3);
        return;
_L13:
        l3++;
        if(true) goto _L16; else goto _L15
_L15:
        break; /* Loop/switch isn't completed */
_L4:
        if(mDragState == 1)
        {
            int j2 = MotionEventCompat.findPointerIndex(motionevent, mActivePointerId);
            float f8 = MotionEventCompat.getX(motionevent, j2);
            float f9 = MotionEventCompat.getY(motionevent, j2);
            int k2 = (int)(f8 - mLastMotionX[mActivePointerId]);
            int l2 = (int)(f9 - mLastMotionY[mActivePointerId]);
            dragTo(k2 + mCapturedView.getLeft(), l2 + mCapturedView.getTop(), k2, l2);
            saveLastMotion(motionevent);
            return;
        }
        int k1 = MotionEventCompat.getPointerCount(motionevent);
        int l1 = 0;
        do
        {
            if(l1 >= k1)
                break;
            int i2 = MotionEventCompat.getPointerId(motionevent, l1);
            float f4 = MotionEventCompat.getX(motionevent, l1);
            float f5 = MotionEventCompat.getY(motionevent, l1);
            float f6 = f4 - mInitialMotionX[i2];
            float f7 = f5 - mInitialMotionY[i2];
            reportNewEdgeDrags(f6, f7, i2);
            if(mDragState == 1)
                break;
            View view1 = findTopChildUnder((int)f4, (int)f5);
            if(checkTouchSlop(view1, f6, f7) && tryCaptureViewForDrag(view1, i2))
                break;
            l1++;
        } while(true);
        saveLastMotion(motionevent);
        return;
_L6:
        int i1 = MotionEventCompat.getPointerId(motionevent, j);
        float f2 = MotionEventCompat.getX(motionevent, j);
        float f3 = MotionEventCompat.getY(motionevent, j);
        saveInitialMotion(f2, f3, i1);
        if(mDragState == 0)
        {
            tryCaptureViewForDrag(findTopChildUnder((int)f2, (int)f3), i1);
            int j1 = mInitialEdgesTouched[i1];
            if((j1 & mTrackingEdges) != 0)
            {
                mCallback.onEdgeTouched(j1 & mTrackingEdges, i1);
                return;
            }
        } else
        if(isCapturedViewUnder((int)f2, (int)f3))
        {
            tryCaptureViewForDrag(mCapturedView, i1);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        int k = MotionEventCompat.getPointerId(motionevent, 0);
        View view = findTopChildUnder((int)f, (int)f1);
        saveInitialMotion(f, f1, k);
        tryCaptureViewForDrag(view, k);
        int l = mInitialEdgesTouched[k];
        if((l & mTrackingEdges) != 0)
        {
            mCallback.onEdgeTouched(l & mTrackingEdges, k);
            return;
        }
    }

    void setDragState(int i)
    {
        if(mDragState != i)
        {
            mDragState = i;
            mCallback.onViewDragStateChanged(i);
            if(i == 0)
                mCapturedView = null;
        }
    }

    public void setEdgeTrackingEnabled(int i)
    {
        mTrackingEdges = i;
    }

    public void setMinVelocity(float f)
    {
        mMinVelocity = f;
    }

    public boolean settleCapturedViewAt(int i, int j)
    {
        if(!mReleaseInProgress)
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        else
            return forceSettleCapturedViewAt(i, j, (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId));
    }

    public boolean shouldInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = MotionEventCompat.getActionMasked(motionevent);
        int j = MotionEventCompat.getActionIndex(motionevent);
        if(i == 0)
            cancel();
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(motionevent);
        switch(i)
        {
        case 1: // '\001'
        case 3: // '\003'
            cancel();
            break;

        case 6: // '\006'
            clearMotionHistory(MotionEventCompat.getPointerId(motionevent, j));
            break;

        case 2: // '\002'
            int k1 = MotionEventCompat.getPointerCount(motionevent);
            int l1 = 0;
            do
            {
                if(l1 >= k1)
                    break;
                int i2 = MotionEventCompat.getPointerId(motionevent, l1);
                float f4 = MotionEventCompat.getX(motionevent, l1);
                float f5 = MotionEventCompat.getY(motionevent, l1);
                float f6 = f4 - mInitialMotionX[i2];
                float f7 = f5 - mInitialMotionY[i2];
                reportNewEdgeDrags(f6, f7, i2);
                if(mDragState == 1)
                    break;
                View view2 = findTopChildUnder((int)f4, (int)f5);
                if(view2 != null && checkTouchSlop(view2, f6, f7) && tryCaptureViewForDrag(view2, i2))
                    break;
                l1++;
            } while(true);
            saveLastMotion(motionevent);
            break;

        case 5: // '\005'
            int i1 = MotionEventCompat.getPointerId(motionevent, j);
            float f2 = MotionEventCompat.getX(motionevent, j);
            float f3 = MotionEventCompat.getY(motionevent, j);
            saveInitialMotion(f2, f3, i1);
            if(mDragState == 0)
            {
                int j1 = mInitialEdgesTouched[i1];
                if((j1 & mTrackingEdges) != 0)
                    mCallback.onEdgeTouched(j1 & mTrackingEdges, i1);
            } else
            if(mDragState == 2)
            {
                View view1 = findTopChildUnder((int)f2, (int)f3);
                if(view1 == mCapturedView)
                    tryCaptureViewForDrag(view1, i1);
            }
            break;

        case 0: // '\0'
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            int k = MotionEventCompat.getPointerId(motionevent, 0);
            saveInitialMotion(f, f1, k);
            View view = findTopChildUnder((int)f, (int)f1);
            if(view == mCapturedView && mDragState == 2)
                tryCaptureViewForDrag(view, k);
            int l = mInitialEdgesTouched[k];
            if((l & mTrackingEdges) != 0)
                mCallback.onEdgeTouched(l & mTrackingEdges, k);
            break;
        }
        return mDragState == 1;
    }

    public boolean smoothSlideViewTo(View view, int i, int j)
    {
        mCapturedView = view;
        mActivePointerId = -1;
        return forceSettleCapturedViewAt(i, j, 0, 0);
    }

    boolean tryCaptureViewForDrag(View view, int i)
    {
        if(view == mCapturedView && mActivePointerId == i)
            return true;
        if(view != null && mCallback.tryCaptureView(view, i))
        {
            mActivePointerId = i;
            captureChildView(view, i);
            return true;
        } else
        {
            return false;
        }
    }

    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() {

        public float getInterpolation(float f)
        {
            float f1 = f - 1.0F;
            return 1.0F + f1 * (f1 * (f1 * (f1 * f1)));
        }

    };
    private int mActivePointerId;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int mEdgeDragsInProgress[];
    private int mEdgeDragsLocked[];
    private int mEdgeSize;
    private int mInitialEdgesTouched[];
    private float mInitialMotionX[];
    private float mInitialMotionY[];
    private float mLastMotionX[];
    private float mLastMotionY[];
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable = new Runnable() {

        public void run()
        {
            setDragState(0);
        }

        final ViewDragHelper this$0;

            
            {
                this$0 = ViewDragHelper.this;
                super();
            }
    };
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

}
