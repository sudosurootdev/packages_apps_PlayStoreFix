
package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;


static interface stener
{

    public abstract boolean collapseActionView(MenuItem menuitem);

    public abstract boolean expandActionView(MenuItem menuitem);

    public abstract View getActionView(MenuItem menuitem);

    public abstract boolean isActionViewExpanded(MenuItem menuitem);

    public abstract MenuItem setActionView(MenuItem menuitem, int i);

    public abstract MenuItem setActionView(MenuItem menuitem, View view);

    public abstract MenuItem setOnActionExpandListener(MenuItem menuitem, stener stener);

    public abstract void setShowAsAction(MenuItem menuitem, int i);
}
