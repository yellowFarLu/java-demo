package huangy.hyinterface;

/**
 * @author huangy on 2019-04-07
 */
public class PayableDemo {
}

interface Payable<T> {}

class Employee implements Payable<Person> {}

class Hourly implements Payable<SubPerson> {}

