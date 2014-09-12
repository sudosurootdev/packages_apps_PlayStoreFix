
package android.support.v4.app;

import android.graphics.Bitmap;


public static class setBuilder extends setBuilder
{

    public setBuilder bigLargeIcon(Bitmap bitmap)
    {
        mBigLargeIcon = bitmap;
        mBigLargeIconSet = true;
        return this;
    }

    public mBigLargeIconSet bigPicture(Bitmap bitmap)
    {
        mPicture = bitmap;
        return this;
    }

    public mPicture setBigContentTitle(CharSequence charsequence)
    {
        mBigContentTitle = charsequence;
        return this;
    }

    public mBigContentTitle setSummaryText(CharSequence charsequence)
    {
        mSummaryText = charsequence;
        mSummaryTextSet = true;
        return this;
    }

    Bitmap mBigLargeIcon;
    boolean mBigLargeIconSet;
    Bitmap mPicture;

    public ()
    {
    }

    public ( )
    {
        setBuilder();
    }
}
