
package android.support.v4.text;

import java.nio.CharBuffer;


private static abstract class mAlgorithm
    implements TextDirectionHeuristicCompat
{

    private boolean doCheck(CharSequence charsequence, int i, int j)
    {
        switch(mAlgorithm.kRtl(charsequence, i, j))
        {
        case 1: // '\001'
            return false;

        case 0: // '\0'
            return true;
        }
        return defaultIsRtl();
    }

    protected abstract boolean defaultIsRtl();

    public boolean isRtl(CharSequence charsequence, int i, int j)
    {
        if(charsequence != null && i >= 0 && j >= 0 && charsequence.length() - j >= i)
        {
            if(mAlgorithm == null)
                return defaultIsRtl();
            else
                return doCheck(charsequence, i, j);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public boolean isRtl(char ac[], int i, int j)
    {
        return isRtl(((CharSequence) (CharBuffer.wrap(ac))), i, j);
    }

    private final isRtl mAlgorithm;

    public ( )
    {
        mAlgorithm = ;
    }
}
