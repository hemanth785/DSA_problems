package Stack;

import java.util.Stack;

/*
 * Input :  Postfix : ABC/-AD/L-*
 * Output : Prefix :  *-A/BC-/ADL
 */

public class PostfixToPrefix5 {
  public static void main(String args[]){
    String postfix = "abc/-ad/e-*";
    String infix = postfixToPrefix(postfix);
    System.out.println("prefix expression: "+ infix);
  }

  public static boolean isOperand(char operand){
    return (operand>='A' && operand<='Z') ||
            (operand>='a' && operand<='z') ||
             (operand>='2' && operand<='9');
  }

  /*
   * Do the Postfix to infix conversion, but while forming expression, 
   * put the operator to the left of the operands, instead of center
   * 
   * ab+ (postfix)==> a+b (infix) ==> +ab(prefix) 
   */
  public static String postfixToPrefix(String postfix){
    Stack<String> stack = new Stack<String>();
    String prefix = "";

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

        String expression = currentChar + a + b;  //put operator at the left side
        if(i < postfix.length()-1){
          stack.push(expression);
        } else {
          prefix =  currentChar + a + b; //put operator at the left side
        }
      }
    }
    return prefix;
  }
}
