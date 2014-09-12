
package android.support.v4.app;

import android.app.Notification;


public static abstract class mSummaryTextSet
{

    public Notification build()
    {
        r r = mBuilder;
        Notification notification = null;
        if(r != null)
            notification = mBuilder.build();
        return notification;
    }

    public void setBuilder(r r)
    {
        if(mBuilder != r)
        {
            mBuilder = r;
            if(mBuilder != null)
                mBuilder.setStyle(this);
        }
    }

    CharSequence mBigContentTitle;
    r mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet;

    public r()
    {
        mSummaryTextSet = false;
    }
}
