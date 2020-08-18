package huangy.convert;

import com.jacob.com.*;
import com.jacob.activeX.*;

/**
 * @author huangy on 2020-03-11
 */
public class WorkToHtmlDemo {

    private static final String TARGET_PATH = "/Users/huangyuan/Desktop/";

    private static final String IMAGE_PATH = "/Users/huangyuan/Desktop/IDV端安装.doc";

    private static final String IMAGE_PATH2 = "/Users/huangyuan/Desktop/大大大.docx";

    private static final String DES_PATH = "/Users/huangyuan/Desktop/test.html";

    public static void main(String[] args) throws Exception {
        wordToHtml(IMAGE_PATH, DES_PATH);
    }

    public static boolean wordToHtml (String inPath, String toPath) {

        //启动word
        ActiveXComponent axc = new ActiveXComponent("Word.Application");

        boolean flag = false;

        try {
            //设置word不可见
            axc.setProperty("Visible",new Variant(false));

            Dispatch docs = axc.getProperty("Documents").toDispatch();

            //打开word文档
            Dispatch doc = Dispatch.invoke(
                    docs,
                    "Open",
                    Dispatch.Method,
                    new Object[]{inPath,new Variant(false), new Variant(true)},
                    new int[1]).toDispatch();

            //作为html格式保存到临时文件
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
                    toPath, new Variant(8) }, new int[1]);

            Variant f = new Variant(false);
            Dispatch.call(doc, "Close", f);
            flag = true;
            return flag;

        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        } finally{
            axc.invoke("Quit", new Variant[] {});
        }
    }

}
