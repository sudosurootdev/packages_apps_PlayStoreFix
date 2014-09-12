
package android.support.v4.app;

import android.text.Html;

class ShareCompatJB
{

    ShareCompatJB()
    {
    }

    public static String escapeHtml(CharSequence charsequence)
    {
        return Html.escapeHtml(charsequence);
    }
}
