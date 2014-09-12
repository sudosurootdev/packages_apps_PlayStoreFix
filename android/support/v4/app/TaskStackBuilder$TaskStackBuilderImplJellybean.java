
package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


static class 
    implements 
{

    public PendingIntent getPendingIntent(Context context, Intent aintent[], int i, int j, Bundle bundle)
    {
        aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
        return TaskStackBuilderJellybean.getActivitiesPendingIntent(context, i, aintent, j, bundle);
    }

    ()
    {
    }
}
