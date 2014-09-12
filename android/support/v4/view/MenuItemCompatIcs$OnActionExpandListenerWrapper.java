
package android.support.v4.view;

import android.view.MenuItem;


static class mWrapped
    implements android.view.nerWrapper
{

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        return mWrapped.uItemActionCollapse(menuitem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return mWrapped.uItemActionExpand(menuitem);
    }

    private uItemActionExpand mWrapped;

    public ( )
    {
        mWrapped = ;
    }
}
