
package android.support.v4.widget;



public class PopupMenuCompat
{
    static class BasePopupMenuImpl
        implements PopupMenuImpl
    {

        public android.view.View.OnTouchListener getDragToOpenListener(Object obj)
        {
            return null;
        }

        BasePopupMenuImpl()
        {
        }
    }

    static class KitKatPopupMenuImpl extends BasePopupMenuImpl
    {

        public android.view.View.OnTouchListener getDragToOpenListener(Object obj)
        {
            return PopupMenuCompatKitKat.getDragToOpenListener(obj);
        }

        KitKatPopupMenuImpl()
        {
        }
    }

    static interface PopupMenuImpl
    {

        public abstract android.view.View.OnTouchListener getDragToOpenListener(Object obj);
    }


    private PopupMenuCompat()
    {
    }

    public static android.view.View.OnTouchListener getDragToOpenListener(Object obj)
    {
        return IMPL.getDragToOpenListener(obj);
    }

    static final PopupMenuImpl IMPL;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT >= 19)
            IMPL = new KitKatPopupMenuImpl();
        else
            IMPL = new BasePopupMenuImpl();
    }
}
