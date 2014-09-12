
package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


static final class 
    implements ThreadFactory
{

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, (new StringBuilder()).append("ModernAsyncTask #").append(mCount.getAndIncrement()).toString());
    }

    private final AtomicInteger mCount = new AtomicInteger(1);

    ()
    {
    }
}
