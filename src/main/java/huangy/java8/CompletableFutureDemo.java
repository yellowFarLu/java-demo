package huangy.java8;

import huangy.hyinterface.Person;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author huangy on 2019-11-04
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        demo4();
    }

    public static void demo4() {
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();

        for(List<String> team : playersInWorldCup2016){
            for(String name : team){
                listOfAllPlayers.add(name);
            }
        }

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);


        // Now let's do this in Java 8 using FlatMap
        List<String> flatMapList = playersInWorldCup2016.stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

        System.out.println("List of all Players using Java 8");
        System.out.println(flatMapList);
    }

    public static void demo3() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("one", 1));
        personList.add(new Person("two", 2));

        // 对数据进行分组
        Map<String, List<Person>> map = personList.stream().collect(Collectors.groupingBy(person -> person.getString()));

        System.out.println(map);
    }

    public static void demo2() {
        List<String> batchStocks = new ArrayList<>();

        Map<String, BigDecimal> oneMap = new HashMap<>();
        oneMap.put("oneMapKey", new BigDecimal(1));

        Map<String, BigDecimal> twoMap = new HashMap<>();
        twoMap.put("twoMapKey", new BigDecimal(1));

        Map<String, Map<String, BigDecimal>> warehouseId2AmountMap = new HashMap<>();
        warehouseId2AmountMap.put("one", oneMap);
        warehouseId2AmountMap.put("two", twoMap);

        /*
         * warehouseId2AmountMap集合中每个元素都开启多线程来执行queryByWarehouseIdAndBatchIds，提高性能
         * whenComplete表示多线程执行完以后处理结果
         * CompletableFuture.allOf(cfs).join(); 表示当前线程等待多线程执行完毕
         */
        CompletableFuture[] cfs = warehouseId2AmountMap.entrySet().stream().map(entry ->
                CompletableFuture.supplyAsync(() -> queryByWarehouseIdAndBatchIds(entry.getKey(), new ArrayList<>(entry.getValue().keySet())))
                        .whenComplete((s, e) -> batchStocks.addAll(s))).toArray(CompletableFuture[]::new);

        sleep(5);

        CompletableFuture.allOf(cfs).join();

        System.out.println("输出结果：");

        System.out.println(batchStocks);
    }

    public static List<String> queryByWarehouseIdAndBatchIds(String wareHouseId, List<String> batchIds) {
        List<String> strArr = new ArrayList<>();
        strArr.add("queryByWarehouseIdAndBatchIds获取的结果:" + wareHouseId + " and " + batchIds);
        return strArr;
    }

    public static void demo1() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "f1";
        });

        CompletableFuture<String> f2 = f1.thenApply(r -> {
            // 输出上一个线程的结果
            System.out.println(r);

            sleep(1);
            return "f2";
        });

        CompletableFuture<String> f3 = f2.thenApply(r -> {
            System.out.println(r);
            sleep(1);
            return "f3";
        });

        CompletableFuture<String> f4 = f3.thenApply(r -> {
            System.out.println(r);
            sleep(1);
            return "f4";
        });

        CompletableFuture<String> f5 = f4.thenApply(r -> {
            System.out.println(r);
            sleep(1);
            return "f5";
        });

        CompletableFuture<String> f6 = f5.thenApply(r -> {
            System.out.println(r);
            sleep(1);
            return "f6";
        });

        System.out.println("这里是主线程");

        sleep(1000);

    }

    private static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
