package Stack;

import java.util.Stack;
/*
 * Input: *-a/bc-/ade
 * Output: abc/-ad/e-*
 */

public class A22_PrefixToPostfix6 {
  public static void main(String args[]){
    String prefix = "*-a/bc-/akl";
    String postfix = prefixToPostfix(prefix);
    System.out.println("postfix expression: "+ postfix);
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
   * Do the Postfix to infix conversion from the end of given expression, 
   * but while forming expression, put the operator to the right of the operands, instead of center
   * 
   * ab+ (postfix)==> a+b (infix) ==> +ab(prefix) 
   */
  public static String prefixToPostfix(String prefix){
    Stack<String> stack = new Stack<String>();
    String postfix = "";

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

        String expression = currentChar + a + b;  
        // NOte: here we are keeping operator at left, because 
        // we reverse result string at line: 62, operator will come at right 
        if(i > 0){
          stack.push(expression);
        } else {
          postfix = currentChar + a + b;
        }
      }
    }

    postfix = reverseString(postfix);

    return postfix;
  }
}
