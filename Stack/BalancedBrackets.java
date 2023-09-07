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
  public static String isBalanced(String s) {
    Stack<Character> stack = new Stack<Character>();
    
    for(int i=0; i<s.length(); i++){
        char bracket = s.charAt(i);
        if(bracket == '[' || bracket == '{' || bracket == '('){
            stack.push(bracket);
        } else {
            if(stack.isEmpty() || !isPair(stack.pop(),bracket)){
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
