package cn.yizhangwo.test;

import cn.yizhangwo.pojo.Employee;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    /**
     * 基本对象流
     */
    @Test
    public void fun19() {
        String s = "^\\d{15}|\\d{18}$";
        Pattern compile = Pattern.compile(s);
        Matcher matcher = compile.matcher("510131199405051019");
        int i = matcher.groupCount();
        int start = matcher.start();
        int end = matcher.end();
        System.out.println(matcher);
    }
    /**
     * 基本对象流
     */
    @Test
    public void fun18() {
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        int asInt = intStream.reduce((x, y) -> x + y).getAsInt();
        System.out.println(asInt);
        //
        int sum = intStream.sum();
        OptionalDouble average = intStream.average();
    }
    /**
     * 约简 reduce
     */
    @Test
    public void fun17() {
        Integer[] arr={1,2,3,4};
        Integer integer = Stream.of(arr).reduce((x, y) -> x + y).get();
        System.out.println(integer);
         //Stream.of(arr).;
    }
        /**
         * 群组和分区 fun016 fun15
         */
    @Test
    public void fun16() {
        String[] arr = {"abc", "ab", "ab", "abcd", "wangsiqing", "xiyuouJI"};
        Map<Boolean, List<String>> collect = Arrays.stream(arr).collect(Collectors.groupingBy(s -> s.length() > 2));
        List<String> list = collect.get(true);
        System.out.println(list);
        Map<Boolean, Long> collect1 = Arrays.stream(arr).collect(Collectors.groupingBy(s -> s.length() > 2, Collectors.counting()));
        System.out.println(collect1);
        System.out.println("-------------------------------------");
        Map<Boolean, Integer> collect2 = Arrays.stream(arr).collect(Collectors.groupingBy(s -> s.length() > 2, Collectors.summingInt(String::length)));
        System.out.println(collect2);
        System.out.println("-------------------------------------");
        Map<Boolean, Optional<String>> collect3 = Arrays.stream(arr).collect(Collectors.groupingBy(s -> s.length() > 2, Collectors.maxBy((s1, s12) -> s1.length() - s12.length())));
        //
        Map<Boolean, Integer> collect4 = Arrays.stream(arr).collect(Collectors.groupingBy(s -> s.length() > 2, Collectors.collectingAndThen(Collectors.toList(), List::size)));
        System.out.println(collect4);
        System.out.println("---------------------------------------------");
        Map<Boolean, List<String>> collect5 = Arrays.stream(arr).collect(Collectors.groupingBy(s -> s.length() > 2, Collectors.mapping(String::new, Collectors.toList())));
        System.out.println(collect5);
    }

    @Test
    public void fun15() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        System.out.println(Arrays.toString(availableLocales));
        System.out.println("--------------------------------------------------");
        Map<String, List<Locale>> collect = Stream.of(availableLocales).collect(Collectors.groupingBy(Locale::getCountry));
        List<Locale> ch = collect.get("CH");
        System.out.println(ch);
        Map<Boolean, List<Locale>> ch1 = Stream.of(availableLocales).collect(Collectors.partitioningBy(locale -> locale.getCountry().equals("CH")));
        System.out.println(ch1);
        List<Locale> locales = ch1.get(true);
        System.out.println(locales);
    }

    /**
     * 收集到映射列表中
     */
    @Test
    public void fun14() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("测试一号");
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("测试er号");
        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setName("测试三号");
        Employee employee4 = new Employee();
        employee4.setId(3);
        employee4.setName("测试四号");
        Map<Integer, Employee> map = Stream.of(employee1, employee2, employee3, employee4).collect(Collectors.toMap(Employee::getId, Function.identity(), (existValue, newVlaue) -> existValue));
        System.out.println(map);
        // Function<Object, Object> identity = Function.identity();
    }

    /**
     * 收集结果
     */
    @Test
    public void fun13() {
        Optional<String> s = Optional.ofNullable("8963aF");
        String[] arr = {"abc", "ab", "ab", "abcd", "wangsiqing", "xiyuouJI"};
        String[] strings = Arrays.stream(arr).map(String::toString).toArray(String[]::new);
        Arrays.stream(strings).collect(Collectors.toList());
        IntSummaryStatistics collect = Arrays.stream(strings).collect(Collectors.summarizingInt(String::length));
        int min = collect.getMin();
        long sum = collect.getSum();
        long count = collect.getCount();
        double average = collect.getAverage();
    }

    @Test
    public void fun12() {
        String[] arr = {"abc", "ab", "ab", "abcd", "wangsiqing", "xiyuouJI"};
        List<String> collect = Arrays.stream(arr).filter(s -> s.length() > 2).map(s -> s.split("")).flatMap(strings -> Arrays.stream(strings)).collect(Collectors.toList());
        System.out.println(collect);
        Optional<String> abc = Optional.of("abc");
    }

    @Test
    public void fun11() {
        String[] arr = {"abc", "ab", "ab", "abcd", "wangsiqing", "xiyuouJI"};
        Arrays.stream(arr).max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
        String s = Arrays.stream(arr).max(Comparator.comparingInt(String::length)).get();
        System.out.println(s);
    }

    @Test
    public void fun10() {
        String[] arr = {"abc", "ab", "ab", "abcd", "wangsiqing", "xiyuouJI"};
        String[] arr2 = {"abc", "ab", "ab", "abcd", "wangsiqing", "xiyuouJI"};
        Optional<String> first = Arrays.stream(arr).findAny();
        String s1 = Arrays.stream(arr).findAny().orElse("");
        System.out.println(s1);
        System.out.println("---------------------------------------");
        System.out.println(first);
        System.out.println("---------------------------------------");
        boolean qing = Arrays.stream(arr).anyMatch(s -> s.contains("qing"));
        System.out.println(qing);
        System.out.println("---------------------------------------");
        boolean qing1 = Arrays.stream(arr).noneMatch(s -> s.contains("qing"));
        System.out.println(qing1);
        System.out.println("---------------------------------------");
        boolean qing2 = Arrays.stream(arr).allMatch(s -> s.contains("qing"));
        System.out.println(qing2);
    }

    @Test
    public void fun09() {
        //String[] objects = (String[]) Stream.of("abc","ab", "abcd", "wangsiqing", "xiyuouJI").toArray();
        String[] arr = {"abc", "ab", "ab", "abcd", "wangsiqing", "xiyuouJI"};
        Arrays.stream(arr).sorted().distinct().forEach(System.out::println);
        System.out.println("--------------------------");
        Arrays.stream(arr).sorted(Comparator.comparingInt(String::length)).distinct().forEach(System.out::println);
        Optional<String> first1 = Arrays.stream(arr).sorted(Comparator.comparingInt(String::length)).distinct().findFirst();
        System.out.println("---------------取出最大值、最小值---------------");
        String s = Arrays.stream(arr).max((first, second) -> first.length() - second.length()).toString();
        System.out.println("max: " + s);
    }

    @Test
    public void fun08() {
        Stream<String> stream = Stream.of("abc", "abcd", "wangsiqing", "xiyuouJI");
        System.out.println("---------------------------------");
        Stream.of("abc", "ab", "abcd", "wangsiqing", "xiyuouJI").takeWhile(s -> s.length() > 2).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------------------------");
        Stream.of("abc", "abcd", "wangsiqing", "xiyuouJI").filter(s -> s.length() > 3).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------------------------");
        Stream.of("abc", "ab", "abcd", "wangsiqing", "xiyuouJI").dropWhile(s -> s.length() > 2).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void fun07() {
        List<Integer> collect = Stream.iterate(0, n -> n + 1).limit(10).skip(1).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void fun06() {
        String[] words = new String[]{"Hello", "World"};
        List<String> collect = Stream.of(words).map(str -> str.split("")).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void fun05() {
        String[] words = new String[]{"Hello", "World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        a.forEach(arr -> System.out.println(Arrays.toString(arr)));

    }

    @Test
    public void fun04() {
        Stream<String> stream = Stream.of("abc", "abcd", "wangsiqing", "xiyuouJI");
        stream.map(str -> str.toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void fun03() {
        Stream<Object> empty = Stream.empty();
        Stream<String> generate = Stream.generate(() -> "你好");
        List<String> collect = generate.limit(10).collect(Collectors.toList());
        System.out.println(collect);
        List<BigInteger> collect1 = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10).collect(Collectors.toList());
        System.out.println(collect1);
    }

    @Test
    public void fun01() throws IOException {
        StringBuffer buffer = new StringBuffer();
        byte[] bytes = Files.readAllBytes(Paths.get("D:\\常用配置.txt"));
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
        List<String> split = List.of(s.split("\\PL+"));
        System.out.println(split);
    }

    @Test
    public void fun02() throws IOException {
        char c = 126;
        System.out.println(c);
    }
}
