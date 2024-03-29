
package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class PagerTitleStripIcs
{
    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod
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

        public SingleLineAllCapsTransform(Context context)
        {
            mLocale = context.getResources().getConfiguration().locale;
        }
    }


    PagerTitleStripIcs()
    {
    }

    public static void setSingleLineAllCaps(TextView textview)
    {
        textview.setTransformationMethod(new SingleLineAllCapsTransform(textview.getContext()));
    }
}
