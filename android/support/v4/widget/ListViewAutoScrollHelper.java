
package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;


public class ListViewAutoScrollHelper extends AutoScrollHelper
{

    public ListViewAutoScrollHelper(ListView listview)
    {
        super(listview);
        mTarget = listview;
    }

    public boolean canTargetScrollHorizontally(int i)
    {
        return false;
    }

    public boolean canTargetScrollVertically(int i)
    {
        ListView listview = mTarget;
        int j = listview.getCount();
        int k = listview.getChildCount();
        int l = listview.getFirstVisiblePosition();
        int i1 = l + k;
        return i <= 0 ? i >= 0 || l <= 0 && listview.getChildAt(0).getTop() >= 0 : i1 >= j && listview.getChildAt(k - 1).getBottom() <= listview.getHeight();
    }

    public void scrollTargetBy(int i, int j)
    {
        ListView listview = mTarget;
        int k = listview.getFirstVisiblePosition();
        if(k != -1)
        {
            View view = listview.getChildAt(0);
            if(view != null)
            {
                listview.setSelectionFromTop(k, view.getTop() - j);
                return;
            }
        }
    }

    private final ListView mTarget;
}
