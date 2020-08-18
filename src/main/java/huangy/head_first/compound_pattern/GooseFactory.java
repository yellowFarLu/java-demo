package huangy.head_first.compound_pattern;

import huangy.head_first.compound_pattern.ducks.Goose;

/**
 * @author huangy on 2019-06-09
 */
public class GooseFactory extends AbstractGooseFactory {

    @Override
    public Quackable createGoose(Observable observable) {
        return new GooseAdapter(observable, new Goose());
    }
}
