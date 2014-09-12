
package android.support.v4.util;

import java.util.Iterator;


final class mSize
    implements Iterator
{

    public boolean hasNext()
    {
        return mIndex < mSize;
    }

    public Object next()
    {
        Object obj = colGetEntry(mIndex, mOffset);
        mIndex = 1 + mIndex;
        mCanRemove = true;
        return obj;
    }

    public void remove()
    {
        if(!mCanRemove)
        {
            throw new IllegalStateException();
        } else
        {
            mIndex = -1 + mIndex;
            mSize = -1 + mSize;
            mCanRemove = false;
            colRemoveAt(mIndex);
            return;
        }
    }

    boolean mCanRemove;
    int mIndex;
    final int mOffset;
    int mSize;
    final MapCollections this$0;

    (int i)
    {
        this$0 = MapCollections.this;
        super();
        mCanRemove = false;
        mOffset = i;
        mSize = colGetSize();
    }
}
