package huangy.head_first.command_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }

    @Override
    public String toString() {
        return "StereoOffCommand{" +
                "stereo=" + stereo +
                '}';
    }
}
