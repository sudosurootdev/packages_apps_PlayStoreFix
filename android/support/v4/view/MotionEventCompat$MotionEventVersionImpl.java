
package android.support.v4.view;

import android.view.MotionEvent;


static interface 
{

    public abstract int findPointerIndex(MotionEvent motionevent, int i);

    public abstract int getPointerCount(MotionEvent motionevent);

    public abstract int getPointerId(MotionEvent motionevent, int i);

    public abstract float getX(MotionEvent motionevent, int i);

    public abstract float getY(MotionEvent motionevent, int i);
}
