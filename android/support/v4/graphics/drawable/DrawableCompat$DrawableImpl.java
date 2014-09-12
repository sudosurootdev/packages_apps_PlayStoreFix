
package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;


static interface 
{

    public abstract boolean isAutoMirrored(Drawable drawable);

    public abstract void jumpToCurrentState(Drawable drawable);

    public abstract void setAutoMirrored(Drawable drawable, boolean flag);
}
