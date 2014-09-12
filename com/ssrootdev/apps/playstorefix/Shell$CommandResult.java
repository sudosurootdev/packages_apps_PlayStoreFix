
package com.ssrootdev.apps.playfixer;

import android.text.TextUtils;


public static class stderr
{

    public boolean hasOutput()
    {
        return !TextUtils.isEmpty(stdout);
    }

    public boolean isSuccess()
    {
        return success() && hasOutput();
    }

    public boolean success()
    {
        return exitValue == 0;
    }

    public int exitValue;
    public String stderr;
    public String stdout;

    public ()
    {
        exitValue = -1;
    }

    public exitValue(int i, String s, String s1)
    {
        exitValue = -1;
        exitValue = i;
        stdout = s;
        stderr = s1;
    }
}
