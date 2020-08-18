package huangy.head_first.command_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class CeilingFanHighCommand implements Command {

    private CeilingFan ceilingFan;

    private int preSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.high();
        preSpeed = ceilingFan.getSpeed();
    }

    @Override
    public void undo() {
        ceilingFan.speed = preSpeed;
    }
}
