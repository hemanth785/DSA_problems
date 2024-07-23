package Math_and_Bit_manupulation;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/next-permutation/
 * 
 * Approach:
 * - From the right side of array, check any element arr[i] such that, arr[i] > arr[i-1]
 * - save idx = i
 * - Now find the next greater element for element arr[idx], in the right side of array to idx index
 * - Now swap idx element and next greater element of idx
 * - Now Reverse the order of digits/elements from index idx+1 to n (Because this array will be in Descending order, we have to make it ascending)
 */
public class NextGreaterNumber {
  public void nextPermutation(int[] arr) {
		int n = arr.length;
	
		int idx = -1;

		//find the leftmost index to be swapped
		for(int i=n-1; i>0; i--){
			if(arr[i] > arr[i-1]){
				idx = i-1;
				break;
			}
		}

		if(idx != -1){
			//find the next greater element to idx element
			int nextMaxIndex = -1;
			for(int i=idx+1; i<n; i++){
				if(arr[i] > arr[idx]){
					nextMaxIndex = i;
				}
			}

			swap(arr, nextMaxIndex, idx);

			//reverse the remaining array after idx element
			reverseSubArray(arr, idx+1, n-1);
		}	else {
			reverseSubArray(arr, 0, n-1);
		}
	}

	public void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void reverseSubArray(int[] arr, int l, int r){
		int midIndex = l + ((r-l)/2);
		for(int i=l; i<=midIndex; i++){
			int j = r-(i-l);
			swap(arr, i, j);
		}
	}
}
