package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/text-justification
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth == 0) {
            result.add("");
            return result;
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < words.length) {
            if (sb.length() == 0) { // Add first word to line
                sb.append(words[i]);
                i++;
            } else if (sb.length() + words[i].length() + 1 <= maxWidth) { // Adding space and next word don't exceed max length
                sb.append(" ");
                sb.append(words[i]);
                i++;
            } else {
                result.add(justify(sb, maxWidth));
                sb = new StringBuilder();
            }
        }

        for (i = sb.length(); i < maxWidth; i++) {
            sb.append(" ");
        }
        result.add(sb.toString());

        return result;
    }

    private static String justify(StringBuilder sb, int maxLength) {
        final StringBuilder result = new StringBuilder();

        final int spaceCount = calculateSpaces(sb);
        if (spaceCount == 0) {
            result.append(sb);
            for (int i = sb.length(); i < maxLength; i++) {
                result.append(" ");
            }

            return result.toString();
        }

        final int spacesToPut = maxLength - sb.length();
        final int spaces = spacesToPut / spaceCount;
        int spacesLeft = spacesToPut % spaceCount;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                for (int j = 0; j < spaces; j++) {
                    result.append(' ');
                }
                if (spacesLeft > 0) {
                    result.append(' ');
                    spacesLeft--;
                }
            }
            result.append(sb.charAt(i));
        }

        return result.toString();
    }

    private static int calculateSpaces(StringBuilder sb) {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                count++;
            }
        }

        return count;
    }
}
