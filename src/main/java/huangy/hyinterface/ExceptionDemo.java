package huangy.hyinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-04-07
 */
public class ExceptionDemo {

    public static void main(String[] args) {

        ProcessorRunner<String, Failure1> runner = new ProcessorRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            e.printStackTrace();
        }

        ProcessorRunner<Integer, Failure2> runner2 = new ProcessorRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }

        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            e.printStackTrace();
        }
    }

}

interface Processor<T, E extends Exception> {
    // 只有E是继承了Exception
    void process(List<T> resultCollector) throws E;
}

class ProcessorRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }

        return resultCollector;
    }
}

class Failure1 extends Exception {}

class Processor1 implements Processor<String, Failure1> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }

        if (count < 0) {
            throw new Failure1();
        }
    }
}

class Failure2 extends Exception {}

class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }

        if (count < 0) {
            throw new Failure2();
        }
    }
}
