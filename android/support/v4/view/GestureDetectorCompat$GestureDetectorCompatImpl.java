
package android.support.v4.view;

import android.view.MotionEvent;


static interface 
{

    public abstract boolean isLongpressEnabled();

    public abstract boolean onTouchEvent(MotionEvent motionevent);

    public abstract void setIsLongpressEnabled(boolean flag);

    public abstract void setOnDoubleTapListener(android.view.CompatImpl compatimpl);
}
