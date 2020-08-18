package huangy.head_first.command_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class LightOnCommand implements Command {

    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * 电灯
     * 动作的接收者
     */
    private Light light;

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

    @Override
    public String toString() {
        return "LightOnCommand{" +
                "light=" + light +
                '}';
    }
}
