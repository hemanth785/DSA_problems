package Stack;
import java.util.Stack;  

/*
 * Input: 2 3 1 * + 9 -
 * Output: -4
 */
public class A23_PostfixEvaluation {
  public static void main(String args[]){
    String postfix = "231*+9-";
    int res = evaluatePostfix(postfix);
    System.out.println("postfix result: "+res);
  }

  public static boolean isOperand(char operand){
    return (operand>='A' && operand<='Z') ||
            (operand>='a' && operand<='z') ||
             (operand>='0' && operand<='9');
  }

  public static int performOperation(int a, int b, char operator){
    switch(operator){
      case '+': return a+b;
      case '-': return a-b;
      case '*': return a*b;
      case '/': if(b==0){
                  System.out.println("Invalid operation");
                  return -1;
                } 
                return a/b;
      case '%': return a+b;
      default: return -1;
    }
  }

  public static int evaluatePostfix(String postfix){
    Stack<Integer> stack = new Stack<Integer>();
    for(int i=0; i<postfix.length(); i++){
      char curChar = postfix.charAt(i);
      if(isOperand(curChar)){
        stack.push(Character.getNumericValue(curChar));
      } else {
        if(stack.size() < 2){
          System.out.println("Invalid expression");
          return -1;
        }
        int b = stack.pop();
        int a = stack.pop();

        int res = performOperation(a, b, curChar);
        stack.push(res);
      }
    }
    return stack.pop();
  }
}
