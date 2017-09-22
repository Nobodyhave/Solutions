package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by Aleksandr on 18/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/lfu-cache
 */
public class LfuCache {
    private int capacity;
    private int size;
    private Map<Integer, Integer> keysMap;
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Bucket> buckets;
    private Bucket head;
    private Bucket tail;

    public LfuCache(int capacity) {
        this.capacity = capacity;

        keysMap = new HashMap<>();
        freqMap = new HashMap<>();
        buckets = new HashMap<>();

        head = new Bucket();
        tail = new Bucket();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!keysMap.containsKey(key)) {
            return -1;
        }

        int freq = freqMap.get(key);
        Bucket bucket = buckets.get(freq);
        Bucket nextF = buckets.get(freq + 1);

        if (nextF == null || nextF == tail) {
            nextF = new Bucket();
            nextF.next = bucket.next;
            bucket.next.prev = nextF;
            bucket.next = nextF;
            nextF.prev = bucket;

            buckets.put(freq + 1, nextF);
        }

        bucket.removeKey(key);
        nextF.addKey(key);
        freqMap.put(key, freq + 1);

        if (bucket.keys.size() == 0) {
            bucket.prev.next = bucket.next;
            bucket.next.prev = bucket.prev;
            bucket.next = null;
            bucket.prev = null;
            buckets.remove(freq);
        }

        return keysMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keysMap.containsKey(key)) {
            get(key);
            keysMap.put(key, value);

            return;
        }

        if (size == capacity) {
            Bucket bucket = head.next;
            int oldKey = bucket.removeFirstKey();
            int freq = freqMap.get(oldKey);
            freqMap.remove(oldKey);
            keysMap.remove(oldKey);

            if (bucket.keys.size() == 0) {
                bucket.prev.next = bucket.next;
                bucket.next.prev = bucket.prev;
                bucket.next = null;
                bucket.prev = null;
                buckets.remove(freq);
            }
            size--;
        }

        int keyFreq = freqMap.getOrDefault(key, 0);
        Bucket bucket = buckets.get(keyFreq);

        if (keyFreq == 0 && bucket == null) {
            bucket = new Bucket();
            bucket.next = head.next;
            head.next.prev = bucket;
            head.next = bucket;
            bucket.prev = head;
            bucket.addKey(key);

            buckets.put(0, bucket);
        }

        keysMap.put(key, value);
        if (!freqMap.containsKey(key)) {
            freqMap.put(key, 0);
        }
        bucket.replaceKey(key);

        size++;
    }

    private static class Bucket {
        private LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        private Bucket next;
        private Bucket prev;

        void addKey(Integer key) {
            keys.add(key);
        }

        void removeKey(int key) {
            keys.remove(key);
        }

        Integer removeFirstKey() {
            Iterator<Integer> iterator = keys.iterator();
            int val = iterator.next();
            iterator.remove();

            return val;
        }

        void replaceKey(int key) {
            removeKey(key);
            addKey(key);
        }
    }
}
