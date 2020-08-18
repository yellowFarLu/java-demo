package huangy.base;

/**
 * @author huangy on 2019-05-18
 */
public abstract class Person {

    protected int a;

    Number b;

    public abstract void func();

    public static void main(String[] args) {
        Person teacher = new Teacher();
        teacher.func();

        Person man = new Man();
        man.func();
    }
}

class Teacher extends Person {

    @Override
    public void func() {
        System.out.println("Teacher func");
    }
}

class Man extends Person {

    @Override
    public void func() {
        System.out.println("Man func");
    }
}
