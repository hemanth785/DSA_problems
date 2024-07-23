package Math_and_Bit_manupulation;

public class Device_without_division {
  /*
   * Approach: Using subtraction
   */
  int divide(int a, int b) {
		boolean neg = false;
		if((a< 0 && b>0) || (b<0 && a>0)){
			neg = true;
		}
		
		if(a<0){
			a = -a;
		}
		if(b<0){
			b = -b;
		}
		
		int quotient = 0;
        while(a >= b){
			quotient++;
			a=a-b;
		}
		
		return neg ? -quotient: quotient;
  }
}
