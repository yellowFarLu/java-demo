package huangy.io;

import java.io.File;
import java.io.IOException;

/**
 * @author huangy on 2019-04-21
 */
public class Path {

    public static void main(String[] args) throws IOException {
        File file = new File(".././Test.java");
        // 相对路径
        System.out.println("getPath=" + file.getPath());
        // 绝对路径
        System.out.println("getAbsolutePath=" + file.getAbsolutePath());
        // 解析../ 或者 ./ 符号之后的绝对路径
        System.out.println("getCanonicalPath=" + file.getCanonicalPath());

        file.createNewFile();
    }

}
