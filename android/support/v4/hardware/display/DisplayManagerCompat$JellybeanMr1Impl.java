
package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;


private static class anager extends DisplayManagerCompat
{

    public Display getDisplay(int i)
    {
        return DisplayManagerJellybeanMr1.getDisplay(mDisplayManagerObj, i);
    }

    public Display[] getDisplays()
    {
        return DisplayManagerJellybeanMr1.getDisplays(mDisplayManagerObj);
    }

    public Display[] getDisplays(String s)
    {
        return DisplayManagerJellybeanMr1.getDisplays(mDisplayManagerObj, s);
    }

    private final Object mDisplayManagerObj;

    public (Context context)
    {
        mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(context);
    }
}
