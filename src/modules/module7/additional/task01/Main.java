package modules.module7.additional.task01;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Допустим, у нас есть коллекция состоящая из строк:
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");

        // Посчитаем, сколько раз объект «High» встречается в коллекции:
        System.out.println(collection.stream().filter("High"::equals).count());

        // А теперь посмотрим, какой элемент в коллекции находится на первом месте.
        // Если мы получили пустую коллекцию, то пусть возвращается 0:
        System.out.println(collection.stream().findFirst().orElse("0"));

        // Допустим, нам нужно вернуть последний элемент:
        System.out.println(collection.stream().skip(collection.size() - 1).findFirst().orElse("0"));


        List<String> collection1 = Arrays.asList("f3", "f10", "f15", "f2", "f4", "f4");
        System.out.println(collection1.stream().min(String::compareTo).get());
        System.out.println(collection1.stream().max(String::compareTo).get());


    }
}
