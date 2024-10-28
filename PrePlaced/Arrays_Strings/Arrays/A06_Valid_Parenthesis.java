package PrePlaced.Arrays_Strings.Arrays;

import java.util.Stack;

/*
 * Link: https://leetcode.com/problems/valid-parentheses
 */
public class A06_Valid_Parenthesis {
  public boolean isValid(String str) {
    Stack<Character> stack = new Stack<>();

    for(int i=0; i<str.length(); i++){
      char bracket = str.charAt(i);
      if(bracket == '{' || bracket == '[' || bracket == '('){
        stack.push(bracket);
      } else if(stack.isEmpty() || !isValidBracket(stack.peek(), bracket)){
        return false;
      } else {
        stack.pop();
      }
    }

    return stack.isEmpty();
  }

  boolean isValidBracket(char open, char close){
    return (open == '{' && close == '}') || 
      (open == '[' && close == ']') ||
      (open == '(' && close == ')');
      
  }
}
