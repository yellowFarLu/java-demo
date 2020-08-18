package huangy.hythread;

import java.util.concurrent.TimeUnit;

/**
 * @author huangy on 2019-11-17
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
