

/*
 * 
 * Given an array of distinct elements, which is formed from some places rotation of a sorted array, 
 * find if a given element is present in the array or not.
 * 
 * Note: Try to do it in O(logn) runtime complexity
 * https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/search-in-rotated-sorted-array-5
 */
public class A02_SearchInSortedRotated {
  public static void main(String args[]){
    int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    int res = searchInRotatedArray(arr, 1);
    System.out.println("Target found at index: "+res);
  }

  /*
   * Solution 1: Find the rotation pivot using binary search (easy to understand code - Use this)
   * 
   * Step 1: Find the position at which the array is rotated (Bitonic point) - Using Binary search
   * Step 2: Identify whether target element lies in left search space or right search space
   *       for left:  (target >= l && target <= pivot)
   *       for right: (target >= pivot && target <= r)
   * Step 3: run binary search over the left or right search space, based on step 2
   * 
   * Time: log(n) + log(n) ==> log(n)
   */

   int getElementIndex(int[] arr, int target) {
		int n = arr.length;
	    
		//find bitonicIndex (Log n)
		int bitonicIndex = findBitonicPoint(arr, n);
		int l = 0;
		int r = n-1;
    //if array is roated
		if(bitonicIndex != -1){
			if(target >= arr[0] && target <= arr[bitonicIndex]){
				//search in left sub array
				r = bitonicIndex;
			} else {
				//search in right subarray
				l = bitonicIndex+1;
			}
		}
		
		return binarySearch(arr, l, r, target);
	}
	
	int binarySearch(int[] arr, int l, int r, int target){
		while(l<=r){
			int mid = l + (r-l)/2;
			if(arr[mid] == target){
				return mid;
			} else if(target < arr[mid]){
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
	
	int findBitonicPoint(int[] arr, int n){
		//find the bitonic point by binary search
		int l=0;
		int r=n-1;
		
		while(l<=r){
			int mid = l + (r-l)/2;
			//if prev element is greater than cur element, prev element is bitonic point
			if(mid != 0 && arr[mid-1] > arr[mid]){
				return mid-1;
			} 
			//if bitonic point is on left half of array, then 0th element will be greater than mid element in sorted array
			else if(arr[0] > arr[mid]){
				r = mid-1;
			} else {
				l = mid+1;
			}
		}
		
		return -1;
	}


   /*
    * Solution 2: Optimized (Apply direct binary search) - This is also easier.
    * 
    * Step 0: find mid element, with l=0, r=n-1
    * Step 1: if (l <= mid) means left is sorted, 
    *             - if target lies in left space (target >= l && target < mid), update r = mid-1 (search in left space)
    *             - else update l = mid+1 (search in right space)
    * Step 2: if (r >= mid) means right is sorted, 
    *             - if target lies in right space (target <= r && target > mid), update l = mid+1 (search in right space)
    *             - else update r = mid-1 (search in left space)
    */
  public static int searchInRotatedArray(int[] arr, int target){
    int l = 0;
    int r = arr.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[l] <= arr[mid]) { // if left half is sorted array (Not rotated)
        if (target >= arr[l] && target < arr[mid]) { // if target in left sorted space
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else { // if right half is sorted array (Not rotated)
        if (target <= arr[r] && target > arr[mid]) { // if target in left sorted space
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return -1;
  }
}
