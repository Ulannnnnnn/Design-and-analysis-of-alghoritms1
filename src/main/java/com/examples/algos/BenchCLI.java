package com.examples.algos;

import java.util.Arrays;
import java.util.Random;

public class BenchCLI {
    public static void main(String[] args) {
        Metrics m = new Metrics();
        int[] arr = {5, 2, 9, 1, 5, 6};

        // MergeSort
        MergeSort.sort(arr, m);
        System.out.println("MergeSort: " + Arrays.toString(arr));

        // QuickSort
        int[] arr2 = {3, 7, 2, 9, 4, 1};
        QuickSort.sort(arr2);
        System.out.println("QuickSort: " + Arrays.toString(arr2));

        // DeterministicSelect (медиана)
        int n = arr2.length;
        int k = n / 2;
        Metrics metrics = new Metrics();
        int val = DeterministicSelect.select(Arrays.copyOf(arr2, arr2.length), k, metrics);
        System.out.println("Select median = " + val
                + ", comparisons = " + metrics.comparisons
                + ", swaps = " + metrics.swaps);

        // Closest Pair
        Point[] pts = new Point[1000];
        Random rnd = new Random();
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Point(rnd.nextDouble(), rnd.nextDouble());
        }
        double d = ClosestPair.closest(pts);
        System.out.println("Closest pair distance = " + d);
    }
}
