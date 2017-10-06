package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 26/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/keyboard-row
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        final Set<Character> firstRow = new HashSet<>();
        final Set<Character> secondRow = new HashSet<>();
        final Set<Character> thirdRow = new HashSet<>();

        firstRow.add('Q');
        firstRow.add('W');
        firstRow.add('E');
        firstRow.add('R');
        firstRow.add('T');
        firstRow.add('Y');
        firstRow.add('U');
        firstRow.add('I');
        firstRow.add('O');
        firstRow.add('P');
        firstRow.add('q');
        firstRow.add('w');
        firstRow.add('e');
        firstRow.add('r');
        firstRow.add('t');
        firstRow.add('y');
        firstRow.add('u');
        firstRow.add('i');
        firstRow.add('o');
        firstRow.add('p');

        secondRow.add('A');
        secondRow.add('S');
        secondRow.add('D');
        secondRow.add('F');
        secondRow.add('G');
        secondRow.add('H');
        secondRow.add('J');
        secondRow.add('K');
        secondRow.add('L');
        secondRow.add('a');
        secondRow.add('s');
        secondRow.add('d');
        secondRow.add('f');
        secondRow.add('g');
        secondRow.add('h');
        secondRow.add('j');
        secondRow.add('k');
        secondRow.add('l');

        thirdRow.add('Z');
        thirdRow.add('X');
        thirdRow.add('C');
        thirdRow.add('V');
        thirdRow.add('B');
        thirdRow.add('N');
        thirdRow.add('M');
        thirdRow.add('z');
        thirdRow.add('x');
        thirdRow.add('c');
        thirdRow.add('v');
        thirdRow.add('b');
        thirdRow.add('n');
        thirdRow.add('m');

        final List<String> resultList = new ArrayList<>();

        outer:
        for (String word : words) {
            final char firstLetter = word.charAt(0);
            Set<Character> row;
            if (firstRow.contains(firstLetter)) {
                row = firstRow;
            } else if (secondRow.contains(firstLetter)) {
                row = secondRow;
            } else {
                row = thirdRow;
            }

            for (int i = 1; i < word.length(); i++) {
                if (!row.contains(word.charAt(i))) {
                    continue outer;
                }
            }

            resultList.add(word);
        }

        final String[] result = new String[resultList.size()];
        resultList.toArray(result);

        return result;
    }
}
