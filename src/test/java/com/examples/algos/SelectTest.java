package com.examples.algos;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest {
    @Test void testMedian() {
        int[] a = new Random().ints(201, -1000, 1000).toArray();
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        Metrics m = new Metrics();
        int med = DeterministicSelect.select(a, a.length / 2, m);
        assertEquals(b[b.length / 2], med);
    }
}
