
package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;


static class 
    implements 
{

    public boolean draw(Object obj, Canvas canvas)
    {
        return EdgeEffectCompatIcs.draw(obj, canvas);
    }

    public void finish(Object obj)
    {
        EdgeEffectCompatIcs.finish(obj);
    }

    public boolean isFinished(Object obj)
    {
        return EdgeEffectCompatIcs.isFinished(obj);
    }

    public Object newEdgeEffect(Context context)
    {
        return EdgeEffectCompatIcs.newEdgeEffect(context);
    }

    public boolean onAbsorb(Object obj, int i)
    {
        return EdgeEffectCompatIcs.onAbsorb(obj, i);
    }

    public boolean onPull(Object obj, float f)
    {
        return EdgeEffectCompatIcs.onPull(obj, f);
    }

    public boolean onRelease(Object obj)
    {
        return EdgeEffectCompatIcs.onRelease(obj);
    }

    public void setSize(Object obj, int i, int j)
    {
        EdgeEffectCompatIcs.setSize(obj, i, j);
    }

    ()
    {
    }
}
