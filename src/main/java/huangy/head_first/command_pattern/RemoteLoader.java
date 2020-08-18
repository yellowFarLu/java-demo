package huangy.head_first.command_pattern;

/**
 * 客户client
 * @author huangy on 2019-05-25
 */
public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        // 客厅的电灯
        Light livingRoomLight = new Light("livingRoomLight");

        // 厨房的电灯
        Light kitchenLight = new Light("kitchenLight");

        // 客厅的音响
        Stereo livingRoomStereo = new Stereo("livingRoomStereo");

        // 为不同类型的接收者创建不同命令对象
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(livingRoomStereo);
        StereoOffCommand stereoOff = new StereoOffCommand(livingRoomStereo);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);

        System.out.println(remoteControl);

//        remoteControl.onButtonWasPushed(0);
//        remoteControl.offButtonWasPushed(0);
//
//        remoteControl.onButtonWasPushed(1);
//        remoteControl.offButtonWasPushed(1);
//
//        remoteControl.onButtonWasPushed(2);
//        remoteControl.offButtonWasPushed(2);
//
//        remoteControl.undoButtonWasPushed();

        // 使用宏命令
        Command[] onCommands = {livingRoomLightOn, kitchenLightOn};
        MacroCommand macroOnCommand = new MacroCommand(onCommands);

        Command[] offCommands = {livingRoomLightOff, kitchenLightOff};
        MacroCommand macroOffCommand = new MacroCommand(offCommands);

        remoteControl.setCommand(3, macroOnCommand, macroOffCommand);

        remoteControl.onButtonWasPushed(3);
        remoteControl.undoButtonWasPushed();

        remoteControl.offButtonWasPushed(3);
        remoteControl.undoButtonWasPushed();
    }

}
