package Math_and_Bit_manupulation;
/*
 * You will be given a list of 32 bit unsigned integers. Flip all the bits ( and ) and return the result as an unsigned integer.
 * link: https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/flipping-bits
 */
public class Flip_all_bits {
  public static void main(String[] args) {
    int n = 9; // 00010 ==> 11101 (29)

    //get the max 32Bit number
    long max32BitNumber = (long)Math.pow(2, 31) + (long)Math.pow(2, 31)-1;

    
    //do the XOR with given number, and thats the ans
    long flippedNumber = n ^ max32BitNumber;
    

    System.out.println(flippedNumber);
  } 
}
