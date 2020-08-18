package huangy.collections;

import java.util.*;

/**
 * @author huangy on 2019-04-14
 */
public class HYSet {

    private void treeSetDemo() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(1);
        System.out.println(set);
    }

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set);

//        new HYSet().treeSetDemo();

//        Random random=new Random();
//
//        int qianW = 10000000;
//        int yi = 100000000;
//
//        List<Integer> list=new ArrayList<>();
//
//        // 1千万个随机数
//        for(int i=0; i<qianW; i++) {
//            // 范围在 1到1亿之间
//            int randomResult = random.nextInt(yi);
//            list.add(randomResult);
//        }
//
////        System.out.println("产生的随机数有");
////        System.out.println(list);
//
//        // 1亿的位图数组大小
//        BitSet bitSet=new BitSet(yi);
//        for(int i=0; i<qianW; i++)
//        {
//            bitSet.set(list.get(i));
//        }
//
////        System.out.println("0~1亿不在上述随机数中有"+bitSet.size());
//
//        for (int i = 0; i < 100000000; i++)
//        {
//            if(!bitSet.get(i))
//            {
//                System.out.println(i);
//            }
//        }
//

    }


}
