package huangy.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangy on 2019-06-21
 */
public class listToMapDemo {

    public static Map<Integer, String> getMapByList(List<OuterTenantInfo> accounts) {
        return accounts.stream().collect(Collectors.toMap(OuterTenantInfo::getOuterUid, OuterTenantInfo::getName));
    }

    public static void main(String[] args) {
        OuterTenantInfo one = new OuterTenantInfo();
        one.setOuterUid(1);
        one.setName("one");

        OuterTenantInfo two = new OuterTenantInfo();
        two.setOuterUid(2);
        two.setName("two");

        OuterTenantInfo three = new OuterTenantInfo();
        three.setOuterUid(3);
        three.setName("three");

        List<OuterTenantInfo> accounts = new ArrayList<>();
        accounts.add(one);
        accounts.add(two);
        accounts.add(three);

        System.out.println(getMapByList(accounts));
    }

}
