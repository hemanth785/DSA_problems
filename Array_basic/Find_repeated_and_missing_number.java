import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an unsorted array of size n. Array elements are in the range of 1 to n. 
 * One number from set {1, 2, …n} is missing and one number occurs twice in the array. 
 * Find these two numbers.
 * 
 * Input: arr[] = {3, 1, 3}
 * Output: Missing = 2, Repeating = 3
 */
public class Find_repeated_and_missing_number {
  public static void main(String[] args) {
    int arr[] = {3, 1, 1, 2, 5}; //for numbers range from 1-n - variation 2
    int n = 5;
    findMissingAndDuplicateNumber(arr, n);

  }

  /*
   * Explanation: Efficient approach
   * Traverse the array. 
   * While traversing, use the '(absolute value of every element - 1)' as an index and 
   *  - make the value at this index negative to mark it visited. 
   * If something is already marked negative then this is the repeating element. 
   * To find the missing, traverse the array again and look for a positive value. the index at which positve value exists, that is the missing number
   */
  public static void findMissingAndDuplicateNumber(int arr[], int n ) {
    int misItem = 0;
    int dupItem = 0;
    
    for(int i=0; i<n; i++){
        int item = Math.abs(arr[i]);
        if(arr[item-1] < 0){
            dupItem = item;
        } else {
            arr[item-1] = -arr[item-1];
        }
    }
    
    for(int i=0; i<n; i++){
        if(arr[i] > 0){
            misItem = i+1;
        }
    }
    
    System.out.println("Missing element: "+ misItem);
    System.out.println("Duplicate element: "+ dupItem);
    
  }
}


