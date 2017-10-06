package leetcode;

/**
 * Created by Aleksandr on 29/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-uncommon-subsequence-i
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
