package huangy.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author huangy on 2019-04-07
 */
public class HYArrays {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        int result = Arrays.binarySearch(arr, 1);

        System.out.println(result);
    }

    private void fun4() {
        Object[] arr = new Object[1];

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    private void func3() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 10 - i;
        }
        int[] descArr = new int[10];
        System.arraycopy(arr, 0, descArr, 0, descArr.length);

        System.out.println(Arrays.toString(descArr));
    }

    private void fun2() {
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    private void fun1() {
        int[] arr = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println(Arrays.equals(arr, arr2));
    }
}
