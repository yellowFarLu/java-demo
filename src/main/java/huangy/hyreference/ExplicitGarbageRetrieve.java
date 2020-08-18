package huangy.hyreference;

public class ExplicitGarbageRetrieve {

    // 结果分析：调用了System.gc()，使JVM运行垃圾回收，MyDate的finalize()方法被运行。
    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
        System.gc();
    }

}