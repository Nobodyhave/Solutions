package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/utf-8-validation
 */
public class Utf8Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }

        int n = data.length;
        for (int i = 0; i < n; i++) {
            final int num = data[i];
            if ((num & 0b10000000) == 0) {
                // 1-byte
            } else if ((num & 0b11100000) == 0b11000000) {
                if (i + 1 < n && (data[i + 1] & 0b11000000) == 0b10000000) {
                    // 2-byte
                    i += 1;
                } else {
                    return false;
                }
            } else if ((num & 0b11110000) == 0b11100000) {
                if (i + 1 < n && (data[i + 1] & 0b11000000) == 0b10000000) {
                    if (i + 2 < n && (data[i + 2] & 0b11000000) == 0b10000000) {
                        // 3-byte
                        i += 2;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if ((num & 0b11111000) == 0b11110000) {
                if (i + 1 < n && (data[i + 1] & 0b11000000) == 0b10000000) {
                    if (i + 2 < n && (data[i + 2] & 0b11000000) == 0b10000000) {
                        if (i + 3 < n && (data[i + 3] & 0b11000000) == 0b10000000) {
                            // 4-byte
                            i += 3;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
