package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/fizz-buzz
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        final List<String> result = new ArrayList<String>();
        if(n < 1) {
            return result;
        }

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if(i % 3 == 0) {
                result.add("Fizz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
