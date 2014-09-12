
package android.support.v4.view;

import android.view.MotionEvent;


static class 
    implements 
{

    public int findPointerIndex(MotionEvent motionevent, int i)
    {
        return i != 0 ? -1 : 0;
    }

    public int getPointerCount(MotionEvent motionevent)
    {
        return 1;
    }

    public int getPointerId(MotionEvent motionevent, int i)
    {
        if(i == 0)
            return 0;
        else
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float getX(MotionEvent motionevent, int i)
    {
        if(i == 0)
            return motionevent.getX();
        else
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float getY(MotionEvent motionevent, int i)
    {
        if(i == 0)
            return motionevent.getY();
        else
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    ()
    {
    }
}
