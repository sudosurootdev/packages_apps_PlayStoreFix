
package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;


static class 
    implements 
{

    public boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
    {
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if(networkinfo != null)
            switch(networkinfo.getType())
            {
            case 1: // '\001'
                return false;

            default:
                return true;

            case 0: // '\0'
                break;
            }
        return true;
    }

    ()
    {
    }
}
