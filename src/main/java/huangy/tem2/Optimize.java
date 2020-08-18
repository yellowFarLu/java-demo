package huangy.tem2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 请合并所有重叠的区间值，输出最简表示方式。
 *
 * 输入均为正整数区间且单个区间最小值一定不等于最大值，每个区间使用;分隔，区间最小值和最大值使用-分隔。
 *
 * 示例如下：
 *
 * 输入：1-3;2-6;8-15;9-10;
 * 输出：1-6;8-15
 *
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author huangy on 2020-04-15
 */
public class Optimize {

    /**
     * 那当前的节点和其余节点进行比较，如果有重合区间，则进行合并
     * @param input
     */
    public void optimize(String input) {

        String[] arr = input.split(";");

        List<Node> list = new ArrayList<>(arr.length);
        for (String tem : arr) {
            if (tem.isEmpty()) {
                continue;
            }

            String[] tenArr = tem.split("-");
            Node node = new Node();
            node.setBegin(Integer.parseInt(tenArr[0]));
            node.setEnd(Integer.parseInt(tenArr[1]));

            list.add(node);
        }

        while (checkIsSimple(list)) {

            list.sort(new NodeComparator());

            for (int i = 0; i < list.size(); i++) {

                for (int j = i + 1; j < list.size(); j++) {

                    if (list.get(i).getEnd() >= list.get(j).getBegin()) {

                        int end = Math.max(list.get(i).getEnd(), list.get(j).getEnd());
                        list.get(i).setEnd(end);

                        // 相当于删掉了
                        list.get(j).setBegin(Integer.MIN_VALUE);
                        list.get(j).setEnd(Integer.MIN_VALUE);
                    }
                }
            }
        }

        for (Node node : list) {
            if ((node.getBegin() == Integer.MIN_VALUE)
                    || (node.getEnd() == Integer.MIN_VALUE)) {
                continue;
            }
            System.out.println(node.getBegin() + "-" + node.getEnd());
        }
    }

    // 检查是否有重叠区间
    private boolean checkIsSimple(List<Node> list) {

        for (int i = 0; i< list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if ((list.get(i).getEnd() >= list.get(j).getBegin()) &&
                        (list.get(i).getEnd() != Integer.MIN_VALUE) &&
                        (list.get(j).getBegin() != Integer.MIN_VALUE)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Optimize().optimize("1-3;2-6;8-15;9-10;");
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getBegin() < o2.getBegin()) {
            return -1;
        } else if (o1.getBegin() > o2.getBegin()) {
            return 1;
        } else {
            if (o1.getEnd() < o2.getEnd()) {
                return -1;
            } else if (o1.getEnd() > o2.getEnd()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

class Node {

    // 开始索引
    private int begin;

    // 结束索引
    private int end;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Node{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
