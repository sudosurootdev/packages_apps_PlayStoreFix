
package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class AccessibilityServiceInfoCompatIcs
{

    AccessibilityServiceInfoCompatIcs()
    {
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getCanRetrieveWindowContent();
    }

    public static String getDescription(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getDescription();
    }

    public static String getId(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getId();
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getResolveInfo();
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getSettingsActivityName();
    }
}
