package com.examples.algos;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Metrics m = new Metrics();

        int[] arr1 = {5, 2, 9, 1, 5, 6};
        MergeSort.sort(arr1, m);
        System.out.println("MergeSort: " + Arrays.toString(arr1));

        int[] arr2 = {3, 7, 2, 9, 1, 4};
        QuickSort.sort(arr2);
        System.out.println("QuickSort: " + Arrays.toString(arr2));

        int[] arr3 = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int kth = DeterministicSelect.select(arr3, k , m);
        System.out.println("Select: " + k + "-й наименьший элемент = " + kth);
    }
}
