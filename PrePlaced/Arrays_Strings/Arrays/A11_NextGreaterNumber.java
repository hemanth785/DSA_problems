package PrePlaced.Arrays_Strings.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/next-permutation/
 * hackerrank link: https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/next-greater-element-with-same-set-of-digits/problem
 * 
 * Approach:
 * - From the right side of array, check any element arr[i] such that, arr[i] > arr[i-1]
 * - save idx = i
 * - Now find the next greater element for element arr[idx], in the right side of array to idx index
 * - Now swap idx element and next greater element of idx
 * - Now Reverse the order of digits/elements from index idx+1 to n (Because this array will be in Descending order, we have to make it ascending)
 */
public class A11_NextGreaterNumber {
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


  // HACKER RANK
  public static int nge_func(int n) {
    // added digits to list, reverse order
    List<Integer> digits = new ArrayList<>();
    while (n > 0) {
      int digit = n % 10;
      digits.add(digit);
      n = n / 10;
    }

    int prevDigit = digits.get(0);
    boolean isFound = false;
    for (int i = 1; i < digits.size(); i++) {
      int curDigit = digits.get(i);

      // check at any digit from least significant position, next least signigicatn is greater.
      if (curDigit < prevDigit) {
        isFound = true;
        digits.set(i, prevDigit);
        digits.set(i - 1, curDigit);

        // to make the adjusted number is smallest possible, push all the higher digits to last of number
        i = i - 1;
        while (i >= 1) {
          if (digits.get(i) > digits.get(i - 1)) {
            int temp = digits.get(i);
            digits.set(i, digits.get(i - 1));
            digits.set(i - 1, temp);
          }
          i--;
        }
        break;
      }
      prevDigit = curDigit;
    }

    if (isFound) {
      int greaterNumber = 0;
      for (int i = digits.size() - 1; i >= 0; i--) {
        if (greaterNumber > Integer.MAX_VALUE / 10 || (greaterNumber == Integer.MAX_VALUE / 10 && digits.get(i) > 7)) {
          return -1;
        }
        greaterNumber = (greaterNumber * 10) + digits.get(i);
      }
      return greaterNumber;
    } else {
      return -1;
    }

  }
}
