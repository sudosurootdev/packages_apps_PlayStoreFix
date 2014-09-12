
package android.support.v4.net;

import java.net.Socket;


static class _cls1.initialValue
    implements _cls1.initialValue
{
    private static class SocketTags
    {

        public int statsTag;

        private SocketTags()
        {
            statsTag = -1;
        }

        SocketTags(TrafficStatsCompat._cls1 _pcls1)
        {
            this();
        }
    }


    public void clearThreadStatsTag()
    {
        ((SocketTags)mThreadSocketTags.get()).statsTag = -1;
    }

    public int getThreadStatsTag()
    {
        return ((SocketTags)mThreadSocketTags.get()).statsTag;
    }

    public void incrementOperationCount(int i)
    {
    }

    public void incrementOperationCount(int i, int j)
    {
    }

    public void setThreadStatsTag(int i)
    {
        ((SocketTags)mThreadSocketTags.get()).statsTag = i;
    }

    public void tagSocket(Socket socket)
    {
    }

    public void untagSocket(Socket socket)
    {
    }

    private ThreadLocal mThreadSocketTags;

    _cls1.this._cls0()
    {
        mThreadSocketTags = new ThreadLocal() {

            protected SocketTags initialValue()
            {
                return new SocketTags(null);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            final TrafficStatsCompat.BaseTrafficStatsCompatImpl this$0;

            
            {
                this$0 = TrafficStatsCompat.BaseTrafficStatsCompatImpl.this;
                super();
            }
        };
    }
}
