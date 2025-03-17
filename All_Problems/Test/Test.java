package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
  
  public static void main(String[] args) {
		String res = getHash("test");
		System.out.println("res: "+res);
  }

	static final int MAX_CHAR = 26;
  static String getHash(String s) {
    StringBuilder hash = new StringBuilder();
    int[] freq = new int[MAX_CHAR];
    
    // Count frequency of each character
    for (char ch : s.toCharArray()) {
        freq[ch - 'a']++;
    }

    // Append the frequency to construct the hash
    for (int i = 0; i < MAX_CHAR; i++) {
        hash.append(freq[i]);
        hash.append("$");
    }

    return hash.toString();
  }


 

}




