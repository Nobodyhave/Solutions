package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-median-from-data-stream
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> minPq = new PriorityQueue<>();
    private PriorityQueue<Integer> maxPq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    });

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if(maxPq.isEmpty()) {
            maxPq.add(num);
        } else if(minPq.isEmpty()) {
            if(num >= maxPq.peek()) {
                minPq.add(num);
            } else {
                maxPq.add(num);
                minPq.add(maxPq.poll());
            }
        } else if(maxPq.size() > minPq.size()) {
            if(num >= maxPq.peek()) {
                minPq.add(num);
            } else {
                maxPq.add(num);
                minPq.add(maxPq.poll());
            }
        } else if(maxPq.size() == minPq.size()) {
            if(num < maxPq.peek()) {
                maxPq.add(num);
            } else {
                minPq.add(num);
                maxPq.add(minPq.poll());
            }
        }
    }

    public double findMedian() {
        if(maxPq.isEmpty() && minPq.isEmpty()) {
            return 0;
        } else if(maxPq.size() > minPq.size()) {
            return maxPq.peek();
        } else {
            return (maxPq.peek() + minPq.peek()) / 2.0;
        }
    }
}
