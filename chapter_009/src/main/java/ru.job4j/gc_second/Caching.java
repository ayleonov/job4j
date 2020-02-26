package ru.job4j.gc_second;

import java.util.HashMap;
import java.lang.ref.SoftReference;
import java.util.Map;

public class Caching {

    private Map<String, SoftReference> map = new HashMap();

    public SoftReference get(String key, String value) {
        SoftReference ref = map.get(key);

        if (ref == null)
            ref = put(key, value);

        return ref;
    }

    public SoftReference put(String key, String value) {
        SoftReference ref = map.put(key, new SoftReference(value));

        return ref;
    }

    public SoftReference remove(String key) {
        SoftReference oldValue = map.get(key);
        map.remove(key);
        return oldValue;
    }

    public Map<String, SoftReference> getMap() {
        return map;
    }
}

