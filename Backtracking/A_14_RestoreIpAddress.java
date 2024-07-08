package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://workat.tech/problem-solving/practice/restore-ip-addresses
 */
public class A_14_RestoreIpAddress {
  public static void main(String[] args) {
    List<String> validIpList = restoreIPAddresses("25525511135");
    System.out.println("Valid IP address list");
    System.out.println(validIpList);
  }

  static List<String> ipList;
	static List<String> restoreIPAddresses(String s) {
	  int n = s.length();
		ipList = new ArrayList<>();
		formIpRec(s, n, 0, 0, "");
		
		return ipList;
	}
	
	static void formIpRec(String s, int n, int index, int partCount, String restoredIP){
		if(index >= n){
			if(partCount == 4 && !ipList.contains(restoredIP)){
				ipList.add(restoredIP);
			}
			return;
		}
		for(int i=1; i<=3; i++){
			String subStr;
			if(index+i > n){
				break;
			} 
      subStr = s.substring(index, index+i);
			
			if(isValidIpNumber(subStr)){
				String resString = restoredIP.equals("") ? subStr : restoredIP+"."+subStr;
				formIpRec(s, n, index+i, partCount+1, resString);
			}
		}
	}
	
	static boolean isValidIpNumber(String subStr){
		int intVal = Integer.parseInt(subStr);
		if(intVal > 255){
			return false;
		}
		if(intVal == 0 && subStr.length() > 1){
			return false;
		}
		if((intVal < 10 && subStr.length() > 1) ||
		   (intVal < 100 && subStr.length() > 2)
		  ){
			return false;
		}
		return true;
	}
}
