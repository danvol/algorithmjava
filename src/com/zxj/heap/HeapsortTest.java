package com.zxj.heap;

import java.util.Arrays;

/**
 * @author littleboy
 */
public class HeapsortTest {
    public static void main(String[] args) {
        int data[] = {8, 4, 20, 7, 3, 1, 25, 14, 17};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void maxHeap(int[] data, int start, int end) {
        int p = start;
        int s = start * 2 + 1;
        while (s < end) {
            int t = s;
            if (s + 1 < end && data[s + 1] > data[s]) {
                t = s + 1;
            }
            if (data[p] > data[t]) {
                return;
            } else {
                data[p] = data[p] + data[t];
                data[t] = data[p] - data[t];
                data[p] = data[p] - data[t];
                p = t;
                s = p * 2 + 1;
            }

        }
    }

    public static void heapSort(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            maxHeap(data, i, data.length);
        }

        for (int i = data.length - 1; i > 0; i--) {
            data[0] = data[0] + data[i];
            data[i] = data[0] - data[i];
            data[0] = data[0] - data[i];
            maxHeap(data, 0, i);
        }

    }
}