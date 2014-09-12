
package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompatHoneycombMR2
{

    ConnectivityManagerCompatHoneycombMR2()
    {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
    {
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if(networkinfo != null)
            switch(networkinfo.getType())
            {
            case 1: // '\001'
            case 7: // '\007'
            case 9: // '\t'
                return false;

            case 8: // '\b'
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
