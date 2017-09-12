package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 29/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/mini-parser
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        final List<String> split = split(s.substring(1, s.length() - 1));
        final NestedInteger ni = new NestedInteger();
        for (String str : split) {
            ni.add(deserialize(str));
        }

        return ni;
    }

    private List<String> split(String s) {
        final List<String> result = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                while (i < s.length() && s.charAt(i) != ',') {
                    sb.append(s.charAt(i));
                    i++;
                }
                result.add(sb.toString());
                sb = new StringBuilder();
            } else if (s.charAt(i) == '[') {
                int count = 0;
                do {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    sb.append(s.charAt(i));
                    i++;
                } while (count != 0);
                result.add(sb.toString());
                sb = new StringBuilder();
            } else {
                i++;
            }
        }

        return result;
    }

    private static class NestedInteger {
        NestedInteger() {
        }

        NestedInteger(int value) {
        }

        public boolean isInteger() {
            return false;
        }

        public Integer getInteger() {
            return -1;
        }

        public void setInteger(int value) {
        }

        public void add(NestedInteger ni) {
        }

        public List<NestedInteger> getList() {
            return null;
        }
    }
}
