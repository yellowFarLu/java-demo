package huangy.hyenum;

/**
 * @author huangy on 2019-05-02
 */

import java.util.EnumSet;

public class EnumSetTest {

    public static void main(String[] args) {
        //1.创建一个包含Session（枚举类）里所有枚举值的EnumSet集合
        EnumSet e1 = EnumSet.allOf(Session.class);
        System.out.println(e1);//[SPRING, SUMMER, FAIL, WINTER]

        //2.创建一个空EnumSet
        EnumSet e2 = EnumSet.noneOf(Session.class);
        System.out.println(e2);//[]

        //3. add()空EnumSet集合中添加枚举元素
        e2.add(Session.SPRING);
        e2.add(Session.SUMMER);
        System.out.println(e2);//[SPRING, SUMMER]

        //4. 以指定枚举值创建EnumSet集合
        EnumSet e3 = EnumSet.of(Session.SPRING, Session.FAIL);
        System.out.println(e3);//[SPRING, FAIL]

        //5.创建一个包含从from枚举值到to枚举值范围内所有枚举值的EnumSet集合。
        EnumSet e4 = EnumSet.range(Session.SPRING,Session.FAIL);
        System.out.println(e4);//[SPRING, SUMMER, FAIL]

        //6.创建一个其元素类型与指定EnumSet里元素类型相同的EnumSet集合，
        //  新EnumSet集合包含原EnumSet集合所不包含的枚举值
        EnumSet e5 = EnumSet.complementOf(e4);
        System.out.println(e5);//[WINTER]
    }
}

//创建一个枚举
enum Session{
    SPRING,
    SUMMER,
    FAIL,
    WINTER
}
