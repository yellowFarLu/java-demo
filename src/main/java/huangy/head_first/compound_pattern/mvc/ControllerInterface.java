package huangy.head_first.compound_pattern.mvc;

/**
 * 控制器接口（策略）
 * @author huangy on 2019-06-09
 */
public interface ControllerInterface {
    void start();
    void stop();
    void increaseBPM();
    void decreaseBPM();
    void setBPM(int bpm);
}
