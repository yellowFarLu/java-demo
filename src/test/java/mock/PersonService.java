package mock;

import org.springframework.stereotype.Service;

/**
 * @author huangy on 2020-02-23
 */
@Service
public class PersonService {

    public String showName(String name){
        System.out.println("person show name : " + name);
        return name;
    }

    public int showAge(int age) {
        System.out.println("person show age : " + age);
        return age;
    }

    public Person getDefaultPerson(){
        return new Person("miao", 3, null);
    }
}
