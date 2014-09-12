
package android.support.v4.app;

import android.os.Bundle;


private static class mImpl extends ActivityOptionsCompat
{

    public Bundle toBundle()
    {
        return mImpl.toBundle();
    }

    public void update(ActivityOptionsCompat activityoptionscompat)
    {
        if(activityoptionscompat instanceof mImpl)
        {
            mImpl mimpl = (mImpl)activityoptionscompat;
            mImpl.update(mimpl.mImpl);
        }
    }

    private final ActivityOptionsCompatJB mImpl;

    (ActivityOptionsCompatJB activityoptionscompatjb)
    {
        mImpl = activityoptionscompatjb;
    }
}
