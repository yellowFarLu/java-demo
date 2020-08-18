package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2020-06-27
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result= new ArrayList<>();

        boolean mod3, mod5;

        for (int i = 1; i <= n; i++) {
            mod3 = (i % 3 == 0);
            mod5 = (i % 5 == 0);

            if (mod3 && mod5) {
                result.add("FizzBuzz");
            } else if (mod3) {
                result.add("Fizz");
            } else if (mod5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

}
