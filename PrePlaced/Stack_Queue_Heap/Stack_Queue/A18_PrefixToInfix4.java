package Stack;

/*
 * Input : abc++
 * Output : (a + (b + c))

 * Input  : ab*c+
 * Output : ((a*b)+c)
 */

import java.util.Stack;

public class A18_PrefixToInfix4 {
  public static void main(String args[]){
    String prefix = "*-a/bc-/akl";
    String infix = prefixToInfix(prefix);
    System.out.println("infix expression: "+ infix);
  }

  public static boolean isOperand(char operand){
    return (operand>='A' && operand<='Z') ||
            (operand>='a' && operand<='z') ||
             (operand>='2' && operand<='9');
  }

  public static String reverseString(String str){  
    StringBuilder sb=new StringBuilder(str);  
    sb.reverse();  
    return sb.toString();  
  } 

  /*
   * Steps:
   * - Do the Postfix to infix conversion from the end of given string
   * - Reverese the resulting string (THIS is the result)
   */
  public static String prefixToInfix(String prefix){
    Stack<String> stack = new Stack<String>();
    String infix = "";

    for(int i=prefix.length()-1; i>=0; i--){
      //Do the postfix conversion in reverse order, while taking care of brackets
      char currentChar = prefix.charAt(i);
      if(isOperand(currentChar)){
        stack.push(""+currentChar);
      } else {
        if(stack.size() < 2){
          System.out.println("Invalid prefix expression");
          return "";
        }
        String b = stack.pop();
        String a = stack.pop();  //need to use reverse a and b, to form the expression correct

        String expression = ")"+a + currentChar + b+"(";
        if(i > 0){
          stack.push(expression);
        } else {
          infix = a + currentChar + b;
        }
      }
    }
    System.out.println(infix);

    infix = reverseString(infix);

    return infix;
  }
}
