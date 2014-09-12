
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
        Intent intent = new Intent(aintent[-1 + aintent.length]);
        intent.addFlags(0x10000000);
        return PendingIntent.getActivity(context, i, intent, j);
    }

    ()
    {
    }
}
