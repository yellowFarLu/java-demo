package huangy.head_first.state_pattern;

/**
 * @author huangy on 2019-06-08
 */
public class DemoTest {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();


        System.out.println(gumballMachine);
    }

}
