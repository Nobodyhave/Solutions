package leetcode;

import java.io.FileNotFoundException;

/**
 * Created by Aleksandr on 26/04/2017.
 * Project Solutions
 */
public class LeetCodeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        System.out.println(new SearchForRange().searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
}
