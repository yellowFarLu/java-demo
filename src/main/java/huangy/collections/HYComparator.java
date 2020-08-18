package huangy.collections;

import huangy.serilize.protobuf.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author huangy on 2020-08-02
 */
public class HYComparator {

    public static void main(String[] args) {
        Comparator comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getAge() > o2.getAge()) {
                    return 1;
                } else if(o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
        }};

        List<Student> list = new ArrayList<>();

        Student one = new Student();
        one.setAge(1);
        list.add(one);

        Student two = new Student();
        two.setAge(2);
        list.add(two);

        list.sort(comparator);
    }

}
