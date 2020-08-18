package huangy.head_first.command_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class StereoOnWithCDCommand implements Command {

    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }

    @Override
    public String toString() {
        return "StereoOnWithCDCommand{" +
                "stereo=" + stereo +
                '}';
    }
}
