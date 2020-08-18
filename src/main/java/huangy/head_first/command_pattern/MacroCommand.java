package huangy.head_first.command_pattern;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 宏命令
 * @author huangy on 2019-05-25
 */
public class MacroCommand implements Command {

    Command[] commands;

    Deque<Command> deque;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
        deque = new LinkedList<>();
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
            deque.push(command);
        }
    }

    @Override
    public void undo() {
        while (!deque.isEmpty()) {
            Command command = deque.pop();
            command.undo();
        }
    }
}
