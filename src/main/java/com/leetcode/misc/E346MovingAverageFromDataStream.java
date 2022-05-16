package com.leetcode.misc;

import java.util.ArrayDeque;
import java.util.Queue;

public class E346MovingAverageFromDataStream {
    private final int size;
    private final Queue<Double> queue;
    private int tempSize = 0;
    private double sum = 0;
    public E346MovingAverageFromDataStream(int size) {
        this.size = size;
        queue = new ArrayDeque<>(size);
        int i = size;
        while (i > 0) {
            queue.offer(0d);
            i--;
        }
    }

    public double next(int val) {
        double first = queue.poll();
        queue.offer((double)val);
        sum += val - first;

        tempSize++;
        if (size > tempSize) {
            return sum / tempSize;
        }

        return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */