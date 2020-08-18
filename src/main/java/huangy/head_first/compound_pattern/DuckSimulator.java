package huangy.head_first.compound_pattern;

/**
 * @author huangy on 2019-06-09
 */
public class DuckSimulator {

    public static void main(String[] args) {
        new DuckSimulator().simulator();
    }

    void simulator() {
        Observable observable = new Observable();

        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        Quackable redHeadDuck = duckFactory.createRedHeadDuck(observable);
        Quackable duckCall = duckFactory.createDuckCall(observable);
        Quackable rubberDuck = duckFactory.createRubberDuck(observable);

        AbstractGooseFactory gooseFactory = new GooseFactory();
        Quackable gooseDuck = gooseFactory.createGoose(observable);

        //鸭子种族（鸭子树） 根节点
        Flock flockDucks = new Flock(observable);
        flockDucks.add(redHeadDuck);
        flockDucks.add(duckCall);
        flockDucks.add(rubberDuck);
        flockDucks.add(gooseDuck);

        // 创建绿头鸭小家族
        Flock flockOfMallards = new Flock(observable);
        Quackable mallardOne = duckFactory.createMallardDuck(observable);
        Quackable mallardTwo = duckFactory.createMallardDuck(observable);
        Quackable mallardThree = duckFactory.createMallardDuck(observable);
        Quackable mallardFour = duckFactory.createMallardDuck(observable);

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        // 将绿头鸭小家族 加入 鸭子种族
        flockDucks.add(flockOfMallards);

        // 创建观察者，并且把它注册为一个群的观察者
        Quackologist quackologist = new Quackologist();
        flockDucks.registerObserver(quackologist);

        simulate(flockDucks);

        System.out.println("count=" + QuackCounter.getNumberOfQuacks());
    }

    void simulate(Quackable quackable) {
        quackable.quack();
    }

}
