package Heap.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class A01_ {
	List<Integer> heap;
  int heapSize = 0;

  A01_() {
    heap = new ArrayList<>();
  }

  // Complete this class
  boolean isEmpty() {
    return heapSize == 0;
  }

  int getSize() {
    return heapSize;
  }

  int getMax() {
    if (heapSize == 0) {
      return -1;
    }
    return heap.get(0);
  }

  void insert(int element) {
    heap.add(heapSize++, element);
    bottomUpHeapify(heapSize - 1);
  }

  int removeMax() {
    if (heapSize == 0) {
      return -1;
    }
    int topItem = heap.get(0);
    heap.add(0, heap.get(heapSize - 1));
    heapSize--;
    topDownHeapify(0);
    return topItem;
  }

  // helper functions
  private void bottomUpHeapify(int i) {
    int parent = (i - 1) / 2;
    // check if it is a valid parent
    if (parent >= 0) {
      if (heap.get(parent) < heap.get(i)) {
        swap(i, parent);
        bottomUpHeapify(parent);
      }
    }
  }

  private void topDownHeapify(int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;
    if (left < heapSize && heap.get(left) > heap.get(largest)) {
      largest = left;
    }
    if (right < heapSize && heap.get(right) > heap.get(largest)) {
      largest = right;
    }
    if (largest != i) {
      swap(i, largest);
      topDownHeapify(largest);
    }

  }

  private void swap(int i, int j) {
    int temp = heap.get(i);
    heap.add(i, heap.get(j));
    heap.add(j, temp);
  }
  
}
