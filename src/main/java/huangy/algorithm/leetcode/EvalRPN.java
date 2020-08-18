package huangy.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 逆波兰表示式
 * @author huangy on 2020-04-04
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+")) {

                Integer one = stack.pop();
                Integer two = stack.pop();
                Integer result = one + two;
                stack.push(result);

            } else if (tokens[i].equals("-")) {

                Integer one = stack.pop();
                Integer two = stack.pop();
                Integer result = two - one;
                stack.push(result);

            } else if (tokens[i].equals("*")) {

                Integer one = stack.pop();
                Integer two = stack.pop();
                Integer result = one * two;
                stack.push(result);

            } else if (tokens[i].equals("/")) {

                Integer one = stack.pop();
                Integer two = stack.pop();
                Integer result = two / one;
                stack.push(result);

            } else {
                stack.push(
                        Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(new EvalRPN().evalRPN(tokens));;
    }
}
