
package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;


public abstract class DisplayManagerCompat
{
    private static class JellybeanMr1Impl extends DisplayManagerCompat
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

        public JellybeanMr1Impl(Context context)
        {
            mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(context);
        }
    }

    private static class LegacyImpl extends DisplayManagerCompat
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

        public LegacyImpl(Context context)
        {
            mWindowManager = (WindowManager)context.getSystemService("window");
        }
    }


    DisplayManagerCompat()
    {
    }

    public static DisplayManagerCompat getInstance(Context context)
    {
        WeakHashMap weakhashmap = sInstances;
        WeakHashMap weakhashmap1 = weakhashmap;
        JVM INSTR monitorenter ;
        Object obj = (DisplayManagerCompat)sInstances.get(context);
        if(obj != null) goto _L2; else goto _L1
_L1:
        if(android.os.Build.VERSION.SDK_INT < 17)
            break MISSING_BLOCK_LABEL_55;
        obj = new JellybeanMr1Impl(context);
_L3:
        sInstances.put(context, obj);
_L2:
        weakhashmap1;
        JVM INSTR monitorexit ;
        return ((DisplayManagerCompat) (obj));
        obj = new LegacyImpl(context);
          goto _L3
        Exception exception;
        exception;
        weakhashmap1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String s);

    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap sInstances = new WeakHashMap();

}
