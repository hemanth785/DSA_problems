package Stack;

import java.util.List;
import java.util.Stack;

/*
 * https://www.hackerrank.com/challenges/equal-stacks/problem
 */
public class A11_EqualStacks {

  public static void main(String args[]) {
    int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
    int res = equalStacks(arr);
    System.out.println("Target found at index: " + res);
  }

  /* */
  public static int equalStacks(
    List<Integer> h1,
    List<Integer> h2,
    List<Integer> h3
  ) {
    
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    Stack<Integer> stack3 = new Stack<>();

    //adding list elements to stack
    sumStack(stack1, h1);
    sumStack(stack2, h2);
    sumStack(stack3, h3);

    int sum1 = stack1.pop();
    int sum2 = stack2.pop();
    int sum3 = stack3.pop();

    //if sum is already equaul, return it
    if (sum1 == sum2 && sum2 == sum3) {
      return sum1;
    }

    // System.out.println("sum1: "+sum1+", sum2: "+sum2+", sum3 "+sum3);
    while (
      !stack1.empty() &&
      !stack2.empty() &&
      !stack3.empty() &&
      (sum1 != sum2 || sum2 != sum3)
    ) {
      int minHeight = Math.min(sum1, Math.min(sum2, sum3));

      if (sum1 > minHeight) {
        sum1 = stack1.pop();
      }
      if (sum2 > minHeight) {
        sum2 = stack2.pop();
      }
      if (sum3 > minHeight) {
        sum3 = stack3.pop();
      }
    }

    //check if any of the stack has become empty
    if (stack1.empty() || stack2.empty() || stack3.empty()) {
      return 0;
    }

    return sum1;
  }

  public static int sumStack(Stack<Integer> stack, List<Integer> h) {
    int sum = 0;
    int n = h.size();

    //Store the prefix sum in stack (instead of each element)
    for (int i = n - 1; i >= 0; i--) {
      sum += h.get(i);
      stack.push(sum);
    }
    return sum;
  }
}
