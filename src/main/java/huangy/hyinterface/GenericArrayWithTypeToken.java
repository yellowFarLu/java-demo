package huangy.hyinterface;

import java.lang.reflect.Array;

/**
 * @author huangy on 2019-04-06
 */
public class GenericArrayWithTypeToken <T> {

    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        this.array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        Integer[] ia = gai.rep();

        for (int i = 0; i < ia.length; i++) {
            System.out.print(ia[i] + " ");
        }
    }
}
