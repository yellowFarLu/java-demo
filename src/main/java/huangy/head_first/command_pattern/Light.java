package huangy.head_first.command_pattern;

/**
 * 电灯
 * @author huangy on 2019-05-25
 */
public class Light {

    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + "Light on");
    }

    public void off() {
        System.out.println(name + "Light off");
    }

    @Override
    public String toString() {
        return "Light{" +
                "name='" + name + '\'' +
                '}';
    }
}
