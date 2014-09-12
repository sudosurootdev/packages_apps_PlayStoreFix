
package android.support.v4.text;

import java.util.Locale;


private static class nit> extends nit>
{

    protected boolean defaultIsRtl()
    {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static final nit> INSTANCE = new <init>();


    public ()
    {
        super(null);
    }
}
