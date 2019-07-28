package com.devcortes.string_reverse;

public class StringReverseMain {

    public static void main(String[] args) {
        reverseWithHelpOfCharArray();
        reverseWithHelpOfStringBuilder();
    }

    private static void reverseWithHelpOfStringBuilder() {
        String hello = "Hello, world second time!!!!";
        StringBuilder stringBuilder = new StringBuilder(hello);
        System.out.println(hello);
        System.out.println(stringBuilder.reverse());
    }

    private static void reverseWithHelpOfCharArray() {
        String hello = "Hello, world!!!!";
        char[] chars = hello.toCharArray();
        int length = chars.length;
        char tmp;
        int i, j;
        for (i = 0, j = length - 1; i < j; i++, j--) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        System.out.println(hello);

        hello = new String(chars);

        System.out.println(hello);
    }
}
