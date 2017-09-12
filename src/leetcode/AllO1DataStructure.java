package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/all-oone-data-structure
 */
public class AllO1DataStructure {
    private Map<Integer, Bucket> buckets;
    private Map<String, Integer> keyCount;
    private Bucket head;
    private Bucket tail;

    /** Initialize your data structure here. */
    public AllO1DataStructure() {
        keyCount = new HashMap<>();
        buckets = new HashMap<>();
        head = new Bucket();
        tail = new Bucket();
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Integer count = keyCount.get(key);
        if(count == null) {
            Bucket bucket = buckets.get(1);
            if(bucket == null) {
                bucket = new Bucket();
                bucket.count = 1;
                bucket.next = head.next;
                bucket.prev = head;
                head.next.prev = bucket;
                head.next = bucket;
                buckets.put(1, bucket);
            }
            bucket.addKey(key);
        } else {
            Bucket bucket = buckets.get(count);
            Bucket bucketInc = buckets.get(count + 1);

            if(bucketInc == null) {
                bucketInc = new Bucket();
                bucketInc.count = count + 1;
                buckets.put(count + 1, bucketInc);
                bucketInc.next = bucket.next;
                bucketInc.prev = bucket;
                bucket.next.prev = bucketInc;
                bucket.next = bucketInc;
            }
            bucket.removeKey(key);
            bucketInc.addKey(key);

            if(bucket.size == 0) {
                bucket.prev.next = bucketInc;
                bucketInc.prev = bucket.prev;
                bucket.next = null;
                bucket.prev = null;
                buckets.remove(count);
            }
        }
        keyCount.put(key, count != null ? count + 1 : 1);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Integer count = keyCount.get(key);
        if(count == null) {
            return;
        } else if(count == 1) {
            Bucket bucket = buckets.get(count);
            bucket.removeKey(key);
            if(bucket.size == 0) {
                head.next = bucket.next;
                bucket.next.prev = head;
                bucket.next = null;
                bucket.prev = null;
                buckets.remove(count);
            }
            keyCount.remove(key);
        } else {
            Bucket bucket = buckets.get(count);
            Bucket bucketDec = buckets.get(count - 1);

            if(bucketDec == null) {
                bucketDec = new Bucket();
                bucketDec.count = count - 1;
                buckets.put(count - 1, bucketDec);
                bucketDec.next = bucket;
                bucketDec.prev = bucket.prev;
                bucket.prev.next = bucketDec;
                bucket.prev = bucketDec;
            }
            bucket.removeKey(key);
            bucketDec.addKey(key);

            if(bucket.size == 0) {
                bucket.next.prev = bucketDec;
                bucketDec.next = bucket.next;
                bucket.next = null;
                bucket.prev = null;
                buckets.remove(count);
            }
            keyCount.put(key, count - 1);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private static class Bucket {
        private int count;
        private int size;
        private Set<String> keys = new HashSet<>();
        private Bucket next;
        private Bucket prev;

        void addKey(String key) {
            keys.add(key);
            size = keys.size();
        }

        void removeKey(String key) {
            keys.remove(key);
            size = keys.size();
        }
    }
}
