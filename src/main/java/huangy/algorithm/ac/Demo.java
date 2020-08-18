package huangy.algorithm.ac;

/**
 * @author huangy on 2020-03-14
 */
public class Demo {

    public static void main(String[] args) {

        AcTree acTree = new AcTree();
        AcNode root = new AcNode();
        root.ceng = "根节点";
        acTree.root = root;

        // 构建3层，每个都是26个英文字母，每个英文字母下面都是26个
        for (int i = 0; i < 26; i++) {
            root.children[i] = new AcNode();
            root.children[i].data = (char)('a' + i);
            root.children[i].ceng = "第一层";

            for (int j = 0; j < 26; j++) {
                root.children[i].children[j] = new AcNode();
                root.children[i].children[j].data = (char)('a' + j);
                root.children[i].children[j].ceng = "第二层";

                for (int k = 0; k < 26; k++) {
                    root.children[i].children[j].children[k] = new AcNode();
                    root.children[i].children[j].children[k].data = (char)('a' + k);
                    root.children[i].children[j].children[k].length = 3;
                    root.children[i].children[j].children[k].isEndingChar = true;
                    root.children[i].children[j].children[k].ceng = "第三层";
                }
            }
        }

        acTree.buildFailurePointer();

        acTree.match("abc".toCharArray());
    }

}
