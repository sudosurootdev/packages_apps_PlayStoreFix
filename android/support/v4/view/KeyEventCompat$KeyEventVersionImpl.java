
package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;


static interface 
{

    public abstract boolean dispatch(KeyEvent keyevent, android.view.ersionImpl ersionimpl, Object obj, Object obj1);

    public abstract Object getKeyDispatcherState(View view);

    public abstract boolean isTracking(KeyEvent keyevent);

    public abstract boolean metaStateHasModifiers(int i, int j);

    public abstract boolean metaStateHasNoModifiers(int i);

    public abstract int normalizeMetaState(int i);

    public abstract void startTracking(KeyEvent keyevent);
}
