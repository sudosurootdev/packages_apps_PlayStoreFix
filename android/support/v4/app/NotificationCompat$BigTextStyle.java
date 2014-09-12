
package android.support.v4.app;



public static class setBuilder extends setBuilder
{

    public setBuilder bigText(CharSequence charsequence)
    {
        mBigText = charsequence;
        return this;
    }

    public mBigText setBigContentTitle(CharSequence charsequence)
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

    CharSequence mBigText;

    public ()
    {
    }

    public ( )
    {
        setBuilder();
    }
}
