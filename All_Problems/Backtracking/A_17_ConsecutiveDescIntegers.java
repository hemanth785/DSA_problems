package Backtracking;
/*
 * link: https://workat.tech/problem-solving/practice/consecutively-descending-integers
 */
public class A_17_ConsecutiveDescIntegers {
  public static void main(String[] args) {
    boolean isValid = isConsecutivelyDescending("543210");
    System.out.println("is conscecutive descending: "+ isValid);
  }

  /*
   * Approach:
   * 1. Start from index 0 of the string
   * 2. try forming number with 1 digit, 2 digit and so on
   * 3. if its a valid number (curNum+1 = prevNumber), then call recursive function to check the same for next index of string
   * 4. if we reach end of string by following this appraoch, return true.
   */

	static boolean isConsecutivelyDescending(String str) {
	  int n = str.length();
		return isConscecutiveDescPossible(str, n, 0, -1);
	}
	
	static boolean isConscecutiveDescPossible(String s, int n, int index, long prevNum){
		if(index >= n){
			return true;
		} 

		for(int step=1; step<=n-1; step++){
			int endIndex = index+step;
			if(endIndex > n){
				break;
			}
			String numStr = s.substring(index, endIndex);
			long curNum = Long.parseLong(numStr);
      if(curNum > (long)Integer.MAX_VALUE){
          break;
      }
			
			if(prevNum == -1 || prevNum == curNum+1){
				if(isConscecutiveDescPossible(s, n, index+step, curNum)){
					return true;
				}
			}
		}
		
		return false;
	}
}
