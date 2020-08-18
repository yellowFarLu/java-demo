package huangy.algorithm.ac;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Ac自动机
 * @author huangy on 2020-03-14
 */
public class AcTree {

    public AcNode root;

    /**
     * 构建失败指针
     */
    public void buildFailurePointer() {

        Queue<AcNode> queue = new LinkedList<>();

        root.fail = null;

        queue.add(root);

        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null) continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    /**
     * 匹配主串
     * @param text 主串
     */
    public void match(char[] text) {

        int n = text.length;
        AcNode p = root;

        for (int i = 0; i < n; ++i) {

            int idx = text[i] - 'a';

            while (p.children[idx] == null && p != root) {
                p = p.fail; // 失败指针发挥作用的地方
            }

            p = p.children[idx];

            if (p == null) p = root; // 如果没有匹配的，从root开始重新匹配
            AcNode tmp = p;

            while (tmp != root) { // 打印出可以匹配的模式串

                if (tmp.isEndingChar) {
                    int pos = i-tmp.length+1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }

                tmp = tmp.fail;
            }
        }
    }
}
