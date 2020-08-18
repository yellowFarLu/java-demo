package huangy.head_first.proxy_pattern;

import huangy.head_first.state_pattern.State;

/**
 * 对象
 * @author huangy on 2019-06-08
 */
public class GumballMachine {

    String location;

    Integer count;

    State state;

    public GumballMachine(String location, Integer count, State state) {
        this.location = location;
        this.count = count;
        this.state = state;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "location='" + location + '\'' +
                ", count=" + count +
                ", state=" + state +
                '}';
    }
}
