package leetcode;

/**
 * Created by Aleksandr on 14/12/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/string-compression
 */
public class StringCompression {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }

        int start = 0, end = 0, compressed = 0;
        while(end < chars.length) {
            if(chars[start] == chars[end]) {
                end++;
            } else {
                compressed += compress(chars, compressed, start, end);
                start = end;
            }
        }

        compressed += compress(chars, compressed, start, end);

        return compressed;
    }

    private int compress(char[] chars, int writeIndex, int start, int end) {
        final String s = String.valueOf(end - start);
        chars[writeIndex] = chars[start];
        if(end - start >= 2) {
            for(int i = 0; i < s.length(); i++) {
                chars[writeIndex + i + 1] = s.charAt(i);
            }
            return 1 + s.length();
        } else {
            return 1;
        }
    }
}
