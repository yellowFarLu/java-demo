package huangy.head_first.bridging_pattern;

/**
 *
 * 抽象图像类：抽象类
 * @author huangy on 2019-06-09
 */
public abstract class Image {

    protected ImageImp imp;

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}


