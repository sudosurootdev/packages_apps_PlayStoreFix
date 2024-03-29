
package android.support.v4.util;

import java.util.*;


public class ArrayMap extends SimpleArrayMap
    implements Map
{

    public ArrayMap()
    {
    }

    public ArrayMap(int i)
    {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simplearraymap)
    {
        super(simplearraymap);
    }

    private MapCollections getCollection()
    {
        if(mCollections == null)
            mCollections = new MapCollections() {

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

            
            {
                this$0 = ArrayMap.this;
                super();
            }
            };
        return mCollections;
    }

    public boolean containsAll(Collection collection)
    {
        return MapCollections.containsAllHelper(this, collection);
    }

    public Set entrySet()
    {
        return getCollection().getEntrySet();
    }

    public Set keySet()
    {
        return getCollection().getKeySet();
    }

    public void putAll(Map map)
    {
        ensureCapacity(mSize + map.size());
        java.util.Map.Entry entry;
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); put(entry.getKey(), entry.getValue()))
            entry = (java.util.Map.Entry)iterator.next();

    }

    public boolean removeAll(Collection collection)
    {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection collection)
    {
        return MapCollections.retainAllHelper(this, collection);
    }

    public Collection values()
    {
        return getCollection().getValues();
    }

    MapCollections mCollections;
}
