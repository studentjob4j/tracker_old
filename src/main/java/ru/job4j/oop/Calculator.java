package ru.job4j.oop;

/**
 * @author Shegai Evgenii
 * @since 03.07.2021
 * @version 1.0
 */

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = 0;
        Calculator calculator = new Calculator();
        result = sum(5);
        result += minus(5);
        result += calculator.multiply(5);
        result += calculator.divide(5);
        System.out.println(result);
    }
}
