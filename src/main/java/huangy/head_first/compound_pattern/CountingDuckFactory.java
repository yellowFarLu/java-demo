package huangy.head_first.compound_pattern;

import huangy.head_first.compound_pattern.ducks.DuckCall;
import huangy.head_first.compound_pattern.ducks.MallardDuck;
import huangy.head_first.compound_pattern.ducks.RedHeadDuck;
import huangy.head_first.compound_pattern.ducks.RubberDuck;

/**
 * @author huangy on 2019-06-09
 */
public class CountingDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck(Observable observable) {
        return new QuackCounter(new MallardDuck(observable));
    }

    @Override
    public Quackable createRedHeadDuck(Observable observable) {
        return new QuackCounter(new RedHeadDuck(observable));
    }

    @Override
    public Quackable createDuckCall(Observable observable) {
        return new QuackCounter(new DuckCall(observable));
    }

    @Override
    public Quackable createRubberDuck(Observable observable) {
        return new QuackCounter(new RubberDuck(observable));
    }
}
