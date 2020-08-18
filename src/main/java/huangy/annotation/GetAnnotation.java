package huangy.annotation;

import java.lang.reflect.Method;

/**
 * @author huangy on 2019-05-02
 */
public class GetAnnotation {

    public static void main(String[] args) {
        Method[] methods
                = MyTest.class.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getAnnotations());
        }
    }

}
