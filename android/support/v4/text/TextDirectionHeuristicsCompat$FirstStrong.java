
package android.support.v4.text;



private static class nAlgorithm
    implements nAlgorithm
{

    public int checkRtl(CharSequence charsequence, int i, int j)
    {
        int k = 2;
        int l = i;
        for(int i1 = i + j; l < i1 && k == 2; l++)
            k = TextDirectionHeuristicsCompat.access$100(Character.getDirectionality(charsequence.charAt(l)));

        return k;
    }

    public static final nAlgorithm INSTANCE = new <init>();


    private nAlgorithm()
    {
    }
}
