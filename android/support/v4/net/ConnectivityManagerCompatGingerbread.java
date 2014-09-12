
package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompatGingerbread
{

    ConnectivityManagerCompatGingerbread()
    {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
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
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
                break;
            }
        return true;
    }
}
