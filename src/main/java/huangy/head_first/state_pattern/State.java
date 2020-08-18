package huangy.head_first.state_pattern;

/**
 * 糖果机 状态接口
 * @author huangy on 2019-06-08
 */
public interface State {

    /**
     * 投币
     */
    void insertQuarter();

    /**
     * 退钱
     */
    void ejectQuarter();

    /**
     * 试着转动曲柄
     */
    void turnCrank();

    /**
     * 发放糖果
     */
    void dispense();
}
