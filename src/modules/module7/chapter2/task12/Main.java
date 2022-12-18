package modules.module7.chapter2.task12;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[\\p{Punct}\\s]+");
        Map<String, Integer> words = new TreeMap<>();
        scanner.forEachRemaining(s -> words.merge(s.toLowerCase(), 1, Integer::sum));
        words.entrySet().stream()
                .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

}
