
package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;


static interface 
{

    public abstract boolean draw(Object obj, Canvas canvas);

    public abstract void finish(Object obj);

    public abstract boolean isFinished(Object obj);

    public abstract Object newEdgeEffect(Context context);

    public abstract boolean onAbsorb(Object obj, int i);

    public abstract boolean onPull(Object obj, float f);

    public abstract boolean onRelease(Object obj);

    public abstract void setSize(Object obj, int i, int j);
}
