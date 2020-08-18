package huangy.head_first.componet_pattern;

import huangy.head_first.iterator_pattern.Iterator;

/**
 * 空迭代器
 * （1）目的：避免客户端使用if null判断
 * @author huangy on 2019-06-08
 */
public class NullIterator implements Iterator {

    @Override
    public Object next() {
        return null;
    }

    // hasNext永远返回false
    @Override
    public boolean hasNext() {
        return false;
    }
}
