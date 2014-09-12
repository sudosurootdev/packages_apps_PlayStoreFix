
package android.support.v4.util;


public class DebugUtils
{

    public DebugUtils()
    {
    }

    public static void buildShortClassTag(Object obj, StringBuilder stringbuilder)
    {
        if(obj == null)
        {
            stringbuilder.append("null");
            return;
        }
        String s = obj.getClass().getSimpleName();
        if(s == null || s.length() <= 0)
        {
            s = obj.getClass().getName();
            int i = s.lastIndexOf('.');
            if(i > 0)
                s = s.substring(i + 1);
        }
        stringbuilder.append(s);
        stringbuilder.append('{');
        stringbuilder.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}
