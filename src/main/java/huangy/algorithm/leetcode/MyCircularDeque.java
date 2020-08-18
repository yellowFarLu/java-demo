package huangy.algorithm.leetcode;

/**
 * 循环双端队列
 * @author huangy on 2020-04-04
 */
public class MyCircularDeque {

    private int[] arr;

    /**
     * first指向队列第一个元素
     */
    private int first;

    /**
     * tail指向队列最后一个元素的下一个位置
     */
    private int tail;

    private int n;

    public MyCircularDeque(int k) {

        /*
         * 浪费1个存储空间来区分 队列空、队列满 的判断条件
         * （1）队列为空   first == tail
         * （2）队列满    first == (tail + 1) % n
         */
        arr = new int[k + 1];

        first = 0;
        tail = 0;

        n = arr.length;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;

        } else {
            first = ((first - 1) + n) % n;

            arr[first] = value;

            return true;
        }
    }

    public boolean insertLast(int value) {

        if (isFull()) {
            return false;

        } else {
            tail = (tail + 1) % n;

            // 注意tail-1的位置是存储最后一个元素的，又因为是在循环队列中，所以要加n后模n
            arr[(tail - 1 + n) % n] = value;

            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            first = (first + 1) % n;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            tail = ((tail - 1) + n) % n;

            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[first];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[(tail - 1 + n) % n];
        }
    }

    public boolean isEmpty() {
        return (first == tail);
    }

    public boolean isFull() {
        return (first == ((tail + 1) % n));
    }

    /**
     ["MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront","deleteFront",
     "insertFront","insertLast","insertFront","getFront","insertFront"]
     [[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
     */
    public static void main(String[] args) {

        MyCircularDeque circularDeque = new MyCircularDeque(4);

        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertFront(6));
        System.out.println(circularDeque.insertLast(5));
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(6));
    }
}
