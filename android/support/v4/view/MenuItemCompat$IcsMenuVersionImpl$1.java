
package android.support.v4.view;

import android.view.MenuItem;


class r
    implements dProxy
{

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        return val$listener.onMenuItemActionCollapse(menuitem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return val$listener.onMenuItemActionExpand(menuitem);
    }

    final r.onMenuItemActionExpand this$0;
    final r val$listener;

    r()
    {
        this$0 = final_r;
        val$listener = r.this;
        super();
    }
}
