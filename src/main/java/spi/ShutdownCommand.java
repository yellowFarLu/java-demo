package spi;

/**
 * @author huangy on 2019-10-27
 */
public class ShutdownCommand implements Cmand {

    public void execute() {
        System.out.println("shutdown....");
    }

}
