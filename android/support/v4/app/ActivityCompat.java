
package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;


public class ActivityCompat extends ContextCompat
{

    public ActivityCompat()
    {
    }

    public static void finishAffinity(Activity activity)
    {
        if(android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityCompatJB.finishAffinity(activity);
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static boolean invalidateOptionsMenu(Activity activity)
    {
        if(android.os.Build.VERSION.SDK_INT >= 11)
        {
            ActivityCompatHoneycomb.invalidateOptionsMenu(activity);
            return true;
        } else
        {
            return false;
        }
    }

    public static void startActivity(Activity activity, Intent intent, Bundle bundle)
    {
        if(android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityCompatJB.startActivity(activity, intent, bundle);
            return;
        } else
        {
            activity.startActivity(intent);
            return;
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle)
    {
        if(android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityCompatJB.startActivityForResult(activity, intent, i, bundle);
            return;
        } else
        {
            activity.startActivityForResult(intent, i);
            return;
        }
    }
}
