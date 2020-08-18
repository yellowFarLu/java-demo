package huangy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解实例
 * @author huangy on 2019-03-31
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
    String hello() default "gege";
    String world();
    int[] array() default { 2, 4, 5, 6 };
    Class style() default String.class;
}
