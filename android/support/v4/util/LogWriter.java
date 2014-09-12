
package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer
{

    public LogWriter(String s)
    {
        mBuilder = new StringBuilder(128);
        mTag = s;
    }

    private void flushBuilder()
    {
        if(mBuilder.length() > 0)
        {
            Log.d(mTag, mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        }
    }

    public void close()
    {
        flushBuilder();
    }

    public void flush()
    {
        flushBuilder();
    }

    public void write(char ac[], int i, int j)
    {
        for(int k = 0; k < j; k++)
        {
            char c = ac[i + k];
            if(c == '\n')
                flushBuilder();
            else
                mBuilder.append(c);
        }

    }

    private StringBuilder mBuilder;
    private final String mTag;
}
