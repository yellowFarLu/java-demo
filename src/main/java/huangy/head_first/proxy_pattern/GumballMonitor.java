package huangy.head_first.proxy_pattern;

/**
 * 代理对象
 * @author huangy on 2019-06-08
 */
public class GumballMonitor {

    GumballMachine gumballMachine;

    public GumballMonitor(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report() {
        System.out.println(gumballMachine);
    }
}
