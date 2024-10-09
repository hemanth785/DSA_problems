package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Link: https://workat.tech/problem-solving/practice/merge-k-sorted-arrays
 */
public class A07_MergeKSortedArray {
  /*
   * Approach 1: add all the elements to single array, and then sort the complete array
   * 
   * Time: O(n * k * log(n)), Aux Space: O(1)
   */

  /*
   * Approach 2: Use the min heap (Optimized)
   * - create a class which have fields - array, arrayIndex and value
   * - Create a PQ of the above class
   * - First store all the first elements from the given k arrays in pq
   * - then pop the top element from the pq and store it in res array
   * - after popping, store the next element from the same array (if it exists) from which we popped the element now (This data will be stored in class)
   * - continue this until PQ becomes emtpy
   * 
   * Time: O(k * n * log(k)),  Aux space: O(k).  this is definately better than above 
   */
  static class NodeInfo{
		int arr = 0;
		int index = 0;
		int value = 0;
		
		public NodeInfo(int arr, int index, int value){
			this.arr = arr;
			this.index = index;
			this.value = value;
		}
	}
	
	int[] mergeKArrays(int[][] arr) {
		int k = arr.length;
		
		List<Integer> sortedList = new ArrayList<>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<>((a, b) -> a.value - b.value );
		
		for(int i=0; i<k; i++){
			pq.add(new NodeInfo(i, 0, arr[i][0])); //insert 1st element from each array
		}
		
		//boolean isElementExists = true;
		while(!pq.isEmpty()){
			NodeInfo curNode = pq.poll();
			sortedList.add(curNode.value);
			
			if(curNode.index < arr[curNode.arr].length -1){
				pq.add(new NodeInfo(curNode.arr, curNode.index+1, arr[curNode.arr][curNode.index+1]));
			}
		}
		
		int sortedArr[] = new int[sortedList.size()];
		for(int i=0; i<sortedList.size(); i++){
			sortedArr[i] = sortedList.get(i);
		}
		return sortedArr;
	}
}
