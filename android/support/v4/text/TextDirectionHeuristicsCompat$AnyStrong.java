
package android.support.v4.text;



private static class mLookForRtl
    implements ionAlgorithm
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
                    switch(TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(charsequence.charAt(l))))
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

    public static final mLookForRtl INSTANCE_LTR = new <init>(false);
    public static final <init> INSTANCE_RTL = new <init>(true);
    private final boolean mLookForRtl;


    private ionAlgorithm(boolean flag)
    {
        mLookForRtl = flag;
    }
}
