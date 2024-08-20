package Heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConvertArrayToMaxHeap {
  public static void main(String[] args) {
    int arr[] = {1,3,7,23,67,21,78,89, 44};
    int heapSize = arr.length;

    System.out.println("before heapify: "+ Arrays.toString(arr));

    /*
     * We have to apply topDownHeapify opertaion starting "from parent nodes of last but one level till root node" (because last level nodes will not have any child nodes)
     * Here we are running complete heapify operation nearly n/2 times
     * - Time: N * log(N) 
     */
   
    for(int i=heapSize/2; i>=0; i--){
      topDownHeapify(arr, heapSize, i);
    }

    System.out.println("After heapify: "+ Arrays.toString(arr));
  }

  static void topDownHeapify(int[] heap, int heapSize, int curNodeindex){
    int index = curNodeindex;
    while(index < heapSize){
      int leftChildInd = 2*index+1;
      int rightChildInd = 2*index+2;

      if(leftChildInd >= heapSize){ //if both left and right child is empty
        return;
      }

      if(rightChildInd >= heapSize){ // if right child is empty
        if(heap[leftChildInd] > heap[index]){ //if left child has more value than current node
          swap(heap, index, leftChildInd);
        }
        return;
      }

      int maxChildIndex = heap[leftChildInd] > heap[rightChildInd] ? leftChildInd : rightChildInd;
      if(heap[index] > heap[maxChildIndex]){ //if current node val is already greater than both of childs, break the loop
        
      }
      swap(heap, index, maxChildIndex);
      index = maxChildIndex;
    }
  }

  static  void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
