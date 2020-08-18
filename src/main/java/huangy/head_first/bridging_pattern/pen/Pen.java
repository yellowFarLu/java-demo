package huangy.head_first.bridging_pattern.pen;

/**
 * 笔
 * @author huangy on 2019-10-21
 */
public abstract class Pen {

    private Color color;

    /**
     * 可以给这支笔设置颜色
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    /**
     * 绘图
     */
    public abstract void draw();
}
