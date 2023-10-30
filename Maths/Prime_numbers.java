package Maths;

import java.util.Arrays;

public class Prime_numbers {
  public static void main(String[] args) {
    int number = 30;
    // boolean res = isPrime(number);
    // System.out.print("is prime: "+res);


    // findNprimeNumbers1(number);
    findNprimeNumbers2(number);
  }

  /*
   * Solution: Efficient for finding whethe single number is prime or not
   * 
   * Time: O(sqrt(n))
   */
  public static boolean isPrime(int number){
    for(int i=2; i<=(int)Math.sqrt(number); i++){
      if(number%i == 0){
        return false;
      }
    }

    return true;
  }

  /*
   * Problem: Find the prime number from 1 to n
   * Solution 1: Somewhat efficient 
   * 
   * Time: O(n * sqrt(n))
   */
  public static void findNprimeNumbers1(int number){
    System.out.print("Prime numbers for n="+number+": ");
    for(int i=2; i<=number; i++){  // O(n)
      if(isPrime(i)){   // O(sqrt(n))
        System.out.print(i+", ");
      }
    }
  }

  /*
  * Problem: Find the prime number from 1 to n
  * Solution 1: Most efficient (Seive of Eratosthens)
  * 
  * Aproach:
  * - Loop through numbers from 2 to n
  * - Run a second loop (if isPrime marked as false)
  * - 
  * - 
  * - Time: n * log(log(n)) , this is better than n*sqrt(n)
  */

  /*
   * Explanation: https://www.geeksforgeeks.org/sieve-of-eratosthenes/
   */
  public static void findNprimeNumbers2(int number){
    System.out.print("Prime numbers for n="+number+": ");

    Boolean markedPrime[] = new Boolean[number+1];
    Arrays.fill(markedPrime, true);

    //loop through numbers from i from 2 to sqrt(n), 
    //- Run inner loop for the multiples of i, and mark it as nonPrime number
    for(int i=2; i<=Math.sqrt(number); i++){  // O(n)
      for(int j=2*i; j<number; j=j+i){
        markedPrime[j] = false;
      }
    }

    //run through marked array and print all the non-marked(prime) numbers
    for(int i=2; i<number; i++){
      if(markedPrime[i]){
        System.out.print(i+", ");
      }
    }
  }

}
