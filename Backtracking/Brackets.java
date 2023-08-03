package Backtracking;
import java.util.*;

/*
 * Write a function to generate all possible n pairs of balanced parentheses. 
 * 
 * for input n=2,
 * well formed brackets are: ()(), (()) 
 * 
 * invalid brackets: ))((, (()(), etc
 */

public class Brackets {
  public static void main(String[] args) {
    int n = 3;
    formBrackets(n);
  }
  

  /*
   * Aproach:
   * - We can use recursion here, with two branch. 
   * - left recursion call will keep adding open brackets
   * - right recursion call will keep adding close brackets
   * - Keep checking for validity of bracket formed
   * 
   * Some of the the conditions to mark brackets as invalid
   * - unequal number of open and close brackets
   * - if its start with close bracket
   * - at any point number of closed brackets is more than open bracket, we can terminate the branch itself
   */

  char openBracket = '(';
  char closeBracket = ')';

  private static void backtrack(int n, String brackets, ArrayList<String> validBrackets, int diff){
    if(n==0 && diff == 0){
      validBrackets.add(brackets);
      return;
    } else if(diff < 0){
      return;
    } else if(n==0){
      return;
    }

    backtrack(n-1, brackets+ "(", validBrackets, diff+1 );
    backtrack(n-1, brackets+ ")", validBrackets, diff-1 );
  }
  
  public static void formBrackets(int n){
    /* to keep track of left and right brackets,
     * - if we add left bracket, increase count by 1
     * - if we ade right bracket, decrease count by 1
     * - if any point count is less than 0, we can terminate the branch
      */
    int diff = 0; 
    ArrayList<String> validBrackets = new ArrayList<String>();
    backtrack(n+n, "", validBrackets, diff);
    System.out.println(validBrackets);
  }
}
