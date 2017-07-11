package leetcode;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/excel-sheet-column-title
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        final StringBuilder sb = new StringBuilder();

        int div = 26;
        while (n > 0) {
            sb.append((char) ((n - 1) % div + 'A'));
            n = (n - 1) / div;
        }

        return sb.reverse().toString();
    }
}
