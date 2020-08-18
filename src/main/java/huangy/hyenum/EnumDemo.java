package huangy.hyenum;

import java.util.EnumSet;

/**
 * @author huangy on 2019-05-02
 */
public class EnumDemo {

    public static void main(String[] args) {
        EnumSet<TestEnum> enums = EnumSet.noneOf(TestEnum.class);

        enums.add(TestEnum.TWO);
        enums.add(TestEnum.ONE);
        enums.add(null);

        System.out.println(enums);
    }

}

enum TestEnum {
    ONE,
    TWO
    ;
}