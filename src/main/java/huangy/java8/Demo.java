package huangy.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangy on 2019-06-06
 */
public class Demo {

    public static void main(String[] args) {
        List<OuterTenantInfo> outerTenantInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OuterTenantInfo outerTenantInfo = new OuterTenantInfo();
            outerTenantInfo.setOuterUid(i);
            outerTenantInfos.add(outerTenantInfo);
        }

        List<Long> list = outerTenantInfos.stream().map(OuterTenantInfo::getOuterUid).map(Integer::longValue).collect(Collectors.toList());
        System.out.println(list);
    }

}
