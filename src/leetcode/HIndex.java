package leetcode;

/**
 * Created by Aleksandr on 11/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/h-index/description/
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }

        final int n = citations.length;
        final int[] buckets = new int[n+1];

        for(int i = 0; i < citations.length; i++) {
            if(citations[i] > n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }

        int sum = 0;
        for(int i = n; i >= 0; i--) {
            sum += buckets[i];
            if(sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
