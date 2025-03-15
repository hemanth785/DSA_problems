
/*
* Link: https://leetcode.com/problems/basic-calculator/
*/

import java.util.Stack;

public class A07_MinWindowSubtring{
	/*
	 * Approach: This is different from processing infix and postfix expressions
	 *
	 */
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();

		int res = 0;
		int num = 0;
		int sign = 1;

		for(char ch : s.toCharArray()){
			if(ch-'0' >=0 && ch-'0' <= 9){
				num = num*10 + ch-'0'; //because number can contain multiple digits

			} else if(ch == '-' || ch == '+'){
				res = res + sign * num;
				num = 0;
				sign = ch == '+' ? 1 : -1 ;

			} else if(ch == '('){
				//whenever we encounter the bracket, push the result so far and sign into stack
				stack.push(res); 
				stack.push(sign);

				res = 0;
				num = 0;
				sign = 1;

			} else if(ch == ')'){
				res = res + sign*num;

				int stackSign = stack.pop();
				int stackRes = stack.pop();

				res = stackRes + stackSign * res;
				
				num = 0;
			}
		}

		return res + sign*num;
	}
}