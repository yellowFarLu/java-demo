package huangy.hyinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangy on 2019-04-07
 */
public class CheckList {

    static void oldStyleMethod(List dogs) {
        dogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1);

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        oldStyleMethod(pets);
    }
}

class Pet {}

class Dog extends Pet {}

class Cat extends Pet {}