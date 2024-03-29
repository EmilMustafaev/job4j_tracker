package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int multiply(int q) {
        return x * q;
    }

    public int sumAllOperation(int c) {
        return sum(c) + multiply(c) + minus(c) + divide(c);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Calculator.sum(10);
        minus(5);
        calculator.divide(10);
        calculator.multiply(15);
        calculator.sumAllOperation(20);
    }
}