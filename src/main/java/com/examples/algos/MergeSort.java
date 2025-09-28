package com.examples.algos;

import java.util.Arrays;

public class MergeSort {

    public MergeSort(int i) {
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        int i = left, j = mid, k = left;

        while (i < mid && j < right) {
            if (arr[i] <= arr[j]) {
                buffer[k++] = arr[i++];
            } else {
                buffer[k++] = arr[j++];
            }
        }

        while (i < mid) buffer[k++] = arr[i++];
        while (j < right) buffer[k++] = arr[j++];

        for (i = left; i < right; i++) arr[i] = buffer[i];
    }

    private static void mergeSort(int[] arr, int[] buffer, int left, int right) {
        if (right - left <= 16) {
            insertionSort(arr, left, right);
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, buffer, left, mid);
        mergeSort(arr, buffer, mid, right);
        merge(arr, buffer, left, mid, right);
    }

    public static void sort(int[] arr, Metrics m) {
        int[] buffer = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, buffer, 0, arr.length);
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
