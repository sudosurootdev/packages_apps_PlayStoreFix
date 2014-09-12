
package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;


private static class mLocale extends SingleLineTransformationMethod
{

    public CharSequence getTransformation(CharSequence charsequence, View view)
    {
        CharSequence charsequence1 = super.getTransformation(charsequence, view);
        if(charsequence1 != null)
            return charsequence1.toString().toUpperCase(mLocale);
        else
            return null;
    }

    private static final String TAG = "SingleLineAllCapsTransform";
    private Locale mLocale;

    public (Context context)
    {
        mLocale = context.getResources().getConfiguration().locale;
    }
}
