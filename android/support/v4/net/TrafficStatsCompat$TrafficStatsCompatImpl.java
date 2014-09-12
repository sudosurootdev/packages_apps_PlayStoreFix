
package android.support.v4.net;

import java.net.Socket;
import java.net.SocketException;


static interface 
{

    public abstract void clearThreadStatsTag();

    public abstract int getThreadStatsTag();

    public abstract void incrementOperationCount(int i);

    public abstract void incrementOperationCount(int i, int j);

    public abstract void setThreadStatsTag(int i);

    public abstract void tagSocket(Socket socket)
        throws SocketException;

    public abstract void untagSocket(Socket socket)
        throws SocketException;
}
