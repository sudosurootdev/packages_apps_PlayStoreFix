
package android.support.v4.widget;

import android.widget.PopupMenu;

class PopupMenuCompatKitKat
{

    PopupMenuCompatKitKat()
    {
    }

    public static android.view.View.OnTouchListener getDragToOpenListener(Object obj)
    {
        return ((PopupMenu)obj).getDragToOpenListener();
    }
}
