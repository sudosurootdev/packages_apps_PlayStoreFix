
package android.support.v4.view;

import android.view.VelocityTracker;


public class VelocityTrackerCompat
{
    static class BaseVelocityTrackerVersionImpl
        implements VelocityTrackerVersionImpl
    {

        public float getXVelocity(VelocityTracker velocitytracker, int i)
        {
            return velocitytracker.getXVelocity();
        }

        public float getYVelocity(VelocityTracker velocitytracker, int i)
        {
            return velocitytracker.getYVelocity();
        }

        BaseVelocityTrackerVersionImpl()
        {
        }
    }

    static class HoneycombVelocityTrackerVersionImpl
        implements VelocityTrackerVersionImpl
    {

        public float getXVelocity(VelocityTracker velocitytracker, int i)
        {
            return VelocityTrackerCompatHoneycomb.getXVelocity(velocitytracker, i);
        }

        public float getYVelocity(VelocityTracker velocitytracker, int i)
        {
            return VelocityTrackerCompatHoneycomb.getYVelocity(velocitytracker, i);
        }

        HoneycombVelocityTrackerVersionImpl()
        {
        }
    }

    static interface VelocityTrackerVersionImpl
    {

        public abstract float getXVelocity(VelocityTracker velocitytracker, int i);

        public abstract float getYVelocity(VelocityTracker velocitytracker, int i);
    }


    public VelocityTrackerCompat()
    {
    }

    public static float getXVelocity(VelocityTracker velocitytracker, int i)
    {
        return IMPL.getXVelocity(velocitytracker, i);
    }

    public static float getYVelocity(VelocityTracker velocitytracker, int i)
    {
        return IMPL.getYVelocity(velocitytracker, i);
    }

    static final VelocityTrackerVersionImpl IMPL;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT >= 11)
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        else
            IMPL = new BaseVelocityTrackerVersionImpl();
    }
}
