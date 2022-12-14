package modules.module7.chapter2.task12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Long> result = new java.io.BufferedReader(
                new java.io.InputStreamReader(
                        System.in, java.nio.charset.StandardCharsets.UTF_8)
        )
                .lines().flatMap(line -> Stream.of(line.split("[\\p{Punct}\\s]+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new
                        )
                );

        result.forEach((key, value) -> System.out.println(key));
    }

}
