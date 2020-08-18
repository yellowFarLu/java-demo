package huangy.head_first.command_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class LightOffCommand implements Command {

    public LightOffCommand(Light light) {
        this.light = light;
    }

    /**
     * 电灯
     * 动作的接收者
     */
    private Light light;

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }

    @Override
    public String toString() {
        return "LightOffCommand{" +
                "light=" + light +
                '}';
    }
}
