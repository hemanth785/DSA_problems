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
  public static int minSwaps(String s) {
    Stack<Character> stack  = new Stack<>();

    for(int i=0; i<s.length(); i++){
        char curChar = s.charAt(i);
        if(curChar == '[' || stack.isEmpty()){
            stack.push(curChar);
        } else if(curChar == ']'){
            if(stack.peek() == '['){
              stack.pop();
            } else {
              stack.push(curChar);
            }
        }
    }

    return stack.size()/2;
}
}
