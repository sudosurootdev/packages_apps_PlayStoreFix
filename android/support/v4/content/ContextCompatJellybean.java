
package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class ContextCompatJellybean
{

    ContextCompatJellybean()
    {
    }

    public static void startActivities(Context context, Intent aintent[], Bundle bundle)
    {
        context.startActivities(aintent, bundle);
    }
}
