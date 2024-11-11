package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
  public static void main(String[] args) {
    System.out.println("result: "+search("jabcghj", "ab"));
  }

  static int search(String txt, String pat) {
    int n = txt.length();
    int k = pat.length();
    
    HashMap<Character, Integer> mapTxt = new HashMap<>();
    HashMap<Character, Integer> mapPat = new HashMap<>();
    
    int matchCount = 0;
    int anagramsCount = 0;

    //put first k chars in map
    for(int i=0; i<k; i++){
        char pChar = pat.charAt(i);
        mapPat.put(pChar, mapPat.getOrDefault(pChar, 0)+1);
    }

    for(int i=0; i<k; i++){
      char tChar = txt.charAt(i);
      if(mapPat.containsKey(tChar)){
        mapTxt.put(tChar, mapTxt.getOrDefault(tChar, 0)+1);
        matchCount++;
      }
    }
    
    System.out.println(mapPat.toString());
    System.out.println(mapTxt.toString());
    
    if(matchCount == k){
        anagramsCount++;
    }
    
    int l = 0;
    int r = k;
    
    while(r < n){
        char prevChar = txt.charAt(l);
        char nextChar = txt.charAt(r);
        
        //System.out.println("l: "+l);
        
        if(mapPat.containsKey(prevChar)){
            mapTxt.put(prevChar, mapTxt.get(prevChar)-1);
            if(mapPat.get(prevChar).equals(mapTxt.get(prevChar))){
              matchCount--;
            } else {
              matchCount++;
            }
            
        }
        if(mapPat.containsKey(nextChar)){
            mapTxt.put(nextChar, mapTxt.getOrDefault(nextChar, 0)+1);
            if(mapPat.get(nextChar).equals(mapTxt.get(nextChar))){
              matchCount++;
            } else {
              matchCount--;
            }
        }
        
        if(matchCount == k){
            System.out.println("l: "+l+", r: "+r+" - "+txt.substring(l+1, r+1));
            anagramsCount++;
        }
        
        l++;
        r++;
    }
    
    return anagramsCount;
  }


}




