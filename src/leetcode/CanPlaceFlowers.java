package leetcode;

/**
 * Created by Aleksandr on 16/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/can-place-flowers
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        } else if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }

            if (i == 0) {
                if (flowerbed.length == 1 || flowerbed[i + 1] == 0) {
                    count++;
                    i++;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0) {
                    count++;
                    i++;
                }
            } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                count++;
                i++;
            }
        }

        return count >= n;
    }
}
