
package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


static class mRecreateDisplayList extends e
{

    public void invalidateChildRegion(SlidingPaneLayout slidingpanelayout, View view)
    {
        if(mGetDisplayList != null && mRecreateDisplayList != null)
        {
            try
            {
                mRecreateDisplayList.setBoolean(view, true);
                mGetDisplayList.invoke(view, (Object[])null);
            }
            catch(Exception exception)
            {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", exception);
            }
            super.invalidateChildRegion(slidingpanelayout, view);
            return;
        } else
        {
            view.invalidate();
            return;
        }
    }

    private Method mGetDisplayList;
    private Field mRecreateDisplayList;

    e()
    {
        try
        {
            mGetDisplayList = android/view/View.getDeclaredMethod("getDisplayList", (Class[])null);
        }
        catch(NoSuchMethodException nosuchmethodexception)
        {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", nosuchmethodexception);
        }
        try
        {
            mRecreateDisplayList = android/view/View.getDeclaredField("mRecreateDisplayList");
            mRecreateDisplayList.setAccessible(true);
            return;
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", nosuchfieldexception);
        }
    }
}
