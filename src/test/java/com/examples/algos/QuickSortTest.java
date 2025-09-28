package com.examples.algos;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testSortRandom() {
        int[] a = new Random().ints(1000, -1000, 1000).toArray();
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);

        QuickSort.sort(a);
        assertArrayEquals(b, a);
    }
}
