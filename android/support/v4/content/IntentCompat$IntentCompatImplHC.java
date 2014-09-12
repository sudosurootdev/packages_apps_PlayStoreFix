
package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;


static class e extends e
{

    public Intent makeMainActivity(ComponentName componentname)
    {
        return IntentCompatHoneycomb.makeMainActivity(componentname);
    }

    public Intent makeRestartActivityTask(ComponentName componentname)
    {
        return IntentCompatHoneycomb.makeRestartActivityTask(componentname);
    }

    e()
    {
    }
}
