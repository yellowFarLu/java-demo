package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-19
 */
public class MaxArea {

    public int maxArea(int[] height) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int gao = Math.min(height[i], height[j]);
                int kuang = j - i;
                max = Math.max(max, gao * kuang);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(
                new MaxArea().maxArea(arr));
    }
}
