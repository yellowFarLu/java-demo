package huangy.jvm.class_loader;

/**
 * @author huangy on 2020-04-09
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        System.out.println();
        Class zclass =
                ClassLoader.getSystemClassLoader().loadClass("huangy.hyinterface.Generator");
        System.out.println(zclass);
    }

}
