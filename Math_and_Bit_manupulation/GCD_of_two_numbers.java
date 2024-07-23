/*
 * GCD of two numbers a,b ==> a%x==0 && b%x==0, where x is the GCD 
 */
package Math_and_Bit_manupulation;

public class GCD_of_two_numbers {
  public static void main(String[] args) {
    int a = 24;
    int b = 48;
    int res = gcd3(a, b);

    System.out.print("GCD:  "+ res);
  }

  /*
   * Solution 1: 
   * - Find the smallest number
   * - Loop through smallest number until 0, 
   * - Check each number if it devides both a and b
   * 
   * Time: O(min(a,b))
   */
  public static int gcd1(int a, int b){
    int min = Math.min(a,b);
    while(min > 0){
      if(a%min == 0 && b%min == 0){
        break;
      }
      min--;
    }

    return min;
  }

  /*
   * Solution 2: Slightly efficient compare to Soluton 1
   * - We know that, GCD of 2 numbers lies in the range of 1,2,.... Sqrt(min(a,b))
   * - So we can reduce the number of times loop runs
   * 
   * Time: O(sqrt(min(a,b)))
   * 
   * 
   * Note: SAME APROACH CAN BE USED TO FIND IF NUMBER IS PRIME OR NOT
   */
  public static int gcd2(int a, int b){
    int min = Math.min(a,b);
    min = (int)Math.sqrt(min);
    while(min > 0){
      if(a%min == 0 && b%min == 0){
        break;
      }
      min--;
    }

    return min;
  }

  /*
   * Solution 3: Efficient way to find GCD (Ecludian algorithm)
   * - Find the min and max element among the a and b
   * - find the modulo of min and max ==> max % min = remainder
   * - if remainder == 0, then min is the GCD
   * - else make max = min, min=remainder
   * - continue loop until we find the remainder == 0
   * - once remainder is =0, then min will be the answer
   */

  public static int gcd3(int a, int b){
    int remainder = Integer.MAX_VALUE;
    int max=0, min=0;
    if(a > b){
      max = a;
      min = b;
    } else {
      max = b;
      min = a;
    }

    remainder = max % min;
    while(remainder > 0){
      max = min;
      min = remainder;

      remainder = max % min;
    }

    return min;
  }

  public static int gcdOfArray(int[] arr){
    int prevGCD = gcd3(arr[0], arr[1]);
    for(int i=2; i<arr.length; i++){
      prevGCD = gcd3(prevGCD, arr[i]);
    }

    return prevGCD;
  }
}
