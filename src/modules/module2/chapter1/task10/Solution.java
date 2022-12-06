package modules.module2.chapter1.task10;

public class Solution {
    public static void main(String[] args) {
        System.out.println(doubleExpression(1.002, 2.003, 3.005));
    }

    /*
        Копировать только метод doubleExpression(), который ниже:
    */
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 1E-4;
    }
}
