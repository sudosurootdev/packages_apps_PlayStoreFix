
package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class AccessibilityNodeProviderCompatKitKat
{
    static interface AccessibilityNodeInfoBridge
    {

        public abstract Object createAccessibilityNodeInfo(int i);

        public abstract List findAccessibilityNodeInfosByText(String s, int i);

        public abstract Object findFocus(int i);

        public abstract boolean performAction(int i, int j, Bundle bundle);
    }


    AccessibilityNodeProviderCompatKitKat()
    {
    }

    public static Object newAccessibilityNodeProviderBridge(AccessibilityNodeInfoBridge accessibilitynodeinfobridge)
    {
        return new AccessibilityNodeProvider(accessibilitynodeinfobridge) {

            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i)
            {
                return (AccessibilityNodeInfo)bridge.createAccessibilityNodeInfo(i);
            }

            public List findAccessibilityNodeInfosByText(String s, int i)
            {
                return bridge.findAccessibilityNodeInfosByText(s, i);
            }

            public AccessibilityNodeInfo findFocus(int i)
            {
                return (AccessibilityNodeInfo)bridge.findFocus(i);
            }

            public boolean performAction(int i, int j, Bundle bundle)
            {
                return bridge.performAction(i, j, bundle);
            }

            final AccessibilityNodeInfoBridge val$bridge;

            
            {
                bridge = accessibilitynodeinfobridge;
                super();
            }
        };
    }
}
