package huangy.linux;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * 实现java程序，达到和下面的shell命令相同的效果
 * cat /home/admin/logs/data.log | grep alibaba | sort | uniq -c | sort -nr
 */
public class Tem1 {

    /**
     * 思路：
     * （1）逐行读取
     * （2）过滤
     * （3）排序（正序）
     * （4）去重，并且记录出现次数
     * （5）尝试使用数字类型排序（逆序）
     *
     * 时间复杂度：
     * 时间复杂度取决于量级比较大的项，这里量级最大的项是排序
     * 排序使用归并排序，所以时间复杂度是O(nlogn)
     * 根据递归树来求时间复杂度，每一层耗时为n，树高为log(n)，所以总的耗时就是O(n*logn)
     *
     * 空间复杂度：
     * 每一层元素进行合并，所申请的内存空间最多不会超过n个元素的大小，
     * 并且这一层合并完，就会释放掉空间，所以只要看一层的内存空间就好了。
     * 所以空间复杂度就是O(n)
     *
     * @param path 文件路径
     * @return 处理后的文本
     */
    List<Node> dealStr(String path) throws Exception {

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> temList = new ArrayList<>();
        String temStr;

        while ((temStr = bufferedReader.readLine()) != null) {
            if (temStr.contains("alibaba")) {
                temList.add(temStr);
            }
        }

        bufferedReader.close();

        temList.sort(new StringComparator());

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String str : temList) {
            if (map.containsKey(str)) {
                Integer temInt = map.get(str);
                temInt += 1;
                map.put(str, temInt);
            } else {
                map.put(str, 1);
            }
        }

        List<Node> result = new ArrayList<>();
        Node node;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            node = new Node();
            node.setStr(entry.getKey());
            node.setCount(entry.getValue());

            result.add(node);
        }

        result.sort(new NodeComparator());

        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                new Tem1().dealStr("/Users/huangyuan/Desktop/data.log"));
    }

}

class Node {
    private String str;

    private Integer count;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "str='" + str + '\'' +
                ", count=" + count +
                '}';
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        int i = 0, j = 0;

        while ((i < o1.length()) && (j < o2.length())) {
            if (o1.charAt(i) < o2.charAt(j)) {
                return -1;
            } else if (o1.charAt(i) > o2.charAt(j)) {
                return 1;
            } else {
                i++;
                j++;
            }
        }

        return 0;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {

        if (o1.getCount() < o2.getCount()) {
            return 1;
        } else if (o1.getCount() > o2.getCount()) {
            return -1;
        } else {

            String[] arr1 = o1.getStr().split(" ");
            String[] arr2 = o2.getStr().split(" ");

            int i = 0;
            int j = 0;

            while ((i < arr1.length) && (j < arr2.length)) {
                String temStr1 = arr1[i];
                String temStr2 = arr2[i];

                int ii = 0, jj = 0;

                while ((ii < temStr1.length()) && (jj < temStr2.length())) {
                    if (temStr1.charAt(i) < temStr2.charAt(j)) {
                        return 1;
                    } else if (temStr1.charAt(i) > temStr2.charAt(j)) {
                        return -1;
                    } else {
                        ii++;
                        jj++;
                    }
                }

                i++;
                j++;
            }

            return 0;
        }

    }
}