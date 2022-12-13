package modules.module7.chapter2.task12;

public class Solution {
    public static void main(String[] args) {
        java.util.HashMap<String, Long> result = (java.util.HashMap<String, Long>)
                new java.io.BufferedReader(new java.io.InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8))
                        .lines().flatMap(line -> java.util.stream.Stream.of(line.split("[\\p{Punct}\\s]+")))
                        .map(String::toLowerCase)
                        .collect(java.util.stream.Collectors.groupingBy(java.util.function.Function.identity(), java.util.stream.Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(java.util.Map.Entry.comparingByKey())
                        .sorted(java.util.Collections.reverseOrder(java.util.Map.Entry.comparingByValue()))
                        .limit(10)
                        .collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (e1, e2) -> e2, java.util.LinkedHashMap::new));

        result.forEach((key, value) -> System.out.println(key));
    }

}
