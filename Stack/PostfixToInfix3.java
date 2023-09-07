package Stack;
/*
 * Input: abc++
 * Output: (a + (b + c))
 * 
 * Input  : ab*c+
 * Output : ((a*b)+c)
 * 
 */

import java.util.Stack;

public class PostfixToInfix3 {
  public static void main(String args[]){
    String postfix = "abc/-ad/e-*";
    // String postfix = "ab*c+";
    String infix = postfixToInfix(postfix);
    System.out.println("infix expression: "+ infix);
  }

  public static boolean isOperand(char operand){
    return (operand>='A' && operand<='Z') ||
            (operand>='a' && operand<='z') ||
             (operand>='2' && operand<='9');
  }

  public static String postfixToInfix(String postfix){
    Stack<String> stack = new Stack<String>();
    String infix = "";

    for(int i=0; i<postfix.length(); i++){
      char currentChar = postfix.charAt(i);
      if(isOperand(currentChar)){
        stack.push(""+currentChar);
      } else {
        if(stack.size() < 2){
          System.out.println("Invalid postfix expression");
          return "";
        }
        String b = stack.pop();
        String a = stack.pop();  //need to use reverse a and b, to form the expression correct

        String expression = "("+a + currentChar + b+")";
        if(i < postfix.length()-1){
          stack.push(expression);
        } else {
          infix = a + currentChar + b;
        }
      }
    }
    return infix;
  }
}
