
package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;


final class mCallbacks
    implements android.support.v4.content.
{

    void callOnLoadFinished(Loader loader, Object obj)
    {
        String s;
        if(mCallbacks == null)
            break MISSING_BLOCK_LABEL_137;
        FragmentActivity fragmentactivity = mActivity;
        s = null;
        if(fragmentactivity != null)
        {
            s = mActivity.mFragments.mNoTransactionsBecause;
            mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
        }
        if(LoaderManagerImpl.DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("  onLoadFinished in ").append(loader).append(": ").append(loader.dataToString(obj)).toString());
        mCallbacks.onLoadFinished(loader, obj);
        if(mActivity != null)
            mActivity.mFragments.mNoTransactionsBecause = s;
        mDeliveredData = true;
        return;
        Exception exception;
        exception;
        if(mActivity != null)
            mActivity.mFragments.mNoTransactionsBecause = s;
        throw exception;
    }

    void destroy()
    {
        String s;
        if(LoaderManagerImpl.DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("  Destroying: ").append(this).toString());
        mDestroyed = true;
        boolean flag = mDeliveredData;
        mDeliveredData = false;
        if(mCallbacks == null || mLoader == null || !mHaveData || !flag)
            break MISSING_BLOCK_LABEL_182;
        if(LoaderManagerImpl.DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("  Reseting: ").append(this).toString());
        FragmentActivity fragmentactivity = mActivity;
        s = null;
        if(fragmentactivity != null)
        {
            s = mActivity.mFragments.mNoTransactionsBecause;
            mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
        }
        mCallbacks.onLoaderReset(mLoader);
        if(mActivity != null)
            mActivity.mFragments.mNoTransactionsBecause = s;
        mCallbacks = null;
        mData = null;
        mHaveData = false;
        if(mLoader != null)
        {
            if(mListenerRegistered)
            {
                mListenerRegistered = false;
                mLoader.unregisterListener(this);
            }
            mLoader.reset();
        }
        if(mPendingLoader != null)
            mPendingLoader.destroy();
        return;
        Exception exception;
        exception;
        if(mActivity != null)
            mActivity.mFragments.mNoTransactionsBecause = s;
        throw exception;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(mId);
        printwriter.print(" mArgs=");
        printwriter.println(mArgs);
        printwriter.print(s);
        printwriter.print("mCallbacks=");
        printwriter.println(mCallbacks);
        printwriter.print(s);
        printwriter.print("mLoader=");
        printwriter.println(mLoader);
        if(mLoader != null)
            mLoader.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        if(mHaveData || mDeliveredData)
        {
            printwriter.print(s);
            printwriter.print("mHaveData=");
            printwriter.print(mHaveData);
            printwriter.print("  mDeliveredData=");
            printwriter.println(mDeliveredData);
            printwriter.print(s);
            printwriter.print("mData=");
            printwriter.println(mData);
        }
        printwriter.print(s);
        printwriter.print("mStarted=");
        printwriter.print(mStarted);
        printwriter.print(" mReportNextStart=");
        printwriter.print(mReportNextStart);
        printwriter.print(" mDestroyed=");
        printwriter.println(mDestroyed);
        printwriter.print(s);
        printwriter.print("mRetaining=");
        printwriter.print(mRetaining);
        printwriter.print(" mRetainingStarted=");
        printwriter.print(mRetainingStarted);
        printwriter.print(" mListenerRegistered=");
        printwriter.println(mListenerRegistered);
        if(mPendingLoader != null)
        {
            printwriter.print(s);
            printwriter.println("Pending Loader ");
            printwriter.print(mPendingLoader);
            printwriter.println(":");
            mPendingLoader.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    void finishRetain()
    {
        if(mRetaining)
        {
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Finished Retaining: ").append(this).toString());
            mRetaining = false;
            if(mStarted != mRetainingStarted && !mStarted)
                stop();
        }
        if(mStarted && mHaveData && !mReportNextStart)
            callOnLoadFinished(mLoader, mData);
    }

    public void onLoadComplete(Loader loader, Object obj)
    {
        if(LoaderManagerImpl.DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("onLoadComplete: ").append(this).toString());
        if(mDestroyed)
        {
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
        } else
        if(mLoaders.get(mId) != this)
        {
            if(LoaderManagerImpl.DEBUG)
            {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
                return;
            }
        } else
        {
            mData mdata = mPendingLoader;
            if(mdata != null)
            {
                if(LoaderManagerImpl.DEBUG)
                    Log.v("LoaderManager", (new StringBuilder()).append("  Switching to pending loader: ").append(mdata).toString());
                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(mdata);
                return;
            }
            if(mData != obj || !mHaveData)
            {
                mData = obj;
                mHaveData = true;
                if(mStarted)
                    callOnLoadFinished(loader, obj);
            }
            mData mdata1 = (callOnLoadFinished)mInactiveLoaders.get(mId);
            if(mdata1 != null && mdata1 != this)
            {
                mdata1.mDeliveredData = false;
                mdata1.destroy();
                mInactiveLoaders.remove(mId);
            }
            if(mActivity != null && !hasRunningLoaders())
            {
                mActivity.mFragments.startPendingDeferredFragments();
                return;
            }
        }
    }

    void reportStart()
    {
        if(mStarted && mReportNextStart)
        {
            mReportNextStart = false;
            if(mHaveData)
                callOnLoadFinished(mLoader, mData);
        }
    }

    void retain()
    {
        if(LoaderManagerImpl.DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("  Retaining: ").append(this).toString());
        mRetaining = true;
        mRetainingStarted = mStarted;
        mStarted = false;
        mCallbacks = null;
    }

    void start()
    {
        if(mRetaining && mRetainingStarted)
            mStarted = true;
        else
        if(!mStarted)
        {
            mStarted = true;
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Starting: ").append(this).toString());
            if(mLoader == null && mCallbacks != null)
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            if(mLoader != null)
            {
                if(mLoader.getClass().isMemberClass() && !Modifier.isStatic(mLoader.getClass().getModifiers()))
                    throw new IllegalArgumentException((new StringBuilder()).append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(mLoader).toString());
                if(!mListenerRegistered)
                {
                    mLoader.registerListener(mId, this);
                    mListenerRegistered = true;
                }
                mLoader.startLoading();
                return;
            }
        }
    }

    void stop()
    {
        if(LoaderManagerImpl.DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("  Stopping: ").append(this).toString());
        mStarted = false;
        if(!mRetaining && mLoader != null && mListenerRegistered)
        {
            mListenerRegistered = false;
            mLoader.unregisterListener(this);
            mLoader.stopLoading();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("LoaderInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" #");
        stringbuilder.append(mId);
        stringbuilder.append(" : ");
        DebugUtils.buildShortClassTag(mLoader, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    final Bundle mArgs;
     mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    Loader mLoader;
     mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final LoaderManagerImpl this$0;

    public (int i, Bundle bundle,  )
    {
        this$0 = LoaderManagerImpl.this;
        super();
        mId = i;
        mArgs = bundle;
        mCallbacks = ;
    }
}
