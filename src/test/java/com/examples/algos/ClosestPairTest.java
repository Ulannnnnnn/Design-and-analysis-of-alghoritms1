package com.examples.algos;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void testSmall() {
        Point[] pts = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(5, 5),
                new Point(0.1, 0.1)
        };

        double dist = ClosestPair.closest(pts);
        assertTrue(dist > 0);
        assertEquals(Math.sqrt(0.02), dist, 1e-6);
    }
}
