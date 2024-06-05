package Stack;

import java.util.Stack;  

public class BalancedBrackets {
  public static void main(String args[]){
    String brackets = "[{()}]";
    System.out.println(isBalanced(brackets));

    String brackets2 = "{[(])} ";
    System.out.println(isBalanced(brackets2));

    String brackets3 = "{{[[(())]]}}";
    System.out.println(isBalanced(brackets3));
  }

  /*
   * Steps:
   * 1. Loop through brackecks
   * 2. if we come accrosss opening bracket, push it to the stack
   * 3. if come accross the closing bracket, pop the top element from stack and check opening and closing bracket matching
   *      if its matching - continue
   *    else 
   *      if stack is empty or bracket does not match, return false
   */
  
  public static String isBalanced(String s) {
    Stack<Character> stack = new Stack<Character>();
    
    for(int i=0; i<s.length(); i++){
        char bracket = s.charAt(i);
        if(bracket == '[' || bracket == '{' || bracket == '('){
            stack.push(bracket);
        } else {
            if(stack.isEmpty() || !isPair(stack.pop(), bracket)){
                return "NO";
            }
        }
    }
    if(!stack.isEmpty()){
        return "NO";
    }
    return "YES";
  }

  public static boolean isPair(char openingBracket, char closingBracket){
    return (openingBracket == '[' && closingBracket == ']') ||
            (openingBracket == '{' && closingBracket == '}') ||
            (openingBracket == '(' && closingBracket == ')');
  }

}
