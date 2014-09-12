
package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;


static interface 
{

    public abstract Intent getParentActivityIntent(Activity activity);

    public abstract String getParentActivityName(Context context, ActivityInfo activityinfo);

    public abstract void navigateUpTo(Activity activity, Intent intent);

    public abstract boolean shouldUpRecreateTask(Activity activity, Intent intent);
}
