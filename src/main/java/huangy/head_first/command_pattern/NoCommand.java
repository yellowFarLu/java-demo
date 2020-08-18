package huangy.head_first.command_pattern;

/**
 * NoCommand是空对象的一个例子，当你不想返回一个有意义的对象时，空对象就很有用。
 * 客户可以将处理null的责任转移给空对象。
 * @author huangy on 2019-05-25
 */
public class NoCommand implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }

    @Override
    public String toString() {
        return "NoCommand{}";
    }
}
