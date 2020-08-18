package huangy.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessRead {

    public static void main(String[] args) {
        args = new String[1];
        args[0] = "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference/MyDate.java";

        RandomAccessFile raf = null;

        try {

            raf = new RandomAccessFile(args[0], "r");
//            System.out.println("RandomAccessFile的文件指针初始位置:" + raf.getFilePointer());
            // 我理解是pos按字节为单位
            raf.seek(10);

            byte[] bbuf = new byte[1024];
            int hasRead = 0;

            while ((hasRead = raf.read(bbuf)) > 0) {
                System.out.print(new String(bbuf, 0, hasRead));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
