
package android.support.v4.content;

import android.util.Log;
import java.util.concurrent.*;


class this._cls0 extends FutureTask
{

    protected void done()
    {
        try
        {
            Object obj = get();
            ModernAsyncTask.access$400(ModernAsyncTask.this, obj);
            return;
        }
        catch(InterruptedException interruptedexception)
        {
            Log.w("AsyncTask", interruptedexception);
            return;
        }
        catch(ExecutionException executionexception)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
        }
        catch(CancellationException cancellationexception)
        {
            ModernAsyncTask.access$400(ModernAsyncTask.this, null);
        }
        catch(Throwable throwable)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", throwable);
        }
    }

    final ModernAsyncTask this$0;

    (Callable callable)
    {
        this$0 = ModernAsyncTask.this;
        super(callable);
    }
}
