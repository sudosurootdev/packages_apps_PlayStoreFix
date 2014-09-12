
package android.support.v4.app;

import android.app.PendingIntent;


public static class actionIntent
{

    public PendingIntent actionIntent;
    public int icon;
    public CharSequence title;

    public (int i, CharSequence charsequence, PendingIntent pendingintent)
    {
        icon = i;
        title = charsequence;
        actionIntent = pendingintent;
    }
}
