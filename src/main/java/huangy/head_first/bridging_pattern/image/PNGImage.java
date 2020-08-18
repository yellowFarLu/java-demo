package huangy.head_first.bridging_pattern.image;

import huangy.head_first.bridging_pattern.Image;
import huangy.head_first.bridging_pattern.Matrix;

/**
 * PNG格式图像：扩充抽象类
 * @author huangy on 2019-06-09
 */
class PNGImage extends Image {

    public void parseFile(String fileName) {

        //模拟解析PNG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为PNG。");
    }
}

