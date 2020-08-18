package huangy.jvm.class_loader;

import sun.misc.Launcher;

/**
 * @author huangy on 2019-10-22
 */
public class ExtensionClassLoaderDemo {

    public static void main(String[] args) throws Exception {

        /*
         * 获取系统类加载器
         */
        ClassLoader loader = Launcher.getLauncher().getClassLoader();

        /*
         * 系统类加载器的父加载器是扩展类加载器
         */
        ClassLoader extClassLoader = loader.getParent();
        System.out.println(extClassLoader);

        Class zclass = extClassLoader.loadClass("InitDemo");
        System.out.println(zclass);
    }

}
