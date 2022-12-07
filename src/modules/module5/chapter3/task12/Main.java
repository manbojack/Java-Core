package modules.module5.chapter3.task12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double result = 0.0;

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                result += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        System.out.printf("%.6f", result);
    }
}
