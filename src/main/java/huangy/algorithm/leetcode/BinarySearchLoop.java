package huangy.algorithm.leetcode;

/**
 * 如果有序数组是一个循环有序数组，比如 4，5，6，1，2，3。针对这种情况，
 * 如何实现一个求“值等于给定值”的二分查找算法呢？
 *
 * @author huangy on 2020-01-19
 */
public class BinarySearchLoop {

    /**
     * 默认旋转点
     */
    private static final Integer DEFAULT_MIDDLE = -1;

    /**
     * 默认索引
     */
    private static final Integer DEFAULT_INDEX = -1;

    /**
     * （1）首先查找旋转点
     * （2）如果找不到旋转点，则整个数组使用二分查找法
     * （3）如果找到旋转点，则前后两部分分别使用二分查找算法
     * @param nums 数组
     */
    public static int binarySearchLoopFunc(int[] nums, int target) {

        // （1）首先查找旋转点
        int middle = searchMiddle(nums);


        if (middle == DEFAULT_MIDDLE) {
            // （2）如果找不到旋转点，则整个数组使用二分查找法
            return binarySearch(nums, 0, nums.length - 1, target);

        } else {
            // （3）如果找到旋转点，则前后两部分分别使用二分查找算法
            int result = binarySearch(nums, 0, middle, target);

            if (result != DEFAULT_INDEX) {
                return result;
            }

            result = binarySearch(nums, middle+1, nums.length-1, target);

            return result;
        }
    }

    private static int binarySearch(int[] nums, int begin, int end, int value) {
        int middle;

        int low = begin, high = end;

        while (low <= high) {

            middle = low + (high - low) / 2;

            if ((low == high) && (nums[middle] != value)) {
                return DEFAULT_INDEX;
            }

            if (nums[middle] == value) {
                return middle;

            } else if (value > nums[middle]) {
                low = middle + 1;

            } else {
                high = middle - 1;
            }
        }

        return DEFAULT_INDEX;
    }

    private static int searchMiddle(int[] nums) {

        int middle = DEFAULT_MIDDLE;

        for (int i = 0; i < (nums.length - 1); i++) {
            if (nums[i] > nums[i+1]) {
                middle = i;
                break;
            }
        }

        return middle;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 1, 2, 3};

        System.out.println(
                binarySearchLoopFunc(arr, 1));
    }

}
