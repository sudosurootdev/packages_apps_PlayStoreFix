
package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class IntentCompatHoneycomb
{

    IntentCompatHoneycomb()
    {
    }

    public static Intent makeMainActivity(ComponentName componentname)
    {
        return Intent.makeMainActivity(componentname);
    }

    public static Intent makeRestartActivityTask(ComponentName componentname)
    {
        return Intent.makeRestartActivityTask(componentname);
    }
}
