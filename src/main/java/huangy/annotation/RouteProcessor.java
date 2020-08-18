package huangy.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author huangy on 2019-05-02
 */
public class RouteProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment env){
        // 主要做一些初始化操作
    }

    @Override
    public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment env) {
        //具体处理注解的逻辑，控制代码的生成
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        // 支持处理的注解类型, 在这里就是@Route
        return null;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        //java版本 如：jdk1.6or jdk1.7
        return null;
    }

}