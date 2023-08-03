/*
 * Find the two repeated element in an array.
 * Variation 1: Any range
 * Variation 2: For numbers in range from 1 to n
 */

import java.util.Arrays;

public class Find_two_repeated_element {
  public static void main(String[] args) {
    // int arr[] = {7, 4, 9, 1, 9, 2, 2}; //for any range of numbers - variation 1
    // int[] res = Solution4(arr, arr.length);

    int arr[] = {5, 2, 1, 2, 3, 4, 5}; //for numbers range from 1-n - variation 2
    int n = 5;
    int[] res = Solution6(arr, n);

    System.out.print("Two repeated elements: "+ Arrays.toString(res));
  }

  /*
   * Solution 1: Brute force 
   * use 2 for loops, for each element in the array, find any other element exists.
   * 
   * Time: O(n^2), Space: O(1)
   */


   /*
   * Solution 2: Sorting
   * After sorting the array, check for adjascent elements while looping
   * 
   * Time: O(n log(n)), Space: O(1)
   */

   /*
   * Solution 3: HashMap
   * After sorting the array, check for adjascent elements while looping
   * 
   * Time: O(n), Space: O(n)
   */

   /*
    * Solution 4: Using 2 pointers
    * Alternatively move two pointers until we get the repeated numbers
    *
    * Note: Below soluiton will only work for 'one' missing number
    // */
    // public static int[] Solution4(int arr[], int n){
    //   int l=0, r=n-1;
    //   int res[] = new int[2];
    //   int index = 0;
    //   int nextMove = 0;
    //   while(l<r){
    //     System.out.println(l+" : "+r);
    //     if(arr[l]==arr[r]){
    //       res[index] = arr[l];
    //       l++;
    //       r--;
    //       index++;
    //       if(index >= 2){
    //         return res;
    //       }
    //     } else if(nextMove == 1){
    //       r--;
    //       nextMove = 0;
    //     } else {
    //       l++;
    //       nextMove = 1;
    //     }
    //   }
    //   return res;
    // }
    

    /*
     * ------------------VARIATION 2: Number are from 1 to N ---------------------
     * Here all the above 3 solutions will work (Brute force, Hashmap, Sorting)
     */

    /*
     * Solution 5: Effecient while using formulas, 
     * Using the summation formula and product formula and equating the 2
     * 
     *  Sum(n) + x + y = Sum(arr)
     *  x + y = Sum(arr) - Sum(n)  ------ 1
     * 
     *  
     *  Product(n) * x * y = Product(arr)
     *  x * y = Product(arr)/Product(n)
     * 
     *  
     * 
     * Time: O(n), Space: O(1)
     */

    public static int[] Solution5(int arr[], int n){
      //find the sum of the actual array
      int sumOfArray = 0;
      int prodOfArray = 1;
      for(int item: arr){
        sumOfArray += item;
        prodOfArray *= item;
      }

      //find the sum of AP(summation) for given n
      int summationOfAp = (n * (n+1))/2;

      //find the product of the AP(summation) for given n, 1*2*3*4...n = n!
      // n*(n+1)/2 -- formula for finding factorial of a number

      int productOfAp = 1;
      int temp = n;
      while(temp > 1){
        productOfAp *= temp;
        temp--;
      }

      //Now substitute the values in the formulas
      int xPlusy = sumOfArray - summationOfAp;
      int xPrody = prodOfArray/productOfAp;

      //values for quadratic equation
      int a = 1;
      int b = xPlusy;
      int c = xPrody;

      //compute x(one missing element) value using quadratic equation
      //TODO: need to finish this


      return new int[]{1,1};
    }

    /*
     * Solution 5: Only applies for the number ranging from 1 to n (for any number of repeating numbers)
     * 
     * Time: O(n), Space: O(1)
     */

    public static int[] Solution6(int arr[], int n){

      int res[] = new int[2];
      int index = 0;
      int length = arr.length;
      System.out.println("length: "+length);
      for(int i=0; i<length; i++){
        System.out.println("index: "+i);
        int temp_i = Math.abs(arr[i]);
        if(arr[temp_i] > 0){
          arr[temp_i] = -arr[temp_i];
        } else {
          res[index] = Math.abs(arr[i]);
          index++;

          if(index >= 2){
            return res;
          }
        }
      }

      return res;
    }
}
