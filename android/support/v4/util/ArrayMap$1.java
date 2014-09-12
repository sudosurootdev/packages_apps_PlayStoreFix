
package android.support.v4.util;

import java.util.Map;


class ons extends MapCollections
{

    protected void colClear()
    {
        clear();
    }

    protected Object colGetEntry(int i, int j)
    {
        return mArray[j + (i << 1)];
    }

    protected Map colGetMap()
    {
        return ArrayMap.this;
    }

    protected int colGetSize()
    {
        return mSize;
    }

    protected int colIndexOfKey(Object obj)
    {
        if(obj == null)
            return indexOfNull();
        else
            return indexOf(obj, obj.hashCode());
    }

    protected int colIndexOfValue(Object obj)
    {
        return indexOfValue(obj);
    }

    protected void colPut(Object obj, Object obj1)
    {
        put(obj, obj1);
    }

    protected void colRemoveAt(int i)
    {
        removeAt(i);
    }

    protected Object colSetValue(int i, Object obj)
    {
        return setValueAt(i, obj);
    }

    final ArrayMap this$0;

    ons()
    {
        this$0 = ArrayMap.this;
        super();
    }
}
