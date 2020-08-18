package huangy.collections;

import java.util.LinkedList;
import java.util.List;

/**
 * 通过链表实现LRU算法
 * @author huangy on 2020-04-11
 */
public class LruByList {

    /**
     * 缓存长度限制
     */
    private static final Integer MAX_COUNT = 3;

    /*
     * LRU缓存
     */
    private static final List<Node> cache = new LinkedList<>();

    public Integer getValueFromCache(String key) {
        Node tem = getNodeByKey(key);

        if (tem == null) {

            tem = new Node();
            tem.key = key;
            tem.value = getValueFromDB(key);

            if (cache.size() < MAX_COUNT) {
                cache.add(tem);

            } else  {
                cache.remove(0);
                cache.add(tem);
            }

        } else {
            cache.remove(tem);
            cache.add(tem);
        }

        return tem.value;
    }

    // 穿过缓存，从数据库读取数据
    private Integer getValueFromDB(String key) {
        return Integer.parseInt(key);
    }

    private Node getNodeByKey(String key) {
        for (Node node : cache) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    /**
     * 查看缓存情况
     */
    public void viewCache() {
        System.out.println(cache);
    }

    public static void main(String[] args) {
        LruByList lruByList = new LruByList();

        for (int i = 0; i < 10; i++) {
            lruByList.getValueFromCache(String.valueOf(i));
        }

        lruByList.viewCache();
    }
}

class Node {

    String key;

    int value;

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Node) {
            Node otherNode = (Node)obj;
            return key.equals(otherNode.key);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}