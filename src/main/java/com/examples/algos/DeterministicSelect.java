package com.examples.algos;

public class DeterministicSelect {

    public static int select(int[] arr, int k, Metrics m) {
        return select(arr, 0, arr.length - 1, k, m);
    }

    private static int select(int[] arr, int left, int right, int k, Metrics m) {
        if (left == right) {
            return arr[left];
        }

        // считаем количество сравнений
        m.comparisons++;

        int pivot = medianOfMedians(arr, left, right, m);
        int pivotIndex = partition(arr, left, right, pivot, m);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return select(arr, left, pivotIndex - 1, k, m);
        } else {
            return select(arr, pivotIndex + 1, right, k, m);
        }
    }

    private static int medianOfMedians(int[] arr, int left, int right, Metrics m) {
        // простая версия: берём середину
        return arr[(left + right) / 2];
    }

    private static int partition(int[] arr, int left, int right, int pivot, Metrics m) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
                m.comparisons++;
            }
            while (arr[right] > pivot) {
                right--;
                m.comparisons++;
            }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
                m.swaps++;
            }
        }
        return left - 1;
    }
}
