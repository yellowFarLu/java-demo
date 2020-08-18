package huangy.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author huangy on 2020-04-19
 */
public class CanJump {

    private boolean tag = false;

    public boolean canJump(int[] nums) {

        // 标识前面是否有路径到达当前节点
        boolean[] tagArr = new boolean[nums.length];
        tagArr[0] = true;

        int target = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {

                int next = i + j;

                // 可以到达当前节点，并且距离也能到达下一个节点，才把下个节点设置为可达
                if (tagArr[i] && (next < nums.length)) {
                    tagArr[next] = true;
                }
            }

            // 有路径可以到达当前节点，并且当前节点可以跳跃到末尾
            int maxYuan = i + nums[i];

            if (tagArr[i] && (maxYuan >= target)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump1(int[] nums) {
        dfs(nums, 0);
        return tag;
    }

    public boolean canJump2(int[] nums) {
        return queueMethod(nums);
    }

    /**
     * 回溯法
     */
    private void dfs(int[] nums, int j) {
        if (j == (nums.length - 1)) {
            tag = true;
            return;
        }

        if (j >= nums.length) {
            return;
        }

        for (int i = 1; i <= nums[j]; i++) {
            dfs(nums, j + i);
        }
    }

    /**
     * 使用队列实现非递归
     */
    private boolean queueMethod(int[] nums) {

        // 数组长度为1，肯定能走到最后一个元素了
        if (nums.length == 1) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();

        for (int i = 1; i <= nums[0]; i++) {
            Node node = new Node();
            node.setI(0);
            node.setJ(i);
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int next = current.getI() + current.getJ();

            // 下一次就能走到了，直接返回true
            if (next == (nums.length - 1)) {
                return true;
            }

            if (next >= nums.length) {
                continue;
            }

            for (int i = 1; i <= nums[next]; i++) {
                Node tem = new Node();
                tem.setI(next);
                tem.setJ(i);
                queue.add(tem);
            }
        }

        return false;
    }

    class Node {

        // 当前位置
        int i;

        // 下一步走多少
        int j;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(
                new CanJump().canJump(nums));
    }
}

