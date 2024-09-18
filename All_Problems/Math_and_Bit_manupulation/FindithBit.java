package Math_and_Bit_manupulation;

import java.lang.Math;

public class FindithBit {
  public static void main(String[] args) {
    int number = 45; // 101101
    int i = 6;

    /*One way of getting mask (000100) */
    // int andWithOne = (number & (int)Math.pow(2, i-1)); 

    /*
     *  45 & 2^2
     *  45 & 8
     * 
     *   101101 
     * & 000100
     */

     /*
      * Another wat to get mask (left shift n-1 place)
      */
    int andWithOne = (number & 1 << (i-1)); 
    
    int ithBit = andWithOne == 0 ? 0 : 1;
    System.out.println(i+"th bit in number is: "+ ithBit);
  }
}
