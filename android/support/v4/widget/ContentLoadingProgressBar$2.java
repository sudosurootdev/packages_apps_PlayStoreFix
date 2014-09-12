
package android.support.v4.widget;



class this._cls0
    implements Runnable
{

    public void run()
    {
        ContentLoadingProgressBar.access$202(ContentLoadingProgressBar.this, false);
        if(!ContentLoadingProgressBar.access$300(ContentLoadingProgressBar.this))
        {
            ContentLoadingProgressBar.access$102(ContentLoadingProgressBar.this, System.currentTimeMillis());
            setVisibility(0);
        }
    }

    final ContentLoadingProgressBar this$0;

    ()
    {
        this$0 = ContentLoadingProgressBar.this;
        super();
    }
}
