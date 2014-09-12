
package android.support.v4.view;

import android.view.animation.Interpolator;


static final class 
    implements Interpolator
{

    public float getInterpolation(float f)
    {
        float f1 = f - 1.0F;
        return 1.0F + f1 * (f1 * (f1 * (f1 * f1)));
    }

    ()
    {
    }
}
