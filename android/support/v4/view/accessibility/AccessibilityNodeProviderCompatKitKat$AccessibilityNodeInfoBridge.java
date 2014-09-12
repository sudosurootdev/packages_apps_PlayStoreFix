
package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;


static interface 
{

    public abstract Object createAccessibilityNodeInfo(int i);

    public abstract List findAccessibilityNodeInfosByText(String s, int i);

    public abstract Object findFocus(int i);

    public abstract boolean performAction(int i, int j, Bundle bundle);
}
