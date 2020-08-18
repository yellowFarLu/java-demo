package huangy.io;

/**
 * @author huangy on 2019-11-16
 */
public class SizeDemo {

    public static void main(String[] args) {
        // 得到当前的系统属性
        String encoding = System.getProperty("file.encoding");
        System.out.println("当前编码:" + encoding);
        try {
            String str = "a";
            int len = str.getBytes().length;
            System.out.println("1.按操作系统默认编码来编码:" + len);

            len = str.getBytes("GBK").length;
            System.out.println("2.GBK编码的字节数："+ len);

            len = str.getBytes("UTF-8").length;
            System.out.println("3.UTF-8编码的字节数：" + len);

            len = str.getBytes("Unicode").length;
            System.out.println("4.Unicode编码的字节数：" + len);



        }  catch ( java.io.UnsupportedEncodingException e)  {
            System.out.println(e.getMessage().toString());
        }
    }

}
