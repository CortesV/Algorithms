package com.devcortes.fibonacci;

public class FibonacciMain {

    public static void main(String[] args) {
        int number = 9;
        System.out.println(fibonacciRecursive(number));
        System.out.println(fibonacciFor(number));
    }

    private static long fibonacciRecursive(int number) {
        if (number <= 1) return number;
        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }

    private static long fibonacciFor(int number) {
        int[] numbers = new int[number + 2];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i <= number; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers[number];
    }
}
