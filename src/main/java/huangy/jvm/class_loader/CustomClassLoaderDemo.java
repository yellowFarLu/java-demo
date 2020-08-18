package huangy.jvm.class_loader;

/**
 * 并行加载类示例
 * @author huangy on 2019-10-22
 */
public class CustomClassLoaderDemo {

    public static void main(String[] args) throws Exception {

        // 自定义类加载器
        ClassLoader customClassLoader = new CustomClassLoader();

        Class zclass = customClassLoader.loadClass("huangy.hyinterface.Generator");

        System.out.println(zclass);
    }
}


class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // 这里加载二进制字节流的方式可以自己决定
        return super.loadClass(name, resolve);
    }

    static {
        // 注册，让类加载器支持并行加载类
        ClassLoader.registerAsParallelCapable();
    }
}