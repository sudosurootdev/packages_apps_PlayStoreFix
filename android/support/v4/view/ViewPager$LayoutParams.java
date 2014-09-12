
package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;


public static class gravity extends android.view.youtParams
{

    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor;

    public ()
    {
        super(-1, -1);
        widthFactor = 0.0F;
    }

    public widthFactor(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        widthFactor = 0.0F;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, ViewPager.access$400());
        gravity = typedarray.getInteger(0, 48);
        typedarray.recycle();
    }
}
