package leetcode;

/**
 * Created by Aleksandr on 14/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/1-bit-and-2-bit-characters
 */
public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }

        return decodable(bits, bits.length - 2);
    }

    private boolean decodable(int[] bits, int end) {
        if (end == 0) {
            return bits[0] == 0;
        } else if (end == 1) {
            return !(bits[0] == 0 && bits[1] == 1);
        }

        if (bits[end - 1] == 0 && bits[end] == 1) {
            return false;
        } else if (bits[end] == 0) {
            return decodable(bits, end - 1) || decodable(bits, end - 2);
        } else {
            return decodable(bits, end - 2);
        }
    }
}
