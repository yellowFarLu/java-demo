package huangy.head_first.compound_pattern.mvc;

/**
 * MVC示例
 * （1）视图、控制器、模型3层结构。
 *      流程：用户在视图上面进行操作，然后控制器取得用户的输入，并解读其对模型的意思。
 *  *      控制器调用模型，模型负责处理具体逻辑。然后通知视图更新。
 * （2）采用策略模式（控制器作为策略），观察者模式（模型和 视图、控制器解耦），组合模式（视图）
 * @author huangy on 2019-06-09
 */
public class DJTestDrive {

    public static void main (String[] args) {

        // 模型
        BeatModelInterface model = new BeatModel();

        // 控制器，相当于把模型（策略赋值给控制器）
        ControllerInterface controller = new BeatController(model);
    }
}
