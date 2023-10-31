package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        display(convertIntArrayToIntList(new int[]{1, 2, 3, 4, 5}));
        display(convertIntListToIntArray(Arrays.asList(1, 2, 3, 4, 5)));


        display("Peek");
        List<String> namesS = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> peeks = namesS.stream()
                .peek(name -> System.out.println("Processing: " + name))
                .collect(Collectors.toList());
        display(peeks);

        display("Iterate");
        List<Integer> evenNumbers2 = Stream.iterate(0, n -> n + 2).limit(5).collect(Collectors.toList());
        display(evenNumbers2);

        display("Optionals");
        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstEven = numbers6.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();

        Integer firstEvenValue = firstEven.orElse(-1);
        display(firstEvenValue);

        display("Filtering");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven.and(isPositive))
                .collect(Collectors.toList());
        display(evenNumbers);

        display("Mapping");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        display(nameLengths);

        display("FlatMap");
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        display(flattenedList);

        display("Reduce");
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers3.stream()
                .reduce(0, (acc, n) -> acc + n);
        display(sum);

        display("Map and Reduce (Parallel)");
        List<Integer> numbers7 = Arrays.asList(1, 2, 3, 4, 5);
        int sum3 = numbers7.parallelStream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
        display(sum3);

        display("Sorting");
        List<Integer> unOrderNumbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);
        List<Integer> sortedNumbers = unOrderNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
        display(sortedNumbers);

        display("Limit and Skip");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> firstThreeNumbers = numbers1.stream()
                .limit(3)
                .collect(Collectors.toList());
        display(firstThreeNumbers);
        List<Integer> afterSkippingThree = numbers1.stream()
                .skip(3)
                .collect(Collectors.toList());
        display(afterSkippingThree);

        display("Distinct");
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 3, 6);
        List<Integer> distinctNumbers = numbers2.stream()
                .distinct()
                .collect(Collectors.toList());
        display(distinctNumbers);

        display("Collecting");
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        Set<Integer> evenNumbersSet = numbers4.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());
        display(evenNumbersSet);

        display("Custom Collector");
        List<String> names3 = Arrays.asList("Alice", "Bob", "Charlie");
        String concatenatedNames = names3.stream()
                .collect(Collectors.collectingAndThen(Collectors.joining(", "), result -> "[" + result + "]"));
        display(concatenatedNames);

        display("GroupBy and PartitionBy");
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alex", "Anna");
        Map<Character, List<String>> namesByFirstLetter = names2.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        display(namesByFirstLetter);
        Map<Boolean, List<String>> namesByLength = names2.stream()
                .collect(Collectors.partitioningBy(name -> name.length() > 4));
        display(namesByLength);

        display("Parallel Processing");
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum2 = numbers5.parallelStream()
                .reduce(0, Integer::sum);
        display(sum2);

        display("Parallel Processing with Custom Thread Pools");
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        List<Integer> numbers9 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum5 = customThreadPool.submit(
                () -> numbers9.parallelStream().reduce(0, Integer::sum)
        ).join();
        display(sum5);


        display("AnyMatch, AllMatch, NoneMatch");
        List<Integer> numbers8 = Arrays.asList(1, 2, 3, 4, 5);
        boolean anyEven = numbers8.stream().anyMatch(n -> n % 2 == 0);
        display(anyEven);
        boolean allPositive = numbers8.stream().allMatch(n -> n > 0);
        display(allPositive);
        boolean noneNegative = numbers8.stream().noneMatch(n -> n < 0);
        display(noneNegative);

        display("Concatenating streams");
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> concatenated = Stream.concat(stream1, stream2);
        List<Integer> concatenatedList = concatenated.collect(Collectors.toList());
        display(concatenatedList);

        display("Generating Streams");
        Stream<Double> randomStream = Stream.generate(Math::random);
        List<Double> randomNumbers = randomStream.limit(5).collect(Collectors.toList());
        display(randomNumbers);

        display("Reading From Files");
        try (Stream<String> lines = Files.lines(Paths.get("/Users/geetgobindsingh/Drive/random/java/sample/src/Utils/file.txt"))) {
            display(lines.collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static void display(int message) {
        System.out.println(message);
    }

    public static void display(boolean message) {
        System.out.println(message);
    }

    public static void display(Map<?, ?> map) {
        for (Map.Entry<?, ?> item : map.entrySet()) {
            System.out.print("<" + item.getKey() + ":" + item.getValue() + "> \n");
        }
        System.out.print("\n");
    }

    public static void display(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.print("\n");
    }

    public static void display(Set<?> set) {
        for (Object item : set) {
            System.out.print(item + " ");
        }
        System.out.print("\n");
    }

    public static void display(int[] ar) {
        for (Object item : ar) {
            System.out.print(item + " ");
        }
        System.out.print("\n");
    }


    private static List<Integer> convertIntArrayToIntList(int[] ints) {
        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    private static int[] convertIntListToIntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
