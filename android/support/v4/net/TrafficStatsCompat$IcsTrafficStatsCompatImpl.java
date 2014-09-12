
package android.support.v4.net;

import java.net.Socket;
import java.net.SocketException;


static class I
    implements I
{

    public void clearThreadStatsTag()
    {
        TrafficStatsCompatIcs.clearThreadStatsTag();
    }

    public int getThreadStatsTag()
    {
        return TrafficStatsCompatIcs.getThreadStatsTag();
    }

    public void incrementOperationCount(int i)
    {
        TrafficStatsCompatIcs.incrementOperationCount(i);
    }

    public void incrementOperationCount(int i, int j)
    {
        TrafficStatsCompatIcs.incrementOperationCount(i, j);
    }

    public void setThreadStatsTag(int i)
    {
        TrafficStatsCompatIcs.setThreadStatsTag(i);
    }

    public void tagSocket(Socket socket)
        throws SocketException
    {
        TrafficStatsCompatIcs.tagSocket(socket);
    }

    public void untagSocket(Socket socket)
        throws SocketException
    {
        TrafficStatsCompatIcs.untagSocket(socket);
    }

    I()
    {
    }
}
