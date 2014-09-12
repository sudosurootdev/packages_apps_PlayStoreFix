
package android.support.v4.content;

import java.util.concurrent.CountDownLatch;


final class done extends ModernAsyncTask
    implements Runnable
{

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Object doInBackground(Void avoid[])
    {
        result = onLoadInBackground();
        return result;
    }

    protected void onCancelled()
    {
        dispatchOnCancelled(this, result);
        done.countDown();
        return;
        Exception exception;
        exception;
        done.countDown();
        throw exception;
    }

    protected void onPostExecute(Object obj)
    {
        dispatchOnLoadComplete(this, obj);
        done.countDown();
        return;
        Exception exception;
        exception;
        done.countDown();
        throw exception;
    }

    public void run()
    {
        waiting = false;
        executePendingTask();
    }

    private CountDownLatch done;
    Object result;
    final AsyncTaskLoader this$0;
    boolean waiting;


    _cls9()
    {
        this$0 = AsyncTaskLoader.this;
        super();
        done = new CountDownLatch(1);
    }
}
