
package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;


public static class  extends SearchView
{

    public void onActionViewCollapsed()
    {
        setQuery("", false);
        super.onActionViewCollapsed();
    }

    public (Context context)
    {
        super(context);
    }
}
