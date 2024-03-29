
package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;


static class  extends 
{

    public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(accessibilityserviceinfo);
    }

    public int getCapabilities(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return !getCanRetrieveWindowContent(accessibilityserviceinfo) ? 0 : 1;
    }

    public String getDescription(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return AccessibilityServiceInfoCompatIcs.getDescription(accessibilityserviceinfo);
    }

    public String getId(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return AccessibilityServiceInfoCompatIcs.getId(accessibilityserviceinfo);
    }

    public ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return AccessibilityServiceInfoCompatIcs.getResolveInfo(accessibilityserviceinfo);
    }

    public String getSettingsActivityName(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(accessibilityserviceinfo);
    }

    ()
    {
    }
}
