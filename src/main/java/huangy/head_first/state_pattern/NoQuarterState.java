package huangy.head_first.state_pattern;

/**
 * @author huangy on 2019-06-08
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("NoQuarterState insertQuarter");
        gumballMachine.setState(gumballMachine.hasQuqrterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("NoQuarterState ejectQuarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("NoQuarterState turnCrank");
    }

    @Override
    public void dispense() {
        System.out.println("NoQuarterState dispense");
    }
}
