package leetcode;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/implement-strstr
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        } else if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        } else if (needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0) {
            return -1;
        }

        outer:
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    continue outer;
                }
            }

            return i;
        }

        return -1;
    }
}
