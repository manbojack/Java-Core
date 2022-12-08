package modules.module6.chapter2.task15;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        try {
            while (scanner.hasNextInt()) {
                scanner.nextInt();
                deque.addFirst(scanner.nextInt());
            }
        } catch (NoSuchElementException ignored) {

        }
        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
    }
}