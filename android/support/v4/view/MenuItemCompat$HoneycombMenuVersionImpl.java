
package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;


static class 
    implements 
{

    public boolean collapseActionView(MenuItem menuitem)
    {
        return false;
    }

    public boolean expandActionView(MenuItem menuitem)
    {
        return false;
    }

    public View getActionView(MenuItem menuitem)
    {
        return MenuItemCompatHoneycomb.getActionView(menuitem);
    }

    public boolean isActionViewExpanded(MenuItem menuitem)
    {
        return false;
    }

    public MenuItem setActionView(MenuItem menuitem, int i)
    {
        return MenuItemCompatHoneycomb.setActionView(menuitem, i);
    }

    public MenuItem setActionView(MenuItem menuitem, View view)
    {
        return MenuItemCompatHoneycomb.setActionView(menuitem, view);
    }

    public MenuItem setOnActionExpandListener(MenuItem menuitem,  )
    {
        return menuitem;
    }

    public void setShowAsAction(MenuItem menuitem, int i)
    {
        MenuItemCompatHoneycomb.setShowAsAction(menuitem, i);
    }

    ()
    {
    }
}
