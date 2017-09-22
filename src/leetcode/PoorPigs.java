package leetcode;

/**
 * Created by Aleksandr on 15/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/poor-pigs
 */
public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log10(buckets) / Math.log10(minutesToTest / minutesToDie + 1));
    }
}
