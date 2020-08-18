package huangy.head_first.command_pattern;

import java.util.Arrays;

/**
 * 遥控器（调用者）
 * @author huangy on 2019-05-25
 */
public class RemoteControl {

    Command[] onCommands;

    Command[] offCommands;

    // 前一个执行的命令，将放到这里
    Command undoCommand;

    public RemoteControl() {
        int totalCount = 7;

        onCommands = new Command[totalCount];
        offCommands = new Command[totalCount];

        for (int i = 0; i < totalCount; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();

            undoCommand = new NoCommand();
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    // 撤销上一步的命令
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
