package Backtracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

 /*
  * Link: https://leetcode.com/problems/expression-add-operators/
  * 
  */

public class A_12_PossibleExpressionsHR {
  public static void main(String[] args) {
    String str = "3258";  //2+8, 5*2, 5+3+2
    int target = 10;
    Vector<String> expressions = new Vector<String>();
    getPossibleExpressions(str, target, expressions, 0, "", 0, "");

    System.out.println(expressions);
  }

  /*
   * Appraoch: Use Recursion
   * - Only multiplication is complication, + and i is easy (devide is not required for this problem)
   * - For the multiplication purpose only we need to pass prevNum variable
   * - Note: Once multiplication is completed, we are passing (prevNum * curNum) as next prevNum, instead of just passing curNum because
   *   - When there are continuous multiplications like (3+4*2*6*...), 
   *     we need to subract the result of continuous previous subractions from rest of expression (left side expresion where right most + or - exists: ex "3+")
   *     that is because, when there is continuous multiplication is there, we need to perform all the multiplications first and then add or subtract the previous expression which is devided by + or -
   * 
   * For ex:  3+4*2*6
   *  Till 3rd operand (2), we will have result as = 11
   *  whenever we need to multiple 6 to 11, 
   *  - First we need to subtract only the products(4*2 = 8) from the result => 11-8 = 3
   *  - then we need to calculate product for new number(6) with prev prod(8), that becomes = 48
   *  - then add or subract the disconnected expression(expression where + or i exists) value = 48+3 = 51
   */
  List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        operatorRec(num, target, 0, "", 0l, 0l);
        return result;
    }

    public void operatorRec(String num, int target, int index, String curExp, Long resSoFar, long prevNum){
        if(index == num.length()){
            if(resSoFar == target){
                result.add(curExp);
            }
            return;
        }

        for(int k=index; k<num.length(); k++){
            // check for leading(left side) zero number at any stage: ex 05, 0556 etc
            // just 0 is accepted and 40 and 406 are accepted
            if(k!=index && num.charAt(index) == '0'){
                break;
            }

            Long curNum = Long.parseLong(num.substring(index, k+1));
            //if this is the first number in expression: ex: 1, 12, 123
            if(index == 0){
                operatorRec(num, target, k+1, curNum+"", curNum, curNum);
            } else {
                //Here check for possible 3 operations(+, -, *)
                operatorRec(num, target, k+1, curExp+"+"+curNum, resSoFar+curNum, curNum);
                operatorRec(num, target, k+1, curExp+"-"+curNum, resSoFar-curNum, -curNum);
                operatorRec(num, target, k+1, curExp+"*"+curNum, (resSoFar-prevNum)+ (prevNum*curNum), prevNum*curNum);
            }
        }
    }
}
