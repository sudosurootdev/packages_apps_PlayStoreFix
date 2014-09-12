
package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;


private static class receiver
{

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("Receiver{");
        stringbuilder.append(receiver);
        stringbuilder.append(" filter=");
        stringbuilder.append(filter);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    boolean broadcasting;
    final IntentFilter filter;
    final BroadcastReceiver receiver;

    (IntentFilter intentfilter, BroadcastReceiver broadcastreceiver)
    {
        filter = intentfilter;
        receiver = broadcastreceiver;
    }
}
