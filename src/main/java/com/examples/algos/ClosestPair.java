package com.examples.algos;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double closestPair(Point[] points) {
        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingDouble(p -> p.x));

        Point[] sortedByY = sortedByX.clone();
        return closestPairRec(sortedByX, sortedByY);
    }

    private static double closestPairRec(Point[] Px, Point[] Py) {
        int n = Px.length;
        if (n <= 3) return bruteForce(Px);

        int mid = n / 2;
        Point midPoint = Px[mid];

        Point[] Qx = Arrays.copyOfRange(Px, 0, mid);
        Point[] Rx = Arrays.copyOfRange(Px, mid, n);

        Point[] Qy = Arrays.stream(Py).filter(p -> p.x <= midPoint.x).toArray(Point[]::new);
        Point[] Ry = Arrays.stream(Py).filter(p -> p.x > midPoint.x).toArray(Point[]::new);

        double d1 = closestPairRec(Qx, Qy);
        double d2 = closestPairRec(Rx, Ry);
        double d = Math.min(d1, d2);

        return Math.min(d, stripClosest(Py, midPoint.x, d));
    }

    private static double stripClosest(Point[] Py, double midX, double d) {
        Point[] strip = Arrays.stream(Py)
                .filter(p -> Math.abs(p.x - midX) < d)
                .toArray(Point[]::new);

        double min = d;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
                min = Math.min(min, distance(strip[i], strip[j]));
            }
        }
        return min;
    }

    private static double bruteForce(Point[] points) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                min = Math.min(min, distance(points[i], points[j]));
            }
        }
        return min;
    }

    private static double distance(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    public static double closest(com.examples.algos.Point[] pts) {
        return 0;
    }

    public static class Point {
        public final double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
