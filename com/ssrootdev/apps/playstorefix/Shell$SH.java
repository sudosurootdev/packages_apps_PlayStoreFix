
package com.ssrootdev.apps.playfixer;

import java.util.List;


public static class mandResult
{

    public static mandResult run(List list)
    {
        return run((String[])list.toArray(new String[0]));
    }

    public static transient mandResult run(String as[])
    {
        return (new Shell("sh")).run(as);
    }

    public mandResult()
    {
    }
}
