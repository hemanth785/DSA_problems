package PrePlaced.Arrays_Strings.Strings;

import java.util.Stack;
/*
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 */
public class A_04_SwapsNeededToBalanceParanthesis {
  public static void main(String[] args) {
    String str = "]]]][[[[";
    int swaps = minSwaps(str);
    System.out.println("min swaps required to balance: "+swaps);
  }

  /*
   * Approach: Using stack
   * - For each opening bracket or if stack is empty, then push current char to stack
   * - For each closing bracket, check if top of the stack contains opening bracket,
   *   -If yes, remove it from the stack
   * 
   * - Once we reach the end of the stack, number of swaps needed equals to half of the stack size. 
   *   i.e. swaps needed  = stack.size()/2
   */
  public static int minSwaps(String str) {
    Stack<Character> stack  = new Stack<>();

    for(int i=0; i<str.length(); i++){
      char curChar = str.charAt(i);
      if(curChar == '[' || stack.isEmpty()){
        stack.push(curChar);
      } else if(curChar == ']'){
        if(stack.peek() == '['){
          stack.pop();
        } 
      }
    }

    return stack.size()/2;
  }
}
