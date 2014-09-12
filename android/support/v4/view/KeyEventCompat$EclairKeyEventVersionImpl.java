
package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;


static class  extends 
{

    public boolean dispatch(KeyEvent keyevent, android.view.ersionImpl ersionimpl, Object obj, Object obj1)
    {
        return KeyEventCompatEclair.dispatch(keyevent, ersionimpl, obj, obj1);
    }

    public Object getKeyDispatcherState(View view)
    {
        return KeyEventCompatEclair.getKeyDispatcherState(view);
    }

    public boolean isTracking(KeyEvent keyevent)
    {
        return KeyEventCompatEclair.isTracking(keyevent);
    }

    public void startTracking(KeyEvent keyevent)
    {
        KeyEventCompatEclair.startTracking(keyevent);
    }

    ()
    {
    }
}
