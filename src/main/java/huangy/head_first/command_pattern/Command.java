package huangy.head_first.command_pattern;

/**
 * 所有命令对象的通用接口
 * @author huangy on 2019-05-25
 */
public interface Command {

    /**
     * 执行命令
     */
    void execute();

    /**
     * 撤销刚刚执行的命令
     */
    void undo();
}
