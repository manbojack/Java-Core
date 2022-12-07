package modules.module6.chapter2.task13;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1, num2);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();
        for (T s1 : set1) {
            if (!set2.contains(s1)) {
                result.add(s1);
            }
        }
        for (T s2 : set2) {
            if (!set1.contains(s2)) {
                result.add(s2);
            }
        }
        return result;
    }

}
