package Arrays_Strings.Strings;

/*
 * Solution link: https://www.youtube.com/watch?v=1vZswirL8Y8
 */
public class A03_Multiply_two_Large_numbers {
  public String multiplyStrings(String s1,String s2)
  {
    if(s1.equals("0") || s2.equals("0")){
      return "0";
    }
    boolean isResPos = true;
    if((s1.charAt(0) == '-' && s2.charAt(0) != '-')||
      (s2.charAt(0) == '-' && s1.charAt(0) != '-')){
      isResPos = false;
    }
    
    s1 = reverse(s1);
    s2 = reverse(s2);
    
    int n1 = s1.length();
    int n2 = s2.length();
    
    int res[] = new int[n1+n2];
    
    for(int i=0; i<n1; i++){
      int num1 = s1.charAt(i) - '0';
      for(int j=0; j<n2; j++){
        int num2 = s2.charAt(j) - '0';
        
        int digProduct = num1 * num2;
        res[i+j] = res[i+j] + digProduct;
        res[i+j+1] = res[i+j+1] + (res[i+j] / 10);
        res[i+j] = res[i+j] % 10;

      }
    }
    
    StringBuilder sb = new StringBuilder();
    boolean isNonZeroFound = false;
    for(int i=(n1+n2-1); i>=0; i--){
        if(!isNonZeroFound && res[i]==0){
            continue;
        }
        isNonZeroFound = true;
        sb.append(res[i]);
    }
    if(!isResPos && sb.length() != 0){
        sb.insert(0, "-");
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
  
  public String reverse(String str){
    StringBuilder sb = new StringBuilder(str);
    if(sb.charAt(0) == '-'){
      sb.deleteCharAt(0);
    }
    return sb.reverse().toString();
  }
}
