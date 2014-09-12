
package android.support.v4.app;

import android.view.MenuItem;


static class  extends 
{

    public void configureMenuItem(MenuItem menuitem,  )
    {
        ShareCompatICS.configureMenuItem(menuitem, .tivity(), .tent());
        if(shouldAddChooserIntent(menuitem))
            menuitem.setIntent(.eChooserIntent());
    }

    boolean shouldAddChooserIntent(MenuItem menuitem)
    {
        return !menuitem.hasSubMenu();
    }

    ()
    {
    }
}
