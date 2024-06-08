package Heap;
import java.util.Arrays;


/*
 * Problem: 
 * Given the binary tree in array representation
 * - Implement function to convert the binary tree array to minHeap in array format
 * - Implement function, when new element is provided, this should be stored in minHeap fashion
 * - Implement function, when an element is deleted, rearrangement of data should happen in minHeap fashion
 */
public class MinHeapImplementation {
  public static class MinHeap {
    int[] heap;
    int heapSize;

    MinHeap(int MAX_SIZE){
      heap = new int[MAX_SIZE];
      heapSize = 0;
    }

    public void insert(int val){
      heap[heapSize++] = val;
      bottomUpHeapify(heap, heapSize, heapSize-1);
    }

    public int[] buildMaxHeap(int[] arr, int n){
      for(int i=(n-1)/2; i>=0; i--){ //we are starting from almost middle of array because, this is where we can find (last-1) level nodes in array representation of tree
        topDownHeapify(arr, n, i);
      }
      return arr;
    }

    public void delete(int index){
      if(heapSize == 0 || index >= heapSize){
        return;
      }
      heap[index] = heap[--heapSize];
      topDownHeapify(heap, heapSize, index);
    }

    public int extractMin(){
      if(heapSize == 0){
        return -1;
      }
      int topMin = heap[0];
      delete(0);
      return topMin;
    }

    private void topDownHeapify(int[] arr, int n, int i){
      int left = 2*i+1;  // for ith node, left node will be at (2*i+1)th place in array
      int right = 2*i+2;  // for ith node, left node will be at (2*i+2)th place in array
      int smallest = i;
      if(left < n && arr[left] < arr[smallest]){
        smallest = left;
      }
      if(right < n && arr[right] < arr[smallest]){
        smallest = right;
      }
      if(smallest != i){  //this condition is important
        swap(arr, i, smallest);
        topDownHeapify(arr, n, smallest);
      }
    }

    private void bottomUpHeapify(int[] arr, int n, int i){
      int parent = (i-1)/2;
      //check if it is a valid parent
      if(parent >= 0){
        if(arr[parent] > arr[i]){
          swap(arr, i, parent);
          bottomUpHeapify(arr, n, parent);
        }
      }
    }

    private void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }
  
  public static void main(String[] args) {
    int arr[] = new int[]{20,10,11,2,4,3,1};
    MinHeap maxHeap = new MinHeap(100);

    //create heap using topDownHeapify
    // int maxHeapData[] = maxHeap.buildMaxHeap(arr, arr.length);
    // System.out.println("Min heap:");
    // System.out.println(Arrays.toString(maxHeapData));

    //create heap using bottomUpHeapify
    for(int item: arr){
      maxHeap.insert(item);
    }
    for(int i=0; i<maxHeap.heapSize; i++){
      System.out.print(maxHeap.heap[i]+" ");
    }

    /* Note: we might get diff result in BottomUpHeapify and TopDownHeapify */
  }
}
