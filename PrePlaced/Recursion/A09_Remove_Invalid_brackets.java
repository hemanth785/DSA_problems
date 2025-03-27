package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * Link: https://leetcode.com/problems/remove-invalid-parentheses/description/
 */

public class A09_Remove_Invalid_brackets {
  /*
   * Approach: Using Stack and recursion
   * 1. first count how many invalid brackets are there, using stack
   * 2. then using Recursion, form the valid brackets
   * 3. invalidBracketCount will be helpfull, while ignoring the brack. 
   *      we only ignore the brackets till we exhaust invalid brackets count
   */

  public List<String> removeInvalidParentheses(String str) {
    HashSet<String> result = new HashSet<>();

    int invalidCount = getInvalidBrackets(str);
    
    removeInvalidRec(str, result, "", 0, 0, invalidCount);
    List<String> resultList = new ArrayList<>();
    resultList.addAll(result);

    return resultList;
  }

  public void removeInvalidRec(String str, HashSet<String> result, String resStr, int index, int balanceCount, int invalidCount){
    if(balanceCount < 0){
      return;
    }
    if(index == str.length()){
      if(balanceCount == 0){
        result.add(resStr);
      }
      return;
    }

    char ch = str.charAt(index);
    
    int bracketVal = 0;
    if(ch == '('){
      bracketVal = 1;
    } else if(ch == ')'){
      bracketVal = -1;
    }

    //consider case
    removeInvalidRec(str, result, resStr+ch, index+1, balanceCount+bracketVal, invalidCount);

    //ignore case
    if(invalidCount > 0 && (ch == '(' || ch == ')')){
      removeInvalidRec(str, result, resStr, index+1, balanceCount, invalidCount-1);
    }
  }


  public int getInvalidBrackets(String str){
    Stack<Character> stack = new Stack<>();
    int invalidCount = 0;
    for(char ch: str.toCharArray()){
      if(ch == '('){
        stack.push(ch);
      } else if(ch == ')'){
        if(stack.isEmpty()){
          invalidCount++;
        } else {
          stack.pop();
        }
      }
    }

    invalidCount += stack.size();
    return invalidCount;
  }
}
