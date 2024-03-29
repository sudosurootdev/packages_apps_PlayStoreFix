
package android.support.v4.view;

import android.graphics.Rect;


static interface 
{

    public abstract void apply(int i, int j, int k, Rect rect, int l, int i1, Rect rect1, 
            int j1);

    public abstract void apply(int i, int j, int k, Rect rect, Rect rect1, int l);

    public abstract void applyDisplay(int i, Rect rect, Rect rect1, int j);

    public abstract int getAbsoluteGravity(int i, int j);
}
