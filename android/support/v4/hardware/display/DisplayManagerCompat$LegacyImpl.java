
package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;


private static class mWindowManager extends DisplayManagerCompat
{

    public Display getDisplay(int i)
    {
        Display display = mWindowManager.getDefaultDisplay();
        if(display.getDisplayId() == i)
            return display;
        else
            return null;
    }

    public Display[] getDisplays()
    {
        Display adisplay[] = new Display[1];
        adisplay[0] = mWindowManager.getDefaultDisplay();
        return adisplay;
    }

    public Display[] getDisplays(String s)
    {
        if(s == null)
            return getDisplays();
        else
            return new Display[0];
    }

    private final WindowManager mWindowManager;

    public I(Context context)
    {
        mWindowManager = (WindowManager)context.getSystemService("window");
    }
}
