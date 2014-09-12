
package android.support.v4.view;

import android.view.View;


static class atImpl extends atImpl
{

    public int getOverScrollMode(View view)
    {
        return ViewCompatGingerbread.getOverScrollMode(view);
    }

    public void setOverScrollMode(View view, int i)
    {
        ViewCompatGingerbread.setOverScrollMode(view, i);
    }

    atImpl()
    {
    }
}
