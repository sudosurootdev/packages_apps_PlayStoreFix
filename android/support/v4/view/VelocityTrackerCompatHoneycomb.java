
package android.support.v4.view;

import android.view.VelocityTracker;

class VelocityTrackerCompatHoneycomb
{

    VelocityTrackerCompatHoneycomb()
    {
    }

    public static float getXVelocity(VelocityTracker velocitytracker, int i)
    {
        return velocitytracker.getXVelocity(i);
    }

    public static float getYVelocity(VelocityTracker velocitytracker, int i)
    {
        return velocitytracker.getYVelocity(i);
    }
}
