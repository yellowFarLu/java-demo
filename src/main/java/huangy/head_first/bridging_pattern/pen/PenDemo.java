package huangy.head_first.bridging_pattern.pen;

/**
 * @author huangy on 2019-10-21
 */
public class PenDemo {

    public static void main(String[] args) {
        Pen pen = new BallPen();
        pen.setColor(new Red());

        pen.draw();
    }

}
