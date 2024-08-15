package Stack;
import java.util.Stack;  

public class A15_InfixToPostfix1 {
  public static void main(String args[]){
    // String infix = "(a+b)*(c+d)";
    String infix = "(a-b/c)*(a/k-l)";
    String postfix = infixToPostfix(infix);
    System.out.println("postfix expression: "+ postfix);
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

  public static boolean isOperand(char operand){
    return (operand>='A' && operand<='Z') ||
            (operand>='a' && operand<='z') ||
             (operand>='0' && operand<='9');
  }

  public static String infixToPostfix(String infix){
    Stack<Character> stack = new Stack<Character>();
    String postFix = "";

    for(int i=0; i<infix.length(); i++){
      char item = infix.charAt(i);

      if(isOperand(item)){
        postFix += item;

      } else if(item == '('){
        stack.push(item);
        
      } else if(item == ')'){
        while(!stack.isEmpty() && stack.peek() != '('){
          postFix += stack.pop();
        }
        if(!stack.empty()){
          stack.pop();
        }

      } else {
        //first check if higher priority operator is there in the top of stack, 
        //  remove and add it to postfix, before addint current operator
        while(!stack.isEmpty() && getRank(stack.peek()) >= getRank(item)){
          postFix += stack.pop();
        }
        stack.push(item);
      }
    }

    while(!stack.isEmpty()){
      postFix += stack.pop();
    }
    return postFix;
  }
}

// input = a/b-c
// stack: -
// postfix: ab/c-