package String;

import java.util.Stack;
/*
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/submissions/
 */
public class SwapsNeededToBalanceParanthesis {
  public static void main(String[] args) {
    String str = "]]]][[[[";
    int swaps = minSwaps(str);
    System.out.println("min swaps required to balance: "+swaps);
  }
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
