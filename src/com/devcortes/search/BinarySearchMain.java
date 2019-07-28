package com.devcortes.search;

public class BinarySearchMain {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int binarySearch = binarySearch(array, 7);
        squareBruteForce(4.1231231233454657);
        squareBinarySearch(4.1231231233454657);
    }

    private static int binarySearch(int[] sortedArray, int value) {
        int size = sortedArray.length;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int medium = (low + high) / 2;
            if (value == sortedArray[medium]) {
                System.out.println("Value " + value + " is located on index " + medium);
                return 0;
            }
            if (value > sortedArray[medium]) {
                low = medium + 1;
            } else {
                high = medium - 1;
            }
        }
        return 1;
    }

    private static void squareBruteForce(double value) {
        double epsilon = 0.01;
        int numGuesses = 0;
        double ans = 0.0;
        while (Math.abs(Math.pow(ans, 2) - value) >= epsilon) {
            ans +=  0.00001;
            numGuesses += 1;
        }
        if (Math.abs(Math.pow(ans, 2) - value) >= epsilon) {
            System.out.println("Failed .... " + numGuesses);
        } else {
            System.out.println(ans + " close to square root of " + value + " with " + numGuesses + " number of guesses.");
        }
    }


    private static void squareBinarySearch(double value) {
        double epsilon = 0.01;
        double low = 0.0;
        double high = value;
        int guesses = 0;
        double guess = (high + low) / 2;

        while (Math.abs(Math.pow(guess, 2) - value) >= epsilon) {
            if (Math.pow(guess, 2) < value) {
                low = guess;
            } else {
                high = guess;
            }
            guess = (high + low) / 2;
            guesses += 1;
        }
        System.out.println(guess + " is close enough to square root of " + value + ". Guesses: " + guesses);
    }
}
