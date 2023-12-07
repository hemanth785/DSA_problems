package Backtracking;
/*
 * link: https://workat.tech/problem-solving/practice/consecutively-descending-integers
 */
public class ConsecutiveDescIntegers {
  public static void main(String[] args) {
    boolean isValid = isConsecutivelyDescending("543210");
    System.out.println("is conscecutive descending: "+ isValid);
  }

  static boolean isPossible;
	static boolean isConsecutivelyDescending(String s) {
	    int n = s.length();
		isPossible = false;
		isConscecutiveDescPossible(s, n, 0, -1);
		
		return isPossible;
	}
	
	static void isConscecutiveDescPossible(String s, int n, int index, long prevNum){
		if(index >= n){
			isPossible = true;
			return;
		} 
		
		for(int step=1; step<=n-1; step++){
			int endIndex = index+step <= n ? index+step : n;
			String numStr = s.substring(index, endIndex);
			long curNum = Long.parseLong(numStr);
            if(curNum > (long)Integer.MAX_VALUE){
                break;
            }
			
			if(prevNum == -1 || prevNum == curNum+1){
				isConscecutiveDescPossible(s, n, index+step, curNum);
			}
		}
	}
}
