
package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

class TaskStackBuilderHoneycomb
{

    TaskStackBuilderHoneycomb()
    {
    }

    public static PendingIntent getActivitiesPendingIntent(Context context, int i, Intent aintent[], int j)
    {
        return PendingIntent.getActivities(context, i, aintent, j);
    }
}
