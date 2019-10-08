package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Createmap<K, V> implements Iterable {
    private int position = 0;
    private static int STARTSIZE = 16;
    private static int SIZE = STARTSIZE;

    private Node<K, V>[] table;

    public Createmap() {
        this.table = new Node[SIZE];
    }


    public int getPosition() {
        return position;
    }

    public Node<K, V>[] getTable() {
        return table;
    }

    public boolean insert(K key, V value) {
        boolean res = false;
        if (get(key) != null) {
            getNode(key).setValue(value);
            position++;
            res = true;
        } else {
            if (position > SIZE) {
                resize();
            }
            table[position++] = newNode(key, value);
            res = true;

        }


        return res;
    }


    public V get(K key) {
        Node<K, V> e;
        return (e = getNode(key)) == null ? null : e.getValue();
    }

    public boolean delete(K key) {
        return removeNode(key);
    }

    public Node<K, V> getNode(K key) {
        Node<K, V> res = null;
        if (position != 0 && table != null) {
            for (int i = 0; i < position; i++) {
                if (table[i].getKey().equals(key)) {
                    res = table[i];
                    break;
                }
            }
        }
        return res;
    }

    public boolean removeNode(K key) {
        boolean res = false;
        if (position != 0 && table != null) {
            for (int i = 0; i < position; i++) {
                if (table[i].getKey().equals(key)) {
                    System.arraycopy(table, i + 1, table, i, table.length - 1 - i);
                    res = true;
                    position--;
                    break;
                }
            }
        }
        return res;
    }


    public Node<K, V> newNode(K key, V value) {
        return new Node(hash(key), key, value, null);
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void resize() {
        SIZE *= 2;
        this.table = Arrays.copyOf(table, SIZE);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int iterposition = 0;

            @Override
            public boolean hasNext() {

                return iterposition < position;
            }

            @Override
            public Object next() {
                Object res = null;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    res = table[iterposition++];
                }
                return res;
            }
        };
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldvalue = value;
            value = newValue;
            return oldvalue;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }
    }
}
