
package android.support.v4.os;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;


public class EnvironmentCompat
{

    public EnvironmentCompat()
    {
    }

    public static String getStorageState(File file)
    {
        if(android.os.Build.VERSION.SDK_INT >= 19)
            return EnvironmentCompatKitKat.getStorageState(file);
        String s;
        if(!file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()))
            break MISSING_BLOCK_LABEL_61;
        s = Environment.getExternalStorageState();
        return s;
        IOException ioexception;
        ioexception;
        Log.w("EnvironmentCompat", (new StringBuilder()).append("Failed to resolve canonical path: ").append(ioexception).toString());
        return "unknown";
    }

    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";
}
