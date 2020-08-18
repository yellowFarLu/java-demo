package huangy.head_first.state_pattern;

/**
 * 糖果机  （Context）
 * @author huangy on 2019-06-08
 */
public class GumballMachine {

    /**
     * 糖果机的状态
     */
    State soldOutState;

    State noQuqrterState;

    State hasQuqrterState;

    State soldState;

    // 当前状态
    State state = soldOutState;

    // 糖果数目
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        soldOutState = new SoldOutState(this);
        noQuqrterState = new NoQuarterState(this);
        hasQuqrterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        if (count > 0) {
            // Context里面可以改变状态
            state = noQuqrterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("releaseBall");

        if (count != 0) {
            count--;
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
