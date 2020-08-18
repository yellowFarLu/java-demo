package huangy.head_first.bridging_pattern.pen;

/**
 * 圆珠笔
 * @author huangy on 2019-10-21
 */
public class BallPen extends Pen {

    @Override
    public void draw() {
        System.out.println("BallPen draw, and my color is " + getColor());
    }
}
