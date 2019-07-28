package com.devcortes.factorial;

public class FactorialMain {

    public static void main(String[] args) {
        System.out.println(factorialRecursive(8));
        System.out.println(factorialFor(8));
    }

    private static long factorialRecursive(int number) {
        if (number == 1) return 1;
        return number * factorialRecursive(number - 1);
    }

    private static long factorialFor(int number) {
        long result = number;
        for (int i = number - 1; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }
}
