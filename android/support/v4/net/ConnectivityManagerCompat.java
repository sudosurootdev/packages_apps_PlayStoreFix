
package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class ConnectivityManagerCompat
{
    static class BaseConnectivityManagerCompatImpl
        implements ConnectivityManagerCompatImpl
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

        BaseConnectivityManagerCompatImpl()
        {
        }
    }

    static interface ConnectivityManagerCompatImpl
    {

        public abstract boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager);
    }

    static class GingerbreadConnectivityManagerCompatImpl
        implements ConnectivityManagerCompatImpl
    {

        public boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
        {
            return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(connectivitymanager);
        }

        GingerbreadConnectivityManagerCompatImpl()
        {
        }
    }

    static class HoneycombMR2ConnectivityManagerCompatImpl
        implements ConnectivityManagerCompatImpl
    {

        public boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
        {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(connectivitymanager);
        }

        HoneycombMR2ConnectivityManagerCompatImpl()
        {
        }
    }

    static class JellyBeanConnectivityManagerCompatImpl
        implements ConnectivityManagerCompatImpl
    {

        public boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
        {
            return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(connectivitymanager);
        }

        JellyBeanConnectivityManagerCompatImpl()
        {
        }
    }


    public ConnectivityManagerCompat()
    {
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivitymanager, Intent intent)
    {
        return connectivitymanager.getNetworkInfo(((NetworkInfo)intent.getParcelableExtra("networkInfo")).getType());
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
    {
        return IMPL.isActiveNetworkMetered(connectivitymanager);
    }

    private static final ConnectivityManagerCompatImpl IMPL;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT >= 16)
            IMPL = new JellyBeanConnectivityManagerCompatImpl();
        else
        if(android.os.Build.VERSION.SDK_INT >= 13)
            IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
        else
        if(android.os.Build.VERSION.SDK_INT >= 8)
            IMPL = new GingerbreadConnectivityManagerCompatImpl();
        else
            IMPL = new BaseConnectivityManagerCompatImpl();
    }
}
