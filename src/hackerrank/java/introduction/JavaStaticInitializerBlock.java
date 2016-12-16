package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-static-initializer-block
 */
public class JavaStaticInitializerBlock {
    private static int B;
    private static int H;
    private static boolean flag;

    static {
        final Scanner in = new Scanner(System.in);

        B = in.nextInt();
        H = in.nextInt();

        if (B > 0 && H > 0) {
            flag = true;
        } else {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        in.close();
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }
}
