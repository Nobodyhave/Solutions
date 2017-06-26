package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/pascals-triangle-ii
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        if (rowIndex < 0) {
            return result;
        }

        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            row.add(1);
            for (int j = 0; j < result.size() - 1; j++) {
                row.add(result.get(j) + result.get(j + 1));
            }
            row.add(1);

            List<Integer> temp = result;
            result = row;
            row = temp;
            row.clear();
        }

        return result;
    }
}
