
package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;


static interface A
{

    public abstract void abortAnimation(Object obj);

    public abstract boolean computeScrollOffset(Object obj);

    public abstract Object createScroller(Context context, Interpolator interpolator);

    public abstract void fling(Object obj, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1);

    public abstract void fling(Object obj, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2);

    public abstract float getCurrVelocity(Object obj);

    public abstract int getCurrX(Object obj);

    public abstract int getCurrY(Object obj);

    public abstract int getFinalX(Object obj);

    public abstract int getFinalY(Object obj);

    public abstract boolean isFinished(Object obj);

    public abstract boolean isOverScrolled(Object obj);

    public abstract void notifyHorizontalEdgeReached(Object obj, int i, int j, int k);

    public abstract void notifyVerticalEdgeReached(Object obj, int i, int j, int k);

    public abstract void startScroll(Object obj, int i, int j, int k, int l);

    public abstract void startScroll(Object obj, int i, int j, int k, int l, int i1);
}
