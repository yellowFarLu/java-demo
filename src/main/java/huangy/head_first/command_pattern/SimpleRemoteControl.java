package huangy.head_first.command_pattern;

/**
 * 简单遥控器
 * @author huangy on 2019-05-25
 */
public class SimpleRemoteControl {

    // 插槽
    Command slot;

    // 把命令对象设置到插槽上面
    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
