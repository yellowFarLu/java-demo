package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-11
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int newN = nums1.length + nums2.length;

        int[] newArr = new int[newN];

        int i = 0, j = 0;
        int k = 0;

        while ((i < nums1.length) && (j < nums2.length)) {
            if (nums1[i] <= nums2[j]) {
                newArr[k] = nums1[i];
                i++;
            } else {
                newArr[k] = nums2[j];
                j++;
            }
            k++;
        }

        if (i >= nums1.length) {
            while (j < nums2.length) {
                newArr[k] = nums2[j];
                k++;
                j++;
            }
        } else {
            while (i < nums1.length) {
                newArr[k] = nums1[i];
                k++;
                i++;
            }
        }

        int middle = newN / 2;

        if (newN % 2 == 0) {
            if ((middle - 1) >= 0) {
                return ((double) (newArr[middle - 1] + newArr[middle])) / 2;
            } else {
                return newArr[middle];
            }
        } else {
            return newArr[middle];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {};
        int[] nums2 = {2, 3};

        System.out.println(
                new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
