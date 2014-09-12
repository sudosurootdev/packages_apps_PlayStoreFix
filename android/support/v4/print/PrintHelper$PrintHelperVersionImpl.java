
package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.FileNotFoundException;


static interface A
{

    public abstract int getColorMode();

    public abstract int getOrientation();

    public abstract int getScaleMode();

    public abstract void printBitmap(String s, Bitmap bitmap);

    public abstract void printBitmap(String s, Uri uri)
        throws FileNotFoundException;

    public abstract void setColorMode(int i);

    public abstract void setOrientation(int i);

    public abstract void setScaleMode(int i);
}
