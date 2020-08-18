package huangy.hyreference;

public class NoGarbageRetrieve {

    // 结果分析：date虽然设为null，但由于JVM没有执行垃圾回收操作，MyDate的finalize()方法没有被运行。
    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
    }
}