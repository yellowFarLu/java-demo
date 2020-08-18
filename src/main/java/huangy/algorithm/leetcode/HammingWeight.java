package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-06-27
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;

        int mask = 1;

        for (int i = 0; i < 32; i++) {
            int tem = n & mask;
            if (tem != 0) {
                count++;
            }
            mask = mask << 1;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
