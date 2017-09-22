package leetcode;

/**
 * Created by Aleksandr on 22/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/construct-the-rectangle
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        if (area < 1) {
            return new int[0];
        }

        int sqrt = (int) Math.ceil(Math.sqrt(area));

        while (sqrt < area) {
            if (area % sqrt == 0) {
                return new int[]{sqrt, area / sqrt};
            }
            sqrt++;
        }

        return new int[]{area, 1};
    }
}
