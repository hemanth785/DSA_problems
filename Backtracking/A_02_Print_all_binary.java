package Backtracking;
import java.util.*;

/*
 * Print all binary numbers of length n (n digits)
 * 
 * for n=2, 
 * Output:
 * 00
 * 01
 * 10
 * 11
 * 
 * for n=3
 * Output: 
 * 000
 * 001
 * 010
 * 011
 * 100
 * 101
 * 110
 * 111
 * 
 */
public class A_02_Print_all_binary {
  public static void main(String[] args) {
    int n = 3;
    printAllBinary(n);
  }

  /*
   * for backtracking problem, 
   * - first identify the tree we need to build, using recursive call
   * - Next identify all the terminating condiitions
   * 
   * For this problem, we build tree like this
   * - Start with empty string(char) - This is for building solution,
   * - for each recursive call to left of the tree, append '0';
   * - for each recursive call to right of the tree, append '1';
   * - once result string reaches lenghth of 2, i.e 01 or 11, check for the validity of resul
   * - if result is valid, add it to array of result;
   * 
   * 
   * time complexity here would be dept of the tree. i.e O(2^n)
   * Or in other way to calculate it how many times the backtrack function is bieng called. ==> O(2^n)
   */

  public static void backtrack(int n, String binaryNumber, List<String> result){
    System.out.println("binaryNumber: "+binaryNumber);
    if(binaryNumber.length() == n){
      result.add(binaryNumber);
      return;
    }
    

    System.out.println("left");
    backtrack(n, binaryNumber + "0", result); // left tree
    
    System.out.println("right");
    backtrack(n, binaryNumber + "1", result); // right tree
    
  }

  public static void printAllBinary(int n){
    List<String> result = new ArrayList<>();
    String binaryNumber = "";

    backtrack(n, binaryNumber, result);

    System.out.println(result.toString());
  }
}
