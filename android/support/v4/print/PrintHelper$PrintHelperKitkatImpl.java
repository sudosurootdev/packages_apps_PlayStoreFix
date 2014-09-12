
package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.FileNotFoundException;


private static final class mPrintHelper
    implements 
{

    public int getColorMode()
    {
        return mPrintHelper.getColorMode();
    }

    public int getOrientation()
    {
        return mPrintHelper.getOrientation();
    }

    public int getScaleMode()
    {
        return mPrintHelper.getScaleMode();
    }

    public void printBitmap(String s, Bitmap bitmap)
    {
        mPrintHelper.printBitmap(s, bitmap);
    }

    public void printBitmap(String s, Uri uri)
        throws FileNotFoundException
    {
        mPrintHelper.printBitmap(s, uri);
    }

    public void setColorMode(int i)
    {
        mPrintHelper.setColorMode(i);
    }

    public void setOrientation(int i)
    {
        mPrintHelper.setOrientation(i);
    }

    public void setScaleMode(int i)
    {
        mPrintHelper.setScaleMode(i);
    }

    private final PrintHelperKitkat mPrintHelper;

    (Context context)
    {
        mPrintHelper = new PrintHelperKitkat(context);
    }
}
