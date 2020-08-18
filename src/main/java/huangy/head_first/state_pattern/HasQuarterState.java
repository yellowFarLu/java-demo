package huangy.head_first.state_pattern;

/**
 * @author huangy on 2019-06-08
 */
public class HasQuarterState implements State {

    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("HasQuarterState insertQuarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("HasQuarterState ejectQuarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("HasQuarterState turnCrank");
        // 状态里面可以改变状态
        gumballMachine.setState(gumballMachine.soldState);
    }

    @Override
    public void dispense() {
        System.out.println("HasQuarterState dispense");
    }
}
