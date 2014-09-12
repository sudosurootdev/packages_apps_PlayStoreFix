
package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;


class val.compat
    implements val.compat
{

    public Object createAccessibilityNodeInfo(int i)
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat = val$compat.createAccessibilityNodeInfo(i);
        if(accessibilitynodeinfocompat == null)
            return null;
        else
            return accessibilitynodeinfocompat.getInfo();
    }

    public List findAccessibilityNodeInfosByText(String s, int i)
    {
        List list = val$compat.findAccessibilityNodeInfosByText(s, i);
        ArrayList arraylist = new ArrayList();
        int j = list.size();
        for(int k = 0; k < j; k++)
            arraylist.add(((AccessibilityNodeInfoCompat)list.get(k)).getInfo());

        return arraylist;
    }

    public boolean performAction(int i, int j, Bundle bundle)
    {
        return val$compat.performAction(i, j, bundle);
    }

    final val.compat this$0;
    final AccessibilityNodeProviderCompat val$compat;

    ()
    {
        this$0 = final_;
        val$compat = AccessibilityNodeProviderCompat.this;
        super();
    }
}
