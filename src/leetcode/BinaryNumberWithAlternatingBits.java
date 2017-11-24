package leetcode;

/**
 * Created by Aleksandr on 02/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-number-with-alternating-bits
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        return n == 0x1
                || n == 0x5
                || n == 0x15
                || n == 0x55
                || n == 0x155
                || n == 0x555
                || n == 0x1555
                || n == 0x5555
                || n == 0x15555
                || n == 0x55555
                || n == 0x155555
                || n == 0x555555
                || n == 0x1555555
                || n == 0x5555555
                || n == 0x15555555
                || n == 0x55555555
                || n == 0x2
                || n == 0xA
                || n == 0x2A
                || n == 0xAA
                || n == 0x2AA
                || n == 0xAAA
                || n == 0x2AAA
                || n == 0xAAAA
                || n == 0x2AAAA
                || n == 0xAAAAA
                || n == 0x2AAAAA
                || n == 0xAAAAAA
                || n == 0x2AAAAAA
                || n == 0xAAAAAAA
                || n == 0x2AAAAAAA
                || n == 0xAAAAAAAA;
    }
}
