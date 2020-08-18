package huangy.jvm.class_loader;

/**
 * @author huangy on 2019-10-22
 */
public class ApplicationClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader applicationClassLoader =
                ClassLoader.getSystemClassLoader();

        Class zclass =
                applicationClassLoader.loadClass("huangy.io.AvailableDemo");


        System.out.println(zclass);
    }

}
