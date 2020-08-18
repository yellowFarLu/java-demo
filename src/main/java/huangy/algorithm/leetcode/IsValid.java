package huangy.algorithm.leetcode;

import java.util.*;

/**
 * 有效的括号
 * @author huangy on 2020-03-29
 */
public class IsValid {

    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }

        if (s.equals("")) {
            return true;
        }

        if (s.length() < 2) {
            return false;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        // 使用双端队列作为栈
        Deque<Character> deque = new ArrayDeque<>();

        char c;

        for (int i = 0; i < s.length(); i++) {

            c = s.charAt(i);

            if ((c == '(') || (c == '{') || (c == '[')) {
                deque.push(c);
            }

            if ((c == ')') || (c == '}') || (c == ']')) {

                if (i == 0) {
                    return false;
                }

                char left = deque.pop();

                if ((c == ')') && (left != '(')) {
                    return false;
                }

                if ((c == '}') && (left != '{')) {
                    return false;
                }

                if ((c == ']') && (left != '[')) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(
                new IsValid().isValid("[])"));;
    }

}
