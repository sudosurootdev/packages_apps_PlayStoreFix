
package android.support.v4.net;

import android.net.ConnectivityManager;

class ConnectivityManagerCompatJellyBean
{

    ConnectivityManagerCompatJellyBean()
    {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
    {
        return connectivitymanager.isActiveNetworkMetered();
    }
}
