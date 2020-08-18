package huangy.collections;

import huangy.hyinterface.Person;

import java.util.*;

/**
 * @author huangy on 2019-04-14
 */
public class HYCollections {

    void nCopy() {
        List<Person> personList = Collections.nCopies(5, new Person("two"));
//        System.out.println(personList);

        Person[] perArr1 = new Person[personList.size()];
        Person[] perArr2 = personList.toArray(perArr1);
        for (int i = 0; i < perArr2.length; i++) {
            System.out.println(perArr2[i]);
        }
    }

    public static void main(String args[]) {

        ArrayList<String> list = new ArrayList<String>();

        list.add("TP");
        list.add("PROVIDES");
        list.add("QUALITY");
        list.add("TUTORIALS");
        System.out.println(list);

        List newList = list;
        newList.add(1);
        System.out.println(newList);

        Collection checkList = Collections.checkedCollection(list, String.class);
        checkList.add(1);
    }


}
