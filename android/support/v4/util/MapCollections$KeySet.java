
package android.support.v4.util;

import java.util.*;


final class this._cls0
    implements Set
{

    public boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public void clear()
    {
        colClear();
    }

    public boolean contains(Object obj)
    {
        return colIndexOfKey(obj) >= 0;
    }

    public boolean containsAll(Collection collection)
    {
        return MapCollections.containsAllHelper(colGetMap(), collection);
    }

    public boolean equals(Object obj)
    {
        return MapCollections.equalsSetHelper(this, obj);
    }

    public int hashCode()
    {
        int i = 0;
        for(int j = -1 + colGetSize(); j >= 0; j--)
        {
            Object obj = colGetEntry(j, 0);
            int k;
            if(obj == null)
                k = 0;
            else
                k = obj.hashCode();
            i += k;
        }

        return i;
    }

    public boolean isEmpty()
    {
        return colGetSize() == 0;
    }

    public Iterator iterator()
    {
        return new erator(MapCollections.this, 0);
    }

    public boolean remove(Object obj)
    {
        int i = colIndexOfKey(obj);
        if(i >= 0)
        {
            colRemoveAt(i);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean removeAll(Collection collection)
    {
        return MapCollections.removeAllHelper(colGetMap(), collection);
    }

    public boolean retainAll(Collection collection)
    {
        return MapCollections.retainAllHelper(colGetMap(), collection);
    }

    public int size()
    {
        return colGetSize();
    }

    public Object[] toArray()
    {
        return toArrayHelper(0);
    }

    public Object[] toArray(Object aobj[])
    {
        return toArrayHelper(aobj, 0);
    }

    final MapCollections this$0;

    erator()
    {
        this$0 = MapCollections.this;
        super();
    }
}
