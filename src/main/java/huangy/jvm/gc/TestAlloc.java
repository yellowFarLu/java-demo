package huangy.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-11-30
 */
public class TestAlloc {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

    private void minorGc() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];

        allocation4 = new byte[4 * _1MB];  // 出现minor GC
    }

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws Exception {
        List<OOMObject> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }

        System.gc();

        list = null;
    }
}
