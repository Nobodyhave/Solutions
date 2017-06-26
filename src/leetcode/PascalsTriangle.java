package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/pascals-triangle
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<>();

        generate(result, numRows);

        return result;
    }

    private static void generate(List<List<Integer>> result, int numRows) {
        if (numRows == 0) {
            return;
        }

        final List<Integer> row = new ArrayList<>();
        if (result.isEmpty()) {
            row.add(1);
            result.add(row);
        } else {
            row.add(1);
            final List<Integer> lastRow = result.get(result.size() - 1);
            for (int i = 0; i < lastRow.size() - 1; i++) {
                row.add(lastRow.get(i) + lastRow.get(i + 1));
            }
            row.add(1);
            result.add(row);
        }

        generate(result, numRows - 1);
    }
}
