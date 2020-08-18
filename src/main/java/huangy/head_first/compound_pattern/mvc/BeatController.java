package huangy.head_first.compound_pattern.mvc;

/**
 * 控制器
 * @author huangy on 2019-06-09
 */
public class BeatController implements ControllerInterface {

    // MVC中，控制器在中间，所以要同时持有模型以及视图的引用。
    BeatModelInterface model;
    DJView view;

    public BeatController(BeatModelInterface model) {
        this.model = model;

        // 控制器创建视图
        view = new DJView(this, model);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();

        model.initialize();
    }

    // 控制器在得到start指令时去操纵模型和视图，下边的几个动作同理。
    public void start() {

        // 模型负责具体操作（下面几个命令同理）
        model.on();

        // 注意，控制器这时在帮视图做决定，视图只知道如何将菜单项变成开或者关而不知道在何时该这么做
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    public void stop() {

        model.off();

        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    // 控制器扩展了模型的动作
    public void increaseBPM() {
        System.out.println("controller receive increase bpm action");
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    public void decreaseBPM() {
        System.out.println("controller receive decrease bpm action");
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    public void setBPM(int bpm) {
        System.out.println("controller receive set bpm action");
        model.setBPM(bpm);
    }
}

