package huangy.head_first.compound_pattern;

/**
 * @author huangy on 2019-06-09
 */
public class QuackCounter implements Quackable {

    Quackable quackable;

    // 统计叫声的次数
    static int numberOfQuacks;

    public QuackCounter(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        quackable.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }

    @Override
    public void registerObserver(Observer observer) {
        quackable.registerObserver(observer);
    }

    @Override
    public void notifyObservers(Quackable quackable) {
        quackable.notifyObservers(quackable);
    }
}
