package leetcode;

/**
 * Created by Aleksandr on 23/08/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 */
public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 2) {
            return s;
        }

        final char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while(i < j) {
            while(i < j && !isVowel(str[i])) {
                i++;
            }

            while(j > i && !isVowel(str[j])) {
                j--;
            }

            if(i < j) {
                final char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
            i++;
            j--;
        }

        return new String(str);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I';
    }
}
