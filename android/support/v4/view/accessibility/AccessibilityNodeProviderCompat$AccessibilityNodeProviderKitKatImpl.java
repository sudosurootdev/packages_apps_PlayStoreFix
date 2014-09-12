
package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;


static class _cls1.val.compat extends _cls1.val.compat
{

    public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat compat)
    {
        return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge() {

            public Object createAccessibilityNodeInfo(int i)
            {
                AccessibilityNodeInfoCompat accessibilitynodeinfocompat = compat.createAccessibilityNodeInfo(i);
                if(accessibilitynodeinfocompat == null)
                    return null;
                else
                    return accessibilitynodeinfocompat.getInfo();
            }

            public List findAccessibilityNodeInfosByText(String s, int i)
            {
                List list = compat.findAccessibilityNodeInfosByText(s, i);
                ArrayList arraylist = new ArrayList();
                int j = list.size();
                for(int k = 0; k < j; k++)
                    arraylist.add(((AccessibilityNodeInfoCompat)list.get(k)).getInfo());

                return arraylist;
            }

            public Object findFocus(int i)
            {
                AccessibilityNodeInfoCompat accessibilitynodeinfocompat = compat.findFocus(i);
                if(accessibilitynodeinfocompat == null)
                    return null;
                else
                    return accessibilitynodeinfocompat.getInfo();
            }

            public boolean performAction(int i, int j, Bundle bundle)
            {
                return compat.performAction(i, j, bundle);
            }

            final AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl this$0;
            final AccessibilityNodeProviderCompat val$compat;

            
            {
                this$0 = AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl.this;
                compat = accessibilitynodeprovidercompat;
                super();
            }
        });
    }

    _cls1.val.compat()
    {
    }
}
