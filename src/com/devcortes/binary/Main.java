package com.devcortes.binary;

public class Main {

    public static void main(String[] args) {
        reverseBinary(4);
        System.out.println();
        System.out.println(forwardBinary(4));
    }

    public static void reverseBinary(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n % 2);
        reverseBinary(n / 2);
    }

    public static int forwardBinary(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 2 + 10 * forwardBinary(n / 2));
    }
}
