
package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import java.util.List;


static interface Compat
{

    public abstract boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilitymanager, Compat compat);

    public abstract List getEnabledAccessibilityServiceList(AccessibilityManager accessibilitymanager, int i);

    public abstract List getInstalledAccessibilityServiceList(AccessibilityManager accessibilitymanager);

    public abstract boolean isTouchExplorationEnabled(AccessibilityManager accessibilitymanager);

    public abstract Object newAccessiblityStateChangeListener(Compat compat);

    public abstract boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilitymanager, Compat compat);
}
