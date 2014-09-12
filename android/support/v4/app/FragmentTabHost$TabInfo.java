
package android.support.v4.app;

import android.os.Bundle;


static final class args
{

    private final Bundle args;
    private final Class clss;
    private Fragment fragment;
    private final String tag;



/*
    static Fragment access$102( , Fragment fragment1)
    {
        .fragment = fragment1;
        return fragment1;
    }

*/




    fragment(String s, Class class1, Bundle bundle)
    {
        tag = s;
        clss = class1;
        args = bundle;
    }
}
