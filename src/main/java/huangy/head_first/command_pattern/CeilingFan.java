package huangy.head_first.command_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class CeilingFan {

    // 几个风扇的状态（高速、中速、低速、关闭）
    public static final int HIGH = 3;

    public static final int MEDIUM = 2;

    public static final int LOW = 3;

    public static final int OFF = 3;

    String location;

    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
    }

    public void medium() {
        speed = MEDIUM;
    }

    public void low() {
        speed = LOW;
    }

    public void off() {
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }
}
