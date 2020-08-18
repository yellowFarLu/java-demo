package huangy.hyreference;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * 重定向标淮输出流
 * 1.初始化PrintStream对象
 * 2.调用System.setOut()方法，将标淮输出流重定向至PrintStream对象
 * 3.操作System.out流，
 */
public class ReOut {

    public static void main(String[] args) {

        try {
            //1.声明一个输出流PrintStream对象
            PrintStream ps = new PrintStream(
                    new FileOutputStream(
                            "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference/test.txt",
                            true));   //追加内容

            //2.重定向标淮输出流  把System.out重定向到ps
            System.setOut(ps);

            //3.使用PrintStream对象向流中写信息
            System.out.println(new ReOut());

            ps.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}