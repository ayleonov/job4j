package ru.job4j.map;

import java.util.*;

public class Createmap2<K, V> implements Iterable {
    private final static int CAPACITY = 16;
    private int size = CAPACITY;
    Entry<K, V>[] table = new Entry[size];
    private final static double LOADFACTOR = 0.75;
    double threshold = size * LOADFACTOR;
    private int hash;
    private int position = 0;

    public boolean insert(K key, V value) { // ДОРАБОТАТЬ
        boolean res = false;
        if (size >= threshold) {
            resize();
        }
        if (key != null) {
            res = true;
            int hash = hash(key.hashCode());
            int indexInTable = indexFor(hash, size);
            if (contains(key, indexInTable)) {
                return false;
            } else {
                addEntry(hash, key, value, indexInTable);
                position++;
            }
        } else {
            putForNullKey(key, value);
        }
        return res;
    }

    public V get(K key) {
        int hash = 0;
        int indexInTable = 0;
        if (key != null) {
            hash = hash(key.hashCode());
            indexInTable = indexFor(hash, size);
        }
        return table[indexInTable].getValue();
    }

    public boolean delete(K key) {
        boolean res = false;
        int hash = hash(key.hashCode());
        int indexInTable = indexFor(hash, size);
        if (table[indexInTable] != null) {
            System.arraycopy(table, indexInTable + 1, table, indexInTable, table.length - 1 - indexInTable);
            position--;
            res = true;
        }
        return res;
    }


    private boolean putForNullKey(K key, V value) {
        boolean res = false;
        int hash = 0;
        int indexInTable = 0;
        if (contains(key, indexInTable)) {
            res = false;
        } else {
            addEntry(0, key, value, 0);
            res = true;
        }
        return res;
    }

    public void addEntry(int hash, K key, V value, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry(hash, key, value, e);
    }

    public boolean contains(K key, int index) {
        boolean res = false;
        if (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                res = true;
            }
        }
        return res;
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public void resize() {
        table = Arrays.copyOf(table, 2 * size);
        // заглушка
        transform();
    }

    public void transform() {
        // заглушка
    }

    public int getSize() {
        return size;
    }

    public int getPosition() {
        return position;
    }

    public Entry<K, V>[] getTable() {
        return table;
    }


    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int[] entryKeys() {
        int[] cellsWithKeys = new int[size];
        int tempposition = 0;
        cellsWithKeys[0] = 0;
        if (table[0] != null) {
            tempposition = 1;
        }
        for (int i = 1; i < size; i++) {
            if (table[i] != null) {
                cellsWithKeys[tempposition++] = i;
            }
        }
        return cellsWithKeys;
    }


    public Iterator iterator() {

        return new Iterator() {
            int iterposition = 0;
            int[] array = entryKeys();

            @Override
            public boolean hasNext() {
                if (iterposition == 0 && table[0] != null) {
                    iterposition++;
                }
                return iterposition < position;
                //return iterposition < array.length;
            }

            @Override
            public Object next() {
                Object res = null;
                if (hasNext()) {
                    if (iterposition == 0 && table[0] != null) {
                        res = table[0];
                    } else {
                        res = table[array[iterposition++]];
                    }
                } else {
                    throw new NoSuchElementException();
                }
                return res;
            }
        };
    }

    static class Entry<K, V> {
        K key;
        V value;
        int hash;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

