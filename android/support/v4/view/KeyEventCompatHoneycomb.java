
package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompatHoneycomb
{

    KeyEventCompatHoneycomb()
    {
    }

    public static boolean metaStateHasModifiers(int i, int j)
    {
        return KeyEvent.metaStateHasModifiers(i, j);
    }

    public static boolean metaStateHasNoModifiers(int i)
    {
        return KeyEvent.metaStateHasNoModifiers(i);
    }

    public static int normalizeMetaState(int i)
    {
        return KeyEvent.normalizeMetaState(i);
    }
}
