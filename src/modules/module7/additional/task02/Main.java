package modules.module7.additional.task02;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN),
                new Student("Ольга", 17, Gender.WOMAN)
        );

        students.stream()
                .sorted(Comparator.comparing(Student::getGender))
                .sorted(Comparator.comparingInt(Student::getAge))
                .forEach(System.out::println);
    }
}
