package huangy.jvm;

/**
 * 内存泄漏示例
 * @author huangy on 2020-02-23
 */
public class OOMDemo {

    public static void main(String[] args) throws Exception {

        // 程序运行的时候，生成一个大的数组对象，然后没有释放
        int[] arr = new int[1024 * 1024];

        while (true) {
            Thread.sleep(1000);
        }
    }


}
