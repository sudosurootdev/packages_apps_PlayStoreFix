
package android.support.v4.view;

import android.view.MotionEvent;


static class 
    implements 
{

    public int findPointerIndex(MotionEvent motionevent, int i)
    {
        return MotionEventCompatEclair.findPointerIndex(motionevent, i);
    }

    public int getPointerCount(MotionEvent motionevent)
    {
        return MotionEventCompatEclair.getPointerCount(motionevent);
    }

    public int getPointerId(MotionEvent motionevent, int i)
    {
        return MotionEventCompatEclair.getPointerId(motionevent, i);
    }

    public float getX(MotionEvent motionevent, int i)
    {
        return MotionEventCompatEclair.getX(motionevent, i);
    }

    public float getY(MotionEvent motionevent, int i)
    {
        return MotionEventCompatEclair.getY(motionevent, i);
    }

    ()
    {
    }
}
