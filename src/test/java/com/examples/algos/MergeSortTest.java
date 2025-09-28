package com.examples.algos;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test void testSortRandom() {
        int[] a = new Random().ints(1000, -1000, 1000).toArray();
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        Metrics m = new Metrics();
        new MergeSort(16).sort(a, m);
        assertArrayEquals(b, a);
    }
}
