package module9.homework;

import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Node<K, V>[] table = new Node[DEFAULT_INITIAL_CAPACITY];
    int threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);
    int size;

    @Override
    public V put(K key, V value) {
        if (size + 1 >= threshold) {
            grow();
            put(key, value);
            return value;
        }
        int index = hash(key);
        Node<K, V> newNode = new Node<>(hash(key), key, value, null);

        // Adding without collision
        if (table[index] == null) {
            return putFirst(newNode, index);
        }
        // Adding with collision or update
        Node<K, V> current = table[index];
        //When the Node is not one
        while (current.next != null) {
            if (comparing(newNode, current)) {
                return value;
            }
            current = current.next;
        }
        //When the Node is one
        if (comparing(newNode, current)) {
            return value;
        } else {
            current.next = newNode;
            size++;
        }
        return value;
    }
    private void grow() {
        Node<K, V>[] old = table;
        table = new Node[old.length * 2];
        size = 0;

        for (int i = 0; i < old.length; i++) {
            if (old[i] == null) {
                continue;
            }
            while (old[i].next != null) {
                put(old[i].key, old[i].value);
                old[i] = old[i].next;
            }
            put(old[i].key, old[i].value);
        }
        threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);
    }
    private boolean comparing(Node<K, V> newNode, Node<K, V> current) {
        if (current.key.equals(newNode.key)) {
            current.value = newNode.value;
            return true;
        }
        return false;
    }
    private V putFirst(Node<K, V> newNode, int hash) {
        table[hash] = newNode;
        size++;
        return newNode.value;
    }
    @Override
    public V remove(Object key) {
        Node<K, V> toRemove;
        Node<K, V> prev;
        K keyToDel = (K) key;
        V valToDel = null;
        int index = hash(key);
            // When the bucket is null.
            if (table[index] == null) {
                return  null;
            }
            // When the bucket has a one node, and it's a desired value.
            if (table[index].key.equals(keyToDel) && table[index].next == null) {
                valToDel = table[index].value;
                table[index] = null;
                size--;
                return valToDel;
            }
            // When the bucket has more than one node and first is a desired value.
            if (table[index].key.equals(keyToDel)) {
                valToDel = table[index].value;
                table[index] = table[index].next;
                size--;
                return valToDel;
            }
            // Pointers for moving through the bucket
            toRemove = table[index];
            prev = table[index];
            // Iteration the bucket except last node
            while (toRemove.next != null) {
                if (toRemove.key.equals(keyToDel)) {
                    valToDel = toRemove.value;
                    prev.next = toRemove.next;
                    size--;
                    return valToDel;
                }
                prev = toRemove;
                toRemove = toRemove.next;
            }
            // Processing the last node
            if (toRemove.key.equals(keyToDel)) {
                valToDel = toRemove.value;
                prev.next = null;
                size--;
                return valToDel;
            }
        // When there is no matching
        return null;
    }
    @Override
    public void clear() {
        if ( table != null && size > 0) {
            size = 0;
            for (int i = 0; i < table.length; ++i)
                table[i] = null;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public V get(Object key) {
        if (size == 0) {
            return null;
        }
        int index = hash(key);
        Node<K, V> toGet;
            if (table[index] == null) {
                return null;
            }
            toGet = table[index];
            while (toGet.next != null){
                if (toGet.key.equals(key)){
                    return toGet.value;
                }
                toGet = toGet.next;
            }
            if(toGet.key.equals(key)){
                return toGet.value;
            }
        return null;
    }



    static class Node<K, V> implements MyMap.Entry<K, V> {
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
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return key.equals(node.key) && value.equals(node.value);
        }
        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    final int hash(Object key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }
}
