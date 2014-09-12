
package android.support.v4.view;

import android.view.View;
import java.util.Comparator;


static class 
    implements Comparator
{

    public int compare(View view, View view1)
    {
          = ()view.getLayoutParams();
         1 = ()view1.getLayoutParams();
        if(. != 1.)
            return !. ? -1 : 1;
        else
            return . - 1.;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((View)obj, (View)obj1);
    }

    ()
    {
    }
}
