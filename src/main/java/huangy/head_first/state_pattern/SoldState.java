package huangy.head_first.state_pattern;

/**
 * @author huangy on 2019-06-08
 */
public class SoldState implements State {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("SoldState insertQuarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("SoldState ejectQuarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("SoldState turnCrank");
    }

    @Override
    public void dispense() {
        System.out.println("SoldState dispense");
    }
}
