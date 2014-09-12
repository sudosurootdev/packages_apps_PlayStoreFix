
package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;


class rkerRunnable extends rkerRunnable
{

    public Object call()
        throws Exception
    {
        ModernAsyncTask.access$200(ModernAsyncTask.this).set(true);
        Process.setThreadPriority(10);
        return ModernAsyncTask.access$300(ModernAsyncTask.this, doInBackground(mParams));
    }

    final ModernAsyncTask this$0;

    rkerRunnable()
    {
        this$0 = ModernAsyncTask.this;
        super(null);
    }
}
