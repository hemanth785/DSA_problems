package Heap;
import java.util.Arrays;

public class A01_MaxHeapImplementation {

/*
 * Note: HERE WE NEED TO THINK INTERMS OF ARRAY, BECAUSE THAT WILL BE EASIER
 */

  /*
   * Heap: 
   * 1. Heap allows following operations
   *    a. Insert new element
   *    b. Remove top element (other than top heap is not ideal for deleting other elements)
   *    c. Peek (returns top element- it'll be a max value for maxHeap)
   * 
   * 2. Heap is binary tree data structure which will be having complete binary tree
   *     (only last level nodes can be empty and we should start filling elements from left side of tree)
   * 3. In Max heap, data will be stored in way that parent node value should be greater than both of its child nodes (reverse for minHeap)
   * 4. If we have to insert the new node(value), we have to insert it at the bottom left empty place
   *    - Then we to perform the "Bottom Up" heapify operation, to move this element to correct position (we need to compare with parent node:  parent(i) = (i-1)/2 )
   * 5. Poll/delete operation deletes item from top(root) of heap, then fill this element with last item in tree(bottom right in tree or last item in array)
   *    - Then perform "Top Down" heapify operation to move this new root element to correct position (we need to compare with both child nodes: childs(p) = 2*p+1 (left child) and 2*p+2 (right child))
   * 
   * Note: Both topDown and bottomUp heapify will have O( Log(n)), i.e the height of tree.
   *      because in worst case item needs to me moved from top to the bottom of tree(or bottom to top) 
   * 
   * Proper explanation: https://www.youtube.com/watch?v=HqPJF2L5h9U 
   */

  public static class MaxHeap {
    int[] heap;
    int heapSize;

    MaxHeap(int MAX_SIZE){
      heap = new int[MAX_SIZE];
      heapSize = 0;
    }

    public void insert(int val){
      if(heapSize >= heap.length){
        System.out.println("Heap is full");
        return;
      }
      heap[heapSize++] = val;
      bottomUpHeapify();

      System.out.println(Arrays.toString(heap));
    }

    public int poll(){ //this will remove top element
      if(heapSize == 0){
        return -1;
      }

      int pollItem = heap[0]; 
      heap[0] = heap[heapSize-1]; //when we delete top/root item, first move last element to root
      heap[heapSize-1] = 0;
      heapSize--;

      topDownHeapify();
      System.out.println("del: "+Arrays.toString(heap) +" - "+ heapSize);

      return pollItem;
    }

    public int peek(){
      return heap[0];
    }

    private void bottomUpHeapify(){
      int index = heapSize-1;
      while(index > 0){
        int parentIndex = index == 1 ? 0 : (index-1)/2;

        if(heap[parentIndex] >= heap[index]){ //if parent is already greater, then stop here
          return;
        }

        //otherwise swap current node val with parent node val
        swap(heap, index, parentIndex);
        index = parentIndex;
      }
    }

    /*
     * Approach: 
     * - Start from root node, get its left and right child nodes using formula
     * - Check if leftNode exists (If left node is null, then right node will also be null - So break here)
     * - Check if rightNode exists (If right node is null, then check if leftNode is greater than curNode, if yes then swap and break here)
     *    - if right node is null means, there is no child nodes exists further
     * - if Both child nodes exists, 
     *   - get the child with max value
     *   - compare max value child with currentNode
     *   - if it is greater, swap with curNode and update the index to childNode index and continue loop
     *   - if child node value is lesser, we can break the loop
     */
    private void topDownHeapify(){
      int index = 0;
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
          return;
        }
        
        swap(heap, index, maxChildIndex);
        index = maxChildIndex;
      }
    }

    private void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }


  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(10);
    maxHeap.insert(10);
    maxHeap.insert(20);
    maxHeap.insert(30);
    maxHeap.insert(25);
    maxHeap.insert(12);
    maxHeap.insert(60);

    maxHeap.poll();
    System.out.println(maxHeap.peek());
    maxHeap.poll();
    System.out.println(maxHeap.peek());

    maxHeap.insert(55);
    maxHeap.insert(8);

    maxHeap.poll();
  }
}
