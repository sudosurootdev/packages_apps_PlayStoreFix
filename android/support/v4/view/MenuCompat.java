
package android.support.v4.view;

import android.view.MenuItem;


public class MenuCompat
{

    public MenuCompat()
    {
    }

    public static void setShowAsAction(MenuItem menuitem, int i)
    {
        MenuItemCompat.setShowAsAction(menuitem, i);
    }
}
