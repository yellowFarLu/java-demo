package huangy.head_first.state_pattern;

/**
 * @author huangy on 2019-06-08
 */
public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("SoldOutState insertQuarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("SoldOutState ejectQuarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("SoldOutState turnCrank");
    }

    @Override
    public void dispense() {
        System.out.println("SoldOutState dispense");
    }
}
