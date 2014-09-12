
package android.support.v4.util;

import java.util.*;

public class LruCache
{

    public LruCache(int i)
    {
        if(i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } else
        {
            maxSize = i;
            map = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    private int safeSizeOf(Object obj, Object obj1)
    {
        int i = sizeOf(obj, obj1);
        if(i < 0)
            throw new IllegalStateException((new StringBuilder()).append("Negative size: ").append(obj).append("=").append(obj1).toString());
        else
            return i;
    }

    protected Object create(Object obj)
    {
        return null;
    }

    public final int createCount()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = createCount;
        lrucache;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
    }

    public final void evictAll()
    {
        trimToSize(-1);
    }

    public final int evictionCount()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = evictionCount;
        lrucache;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object get(Object obj)
    {
        if(obj == null)
            throw new NullPointerException("key == null");
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        Object obj1 = map.get(obj);
        if(obj1 == null)
            break MISSING_BLOCK_LABEL_47;
        hitCount = 1 + hitCount;
        lrucache;
        JVM INSTR monitorexit ;
        return obj1;
        missCount = 1 + missCount;
        lrucache;
        JVM INSTR monitorexit ;
        Object obj2;
        obj2 = create(obj);
        if(obj2 == null)
            return null;
        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception;
        lrucache = this;
        JVM INSTR monitorenter ;
        Object obj3;
        createCount = 1 + createCount;
        obj3 = map.put(obj, obj2);
        if(obj3 == null)
            break MISSING_BLOCK_LABEL_144;
        map.put(obj, obj3);
_L1:
        lrucache;
        JVM INSTR monitorexit ;
        Exception exception1;
        if(obj3 != null)
        {
            entryRemoved(false, obj, obj2, obj3);
            return obj3;
        } else
        {
            trimToSize(maxSize);
            return obj2;
        }
        size = size + safeSizeOf(obj, obj2);
          goto _L1
        exception1;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final int hitCount()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = hitCount;
        lrucache;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int maxSize()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = maxSize;
        lrucache;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int missCount()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = missCount;
        lrucache;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object put(Object obj, Object obj1)
    {
        if(obj == null || obj1 == null)
            throw new NullPointerException("key == null || value == null");
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        Object obj2;
        putCount = 1 + putCount;
        size = size + safeSizeOf(obj, obj1);
        obj2 = map.put(obj, obj1);
        if(obj2 == null)
            break MISSING_BLOCK_LABEL_80;
        size = size - safeSizeOf(obj, obj2);
        lrucache;
        JVM INSTR monitorexit ;
        if(obj2 != null)
            entryRemoved(false, obj, obj2, obj1);
        trimToSize(maxSize);
        return obj2;
        Exception exception;
        exception;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int putCount()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = putCount;
        lrucache;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object remove(Object obj)
    {
        if(obj == null)
            throw new NullPointerException("key == null");
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        Object obj1 = map.remove(obj);
        if(obj1 == null)
            break MISSING_BLOCK_LABEL_47;
        size = size - safeSizeOf(obj, obj1);
        lrucache;
        JVM INSTR monitorexit ;
        if(obj1 != null)
            entryRemoved(false, obj, obj1, null);
        return obj1;
        Exception exception;
        exception;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int size()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = size;
        lrucache;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return 1;
    }

    public final Map snapshot()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        LinkedHashMap linkedhashmap = new LinkedHashMap(map);
        lrucache;
        JVM INSTR monitorexit ;
        return linkedhashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public final String toString()
    {
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        int i = hitCount + missCount;
        int j;
        j = 0;
        if(i == 0)
            break MISSING_BLOCK_LABEL_31;
        j = (100 * hitCount) / i;
        String s;
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(maxSize);
        aobj[1] = Integer.valueOf(hitCount);
        aobj[2] = Integer.valueOf(missCount);
        aobj[3] = Integer.valueOf(j);
        s = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", aobj);
        lrucache;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public void trimToSize(int i)
    {
_L2:
        LruCache lrucache = this;
        JVM INSTR monitorenter ;
        if(size < 0 || map.isEmpty() && size != 0)
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        break MISSING_BLOCK_LABEL_68;
        Exception exception;
        exception;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception;
        if(size > i && !map.isEmpty())
            break MISSING_BLOCK_LABEL_90;
        lrucache;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        Object obj1;
        java.util.Map.Entry entry = (java.util.Map.Entry)map.entrySet().iterator().next();
        obj = entry.getKey();
        obj1 = entry.getValue();
        map.remove(obj);
        size = size - safeSizeOf(obj, obj1);
        evictionCount = 1 + evictionCount;
        lrucache;
        JVM INSTR monitorexit ;
        entryRemoved(true, obj, obj1, null);
        if(true) goto _L2; else goto _L1
_L1:
    }

    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;
}
