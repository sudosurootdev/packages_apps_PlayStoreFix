
package android.support.v4.widget;

import android.content.Context;
import android.view.View;


static class bImpl extends bImpl
{

    public View newSearchView(Context context)
    {
        return SearchViewCompatIcs.newSearchView(context);
    }

    public void setImeOptions(View view, int i)
    {
        SearchViewCompatIcs.setImeOptions(view, i);
    }

    public void setInputType(View view, int i)
    {
        SearchViewCompatIcs.setInputType(view, i);
    }

    bImpl()
    {
    }
}
