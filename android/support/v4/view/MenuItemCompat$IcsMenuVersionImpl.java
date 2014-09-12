
package android.support.v4.view;

import android.view.MenuItem;


static class _cls1.val.listener extends nImpl
{

    public boolean collapseActionView(MenuItem menuitem)
    {
        return MenuItemCompatIcs.collapseActionView(menuitem);
    }

    public boolean expandActionView(MenuItem menuitem)
    {
        return MenuItemCompatIcs.expandActionView(menuitem);
    }

    public boolean isActionViewExpanded(MenuItem menuitem)
    {
        return MenuItemCompatIcs.isActionViewExpanded(menuitem);
    }

    public MenuItem setOnActionExpandListener(MenuItem menuitem, final ner listener)
    {
        if(listener == null)
            return MenuItemCompatIcs.setOnActionExpandListener(menuitem, null);
        else
            return MenuItemCompatIcs.setOnActionExpandListener(menuitem, new MenuItemCompatIcs.SupportActionExpandProxy() {

                public boolean onMenuItemActionCollapse(MenuItem menuitem1)
                {
                    return listener.onMenuItemActionCollapse(menuitem1);
                }

                public boolean onMenuItemActionExpand(MenuItem menuitem1)
                {
                    return listener.onMenuItemActionExpand(menuitem1);
                }

                final MenuItemCompat.IcsMenuVersionImpl this$0;
                final MenuItemCompat.OnActionExpandListener val$listener;

            
            {
                this$0 = MenuItemCompat.IcsMenuVersionImpl.this;
                listener = onactionexpandlistener;
                super();
            }
            });
    }

    _cls1.val.listener()
    {
    }
}
