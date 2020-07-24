package com.company.GFG.Heap;

import java.util.Arrays;

public class MinHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(3);
        int data[] = {7, 10, 4, 3, 20, 11};
        for (int i : data) {
            minHeap.insertKey(i);
        }
        minHeap.print();
        System.out.println(minHeap.extractMin());
        minHeap.print();
        System.out.println(minHeap.extractMin());
        minHeap.print();
        System.out.println();
    }

    int[] harr;
    int capacity, heap_size;

    public MinHeap(int capacity) {
        harr = new int[capacity + 1];
        this.capacity = capacity;
        heap_size = 0;
    }

    public int leftChild(int i) {
        return (2 * i) + 1;
    }

    public void print() {
        for (int i = 0; i < heap_size; i++) {
            System.out.print(harr[i] + " ");
        }
        System.out.println();
    }

    public int rightChild(int i) {
        return (2 * i) + 2;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }


    // You need to write code for below three functions
    int extractMin() {
        int result = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);
        return result;
    }

    void insertKey(int val) {
        harr[heap_size++] = val;
        int i = heap_size - 1;
        while (i != 0 && harr[getParent(i)] > harr[i]) {
            swap(harr, i, getParent(i));
            i = getParent(i);
        }

    }

    void deleteKey(int i) {
        if (heap_size == 0) return;
        if (i > heap_size) return;
        decrease(i, Integer.MIN_VALUE);
        extractMin();
    }

    private void decrease(int i, int minValue) {
        harr[i] = minValue;
        while (i != 0 && harr[getParent(i)] > harr[i]) {
            swap(harr, i, getParent(i));
        }
    }

    void MinHeapify(int i) {
        if (i < 0) return;
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if (left < heap_size && harr[left] < harr[i]) {
            smallest = left;
        }
        if (right < heap_size && harr[right] < harr[i]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(harr, smallest, i);
            MinHeapify(smallest);
        }
    }

    private void swap(int[] harr, int left, int i) {
        int temp = harr[left];
        harr[left] = harr[i];
        harr[i] = temp;
    }
}
