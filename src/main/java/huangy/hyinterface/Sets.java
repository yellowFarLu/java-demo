package huangy.hyinterface;

import java.util.HashSet;
import java.util.Set;

/**
 * set的集合运算
 * @author huangy on 2019-04-06
 */
public class Sets {

    // 并集
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    // 交集
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    // 差集
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    // 包含了除了交集以外的所有元素
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        Set<T> unionSet = union(a, b);
        Set<T> intersectionSet = intersection(a, b);
        return difference(unionSet, intersectionSet);
    }
}
