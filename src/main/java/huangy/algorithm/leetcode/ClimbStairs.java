package huangy.algorithm.leetcode;

/**
 * 爬楼梯
 * @author huangy on 2020-04-04
 */
public class ClimbStairs {

    /**
     * 迭代实现
     */
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] arr = new int[n + 1];

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i -2];
        }

        return arr[n];
    }

    /**
     * 递归方式实现
     */
    public int func1 (int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return func1(n-1) + func1(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(3));;
    }
}
