package map;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class MyHashMap<K, V> extends MyMap<K, V> {
    private final int numberOfBuckets;
    // stores first node of every bucket
    private final Object[] buckets;

    public MyHashMap() {
        this(64);
    }

    public MyHashMap(int numberOfBuckets) {
        this.numberOfBuckets = numberOfBuckets;
        buckets = new Object[numberOfBuckets];
    }

    @Getter
    @Setter
    private static class MyNode<K, V> {
        private final K key;
        private final V value;

        private MyNode<K, V> next;

        public MyNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int findBucket(Object key) {
        if (key == null) {
            return 0;
        } else {
            return key.hashCode() % this.numberOfBuckets;
        }
    }

    @Override
    public void put(K key, V value) {
        int bucket = findBucket(key);

        if (buckets[bucket] == null) {
            buckets[bucket] = new MyNode<>(key, value);
        } else {
            MyNode<K, V> temp = this.getFirstNodeFromBucket(bucket);

            while (temp.getNext() != null) {
                if (temp.getKey().equals(key)) {
                    throw new IllegalArgumentException("There is already element with that key");
                }
                temp = temp.getNext();
            }
            temp.setNext(new MyNode<>(key, value));
        }
        size++;
    }

    @Override
    public void remove(K key) {
        int bucket = findBucket(key);
        MyNode<K, V> temp = this.getFirstNodeFromBucket(bucket);
        MyNode<K, V> prevTemp = null;

        if (buckets[bucket] != null) {
            while (temp != null) {
                if (temp.getKey().equals(key)) {
                    if (prevTemp == null) {
                        buckets[bucket] = temp.getNext();
                    } else {
                        prevTemp.setNext(temp.getNext());
                    }
                    size--;
                    break;
                }
                prevTemp = temp;
                temp = temp.getNext();
            }
        }
    }

    @Override
    public void clear() {
        Arrays.fill(buckets, null);
    }

    @Override
    public V get(K key) {
        V result = null;
        MyNode<K, V> temp = this.getFirstNodeFromBucket(findBucket(key));

        while (temp != null) {
            if (temp.getKey().equals(key)) {
                result = temp.getValue();
            }
            temp = temp.getNext();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private MyNode<K,V> getFirstNodeFromBucket(int bucketIndex) {
        return (MyNode<K,V>) buckets[bucketIndex];
    }
}
