
package android.support.v4.app;

import java.util.ArrayList;


public static class setBuilder extends setBuilder
{

    public setBuilder addLine(CharSequence charsequence)
    {
        mTexts.add(charsequence);
        return this;
    }

    public mTexts setBigContentTitle(CharSequence charsequence)
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

    ArrayList mTexts;

    public ()
    {
        mTexts = new ArrayList();
    }

    public mTexts(mTexts mtexts)
    {
        mTexts = new ArrayList();
        setBuilder(mtexts);
    }
}
