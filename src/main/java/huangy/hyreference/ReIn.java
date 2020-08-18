package huangy.hyreference;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/*
 * 重定向输入
 * 1.有一个已经初始化的InputStream输入流
 * 2.调用System.setIn()方法，将标淮输入流重定向到目的输入流
 * 3.读取System.in中的内容
 */
public class ReIn {

    public static void main(String[] args) throws UnsupportedEncodingException {


        try {
            //1.声明一个输入流
            FileInputStream fis = new FileInputStream(
                    "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference/test.txt");

            //2.重定向
            System.setIn(fis);

            //3.读取System.in标准输入流中的内容
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in, "UTF-8")); //设置字符编码

            //4.输出System.in中的内容
            String line;

            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            //5.关闭流
            br.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
