package com.devcortes.sorting.bubble_sort;

public class BubbleSortMain {

    public static void main(String[] args) {
        int[] array = {12, 4, 5, 7, 834, 23, 89, 2, 34, 564, 1, 3, 1, 798, 2};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}
