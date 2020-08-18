package huangy.annotation.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huangy on 2019-05-02
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface Slf4j {

    /**
     * 系统名称.如果为空则取"-Dvlogging.system"系统属性,如果系统属性也为空,则取"Unknown".
     */
    String system() default "";

    /**
     * 模块名称.如果为空则取"-Dvlogging.module"系统属性,如果系统属性也为空,则取"Unknown".
     */
    String module() default "";
}
