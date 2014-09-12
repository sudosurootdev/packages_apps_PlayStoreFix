
package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;


static interface 
{

    public abstract boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityserviceinfo);

    public abstract int getCapabilities(AccessibilityServiceInfo accessibilityserviceinfo);

    public abstract String getDescription(AccessibilityServiceInfo accessibilityserviceinfo);

    public abstract String getId(AccessibilityServiceInfo accessibilityserviceinfo);

    public abstract ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityserviceinfo);

    public abstract String getSettingsActivityName(AccessibilityServiceInfo accessibilityserviceinfo);
}
