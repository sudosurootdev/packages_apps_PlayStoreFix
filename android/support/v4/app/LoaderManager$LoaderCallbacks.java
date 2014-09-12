
package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;


public static interface 
{

    public abstract Loader onCreateLoader(int i, Bundle bundle);

    public abstract void onLoadFinished(Loader loader, Object obj);

    public abstract void onLoaderReset(Loader loader);
}
