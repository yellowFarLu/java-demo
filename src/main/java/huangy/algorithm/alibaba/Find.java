package huangy.algorithm.alibaba;

/**
 * 从一个数组找出第m大到第n大的数
 * @author huangy on 2020-07-10
 */
public class Find {

    public int[] func(int[] nums, int m, int n) {

        // 先进行排序
        sort(nums);

        // 下标[m, n]则是第m到第n大的数
        int len = n - m + 1;
        int[] result = new int[len];
        // m - 1是因为我们从1开始算
        System.arraycopy(nums, m - 1, result, 0, len);
        return result;
    }

    // 选择排序(逆序)
    public void sort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {

            // 假设当前元素是未排序区间最大的元素
            int max = i;

            // 找出未排序区间最大的数字
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[max]) {
                    max = j;
                }
            }

            // 交换
            int tem = nums[i];
            nums[i] = nums[max];
            nums[max] = tem;
        }
    }

    public static void main(String[] args) {
        int[] tem = {3, 2, 6, 5, 4, 1};
        int[] result = new Find().func(tem, 3, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
