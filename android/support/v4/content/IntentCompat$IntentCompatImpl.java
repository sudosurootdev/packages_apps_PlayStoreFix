
package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;


static interface 
{

    public abstract Intent makeMainActivity(ComponentName componentname);

    public abstract Intent makeMainSelectorActivity(String s, String s1);

    public abstract Intent makeRestartActivityTask(ComponentName componentname);
}
