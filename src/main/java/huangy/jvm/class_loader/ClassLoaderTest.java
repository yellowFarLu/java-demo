package huangy.jvm.class_loader;

/**
 * @author huangy on 2019-10-22
 */
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{

        // 使用自定义类加载器加载
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name)throws ClassNotFoundException{
                try{
                    String filename=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is=getClass().getResourceAsStream(filename);
                    if(is==null){
                        return super.loadClass(name);
                    }
                    byte[] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch(IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        // 通过全限定名加载这个类的二进制字节流
        Object obj =
                loader.loadClass("huangy.jvm.class_loader.ClassLoaderTest").newInstance();


        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());

        System.out.println(ClassLoaderTest.class.getClassLoader());

        // ClassLoaderTest 是系统加载器加载的类
        System.out.println(obj instanceof ClassLoaderTest);

        /*
         * 因为这时虚拟机中有两个temp.ClassLoaderTest类，一个是系统应用程序类加载器加载的，
         * 另一个是自定义的类加载器加载的，这两个类虽然来自同一个Class文件，但是加载它们的类加载器不同，
         * 导致类型检查时结果是false
         */
    }
}
