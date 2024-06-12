package Backtracking;
import java.util.Vector;

 /*
  * Link: https://leetcode.com/problems/expression-add-operators/
  * 
  */

public class PossibleExpressionsHR {
  public static void main(String[] args) {
    String str = "3258";  //2+8, 5*2, 5+3+2
    int target = 10;
    Vector<String> expressions = new Vector<String>();
    getPossibleExpressions(str, target, expressions, 0, "", 0, "");

    System.out.println(expressions);
  }

  public static void getPossibleExpressions(
    String str, 
    int target, 
    Vector<String> expressions, 
    int position, 
    String resString, 
    int curTarget, 
    String operation)
  {
    if(position >= str.length()){
      return;
    }

    int curValue = Character.getNumericValue(str.charAt(position));

    if(operation != ""){
      switch(operation){
        case "+": 
          curTarget = curTarget+curValue;
          break;
        case "-": 
          curTarget = curTarget-curValue;
          break;
        case "*": 
          if(curTarget == 0){
            curTarget = 1;
          }
          curTarget = curTarget*curValue;
          break;

        case "/": 
          if(curTarget != 0 && curValue != 0){
            curTarget = curTarget/curValue;
          }
          break;
          
        default: break;
      }

      resString = resString + curValue;

      if(curTarget == target){
        expressions.add(resString);
        return;
      }
    } else {
      resString = curValue+"";
      curTarget = curValue;
    }
    getPossibleExpressions(str, target, expressions, position+1, resString+"+", curTarget, "+");
    getPossibleExpressions(str, target, expressions, position+1, resString+"-", curTarget, "-");

    getPossibleExpressions(str, target, expressions, position+1, resString+"*", curTarget, "*");
    // getPossibleExpressions(str, target, expressions, position, resString, curTarget, "/");
  }
}
