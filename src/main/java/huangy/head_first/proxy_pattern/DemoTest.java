package huangy.head_first.proxy_pattern;

import huangy.head_first.state_pattern.NoQuarterState;

/**
 * @author huangy on 2019-06-08
 */
public class DemoTest {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine("lo", 1,
                new NoQuarterState(null));

        GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
        gumballMonitor.report();
    }

}
