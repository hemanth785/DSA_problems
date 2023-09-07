package Stack;

import java.util.Stack;

/*
 * Input: A * B + C / D
 * Output: + * A B/ C D 

 * Input: (A – B/C) * (A/K-L)
 * Output: *-A/BC-/AKL
 */
public class InfixToPrefix2 {
  public static void main(String args[]){
    String infix = "*-a/bc-/akl";
    String prefix = infixToPrefix(infix);
    System.out.println("prefix expression: "+ prefix);
  }

  public static boolean isOperand(char operand){
    return (operand>='A' && operand<='Z') ||
            (operand>='a' && operand<='z') ||
             (operand>='2' && operand<='9');
  }

  public static int getRank(char operator){
    switch(operator){
      case '+':
      case '-': return 1;

      case '*':
      case '/':
      case '%': return 2;

      case '^': return 3;

      default: return -1;
    }
  }

  public static String reverseString(String str){  
    StringBuilder sb=new StringBuilder(str);  
    sb.reverse();  
    return sb.toString();  
  } 

  /*For prefix conversion
   * - Start converting the infix from left side
   * - After we reach end of infix expression, 
   * - Reverse the prefix expression for correctness
   */
  public static String infixToPrefix(String infix){
    Stack<Character> stack = new Stack<Character>();
    String infixTemp = "";

    //for prefix conver
    for(int i=infix.length()-1; i>=0; i--){
      //write the Infix to Postfix conversion with bracket updates
      char item = infix.charAt(i);

      if(isOperand(item)){
        infixTemp += item;

      } else if(item == ')'){
        stack.push(item);

      } else if(item == '('){
        while(!stack.isEmpty() && stack.peek() != ')'){
          infixTemp += stack.pop();
        }
        if(!stack.empty()){
          stack.pop();
        }

      } else {
        while(!stack.isEmpty() && getRank(item) <= getRank(stack.peek())){
          infixTemp += stack.pop();
        }
        stack.push(item);
      }
    }
    while(!stack.isEmpty()){
      infixTemp += stack.pop();
    }

    //reverse result string after conversion
    String prefix = reverseString(infixTemp);
    return prefix;
  }
}
