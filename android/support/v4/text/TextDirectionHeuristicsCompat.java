
package android.support.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;


public class TextDirectionHeuristicsCompat
{
    private static class AnyStrong
        implements TextDirectionAlgorithm
    {

        public int checkRtl(CharSequence charsequence, int i, int j)
        {
label0:
            {
                int k;
label1:
                {
                    k = 1;
                    boolean flag = false;
                    int l = i;
                    int i1 = i + j;
                    do
                    {
                        if(l >= i1)
                            break;
                        switch(TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charsequence.charAt(l))))
                        {
                        default:
                            break;

                        case 1: // '\001'
                            if(mLookForRtl)
                            {
                                flag = true;
                                break;
                            }
                            break label1;

                        case 0: // '\0'
                            if(mLookForRtl)
                            {
                                k = 0;
                                break label1;
                            }
                            flag = true;
                            break;
                        }
                        l++;
                    } while(true);
                    if(!flag)
                        break label0;
                    if(!mLookForRtl)
                        return 0;
                }
                return k;
            }
            return 2;
        }

        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        private final boolean mLookForRtl;


        private AnyStrong(boolean flag)
        {
            mLookForRtl = flag;
        }
    }

    private static class FirstStrong
        implements TextDirectionAlgorithm
    {

        public int checkRtl(CharSequence charsequence, int i, int j)
        {
            int k = 2;
            int l = i;
            for(int i1 = i + j; l < i1 && k == 2; l++)
                k = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charsequence.charAt(l)));

            return k;
        }

        public static final FirstStrong INSTANCE = new FirstStrong();


        private FirstStrong()
        {
        }
    }

    private static interface TextDirectionAlgorithm
    {

        public abstract int checkRtl(CharSequence charsequence, int i, int j);
    }

    private static abstract class TextDirectionHeuristicImpl
        implements TextDirectionHeuristicCompat
    {

        private boolean doCheck(CharSequence charsequence, int i, int j)
        {
            switch(mAlgorithm.checkRtl(charsequence, i, j))
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

        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textdirectionalgorithm)
        {
            mAlgorithm = textdirectionalgorithm;
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl
    {

        protected boolean defaultIsRtl()
        {
            return mDefaultIsRtl;
        }

        private final boolean mDefaultIsRtl;

        private TextDirectionHeuristicInternal(TextDirectionAlgorithm textdirectionalgorithm, boolean flag)
        {
            super(textdirectionalgorithm);
            mDefaultIsRtl = flag;
        }

    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl
    {

        protected boolean defaultIsRtl()
        {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }

        public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();


        public TextDirectionHeuristicLocale()
        {
            super(null);
        }
    }


    public TextDirectionHeuristicsCompat()
    {
    }

    private static int isRtlText(int i)
    {
        switch(i)
        {
        case 1: // '\001'
        case 2: // '\002'
            return 0;

        case 0: // '\0'
            return 1;
        }
        return 2;
    }

    private static int isRtlTextOrFormat(int i)
    {
        switch(i)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 16: // '\020'
        case 17: // '\021'
            return 0;

        case 0: // '\0'
        case 14: // '\016'
        case 15: // '\017'
            return 1;
        }
        return 2;
    }

    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal(null, false);
    public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal(null, true);
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    static 
    {
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }


}
