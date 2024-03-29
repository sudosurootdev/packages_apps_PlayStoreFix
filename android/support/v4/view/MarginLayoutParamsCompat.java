
package android.support.v4.view;



public class MarginLayoutParamsCompat
{
    static interface MarginLayoutParamsCompatImpl
    {

        public abstract int getLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams);

        public abstract int getMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams);

        public abstract int getMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams);

        public abstract boolean isMarginRelative(android.view.ViewGroup.MarginLayoutParams marginlayoutparams);

        public abstract void resolveLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i);

        public abstract void setLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i);

        public abstract void setMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i);

        public abstract void setMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i);
    }

    static class MarginLayoutParamsCompatImplBase
        implements MarginLayoutParamsCompatImpl
    {

        public int getLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return 0;
        }

        public int getMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return marginlayoutparams.rightMargin;
        }

        public int getMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return marginlayoutparams.leftMargin;
        }

        public boolean isMarginRelative(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return false;
        }

        public void resolveLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
        }

        public void setLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
        }

        public void setMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
            marginlayoutparams.rightMargin = i;
        }

        public void setMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
            marginlayoutparams.leftMargin = i;
        }

        MarginLayoutParamsCompatImplBase()
        {
        }
    }

    static class MarginLayoutParamsCompatImplJbMr1
        implements MarginLayoutParamsCompatImpl
    {

        public int getLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return MarginLayoutParamsCompatJellybeanMr1.getLayoutDirection(marginlayoutparams);
        }

        public int getMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginEnd(marginlayoutparams);
        }

        public int getMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginStart(marginlayoutparams);
        }

        public boolean isMarginRelative(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return MarginLayoutParamsCompatJellybeanMr1.isMarginRelative(marginlayoutparams);
        }

        public void resolveLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
            MarginLayoutParamsCompatJellybeanMr1.resolveLayoutDirection(marginlayoutparams, i);
        }

        public void setLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
            MarginLayoutParamsCompatJellybeanMr1.setLayoutDirection(marginlayoutparams, i);
        }

        public void setMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
            MarginLayoutParamsCompatJellybeanMr1.setMarginEnd(marginlayoutparams, i);
        }

        public void setMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
        {
            MarginLayoutParamsCompatJellybeanMr1.setMarginStart(marginlayoutparams, i);
        }

        MarginLayoutParamsCompatImplJbMr1()
        {
        }
    }


    public MarginLayoutParamsCompat()
    {
    }

    public static int getLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return IMPL.getLayoutDirection(marginlayoutparams);
    }

    public static int getMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return IMPL.getMarginEnd(marginlayoutparams);
    }

    public static int getMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return IMPL.getMarginStart(marginlayoutparams);
    }

    public static boolean isMarginRelative(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return IMPL.isMarginRelative(marginlayoutparams);
    }

    public static void resolveLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        IMPL.resolveLayoutDirection(marginlayoutparams, i);
    }

    public static void setLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        IMPL.setLayoutDirection(marginlayoutparams, i);
    }

    public static void setMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        IMPL.setMarginEnd(marginlayoutparams, i);
    }

    public static void setMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        IMPL.setMarginStart(marginlayoutparams, i);
    }

    static final MarginLayoutParamsCompatImpl IMPL;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT >= 17)
            IMPL = new MarginLayoutParamsCompatImplJbMr1();
        else
            IMPL = new MarginLayoutParamsCompatImplBase();
    }
}
