package huangy.head_first.bridging_pattern;

import huangy.head_first.bridging_pattern.image.BMPImage;
import huangy.head_first.bridging_pattern.os.LinuxImp;

/**
 * @author huangy on 2019-06-09
 */
public class DemoTest {

    public static void main(String[] args) {
        Image image = new BMPImage();
        image.setImageImp(new LinuxImp());

        image.parseFile("测试文件名字");
    }

}
