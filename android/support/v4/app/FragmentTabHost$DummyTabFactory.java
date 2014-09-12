
package android.support.v4.app;

import android.content.Context;
import android.view.View;


static class mContext
    implements android.widget.Factory
{

    public View createTabContent(String s)
    {
        View view = new View(mContext);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }

    private final Context mContext;

    public (Context context)
    {
        mContext = context;
    }
}
