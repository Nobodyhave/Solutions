package leetcode;

/**
 * Created by Aleksandr on 17/08/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0;
        }

        final int[] bits = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                bits[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }

        int maxProduct = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if((bits[i] & bits[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length()*words[j].length());
                }
            }
        }

        return maxProduct;
    }
}
