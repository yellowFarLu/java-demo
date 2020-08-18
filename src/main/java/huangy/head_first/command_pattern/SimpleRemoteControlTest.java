package huangy.head_first.command_pattern;

/**
 * SimpleRemoteControlTest是命令模式的客户client
 * @author huangy on 2019-05-25
 */
public class SimpleRemoteControlTest {

    public static void main(String[] args) {

        // 遥控器就是调用者
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light ligh = new Light("test");
        LightOnCommand lightOnCommand = new LightOnCommand(ligh);

        // 把命令传递给调用者
        simpleRemoteControl.setSlot(lightOnCommand);

        // 模拟按下按钮
        simpleRemoteControl.buttonWasPressed();
    }


}
