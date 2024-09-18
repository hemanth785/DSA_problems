package General;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * Link: https://www.hackerrank.com/contests/coding-test-june-batch/challenges/toy-shop-1-1/
 */
public class ToyShop {
  /*
   * Initial solution from my side
   */
  public static int toys(List<Integer> arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());

        int nextIndexToStart = 0;
        int startedIndex = 0;
        int curIndex = 0;
        int count = 0;
        
        int lastItem = -1;
        
        Set<Integer> set = new HashSet<>();
        
        while(curIndex < arr.size()){
            
            int item = arr.get(curIndex);
            if(lastItem != -1){
                if(item != lastItem){
                    if(set.size()==2 && !set.contains(item)){
                        treeMap.put(count, startedIndex);
                        count = 0;
                        curIndex = nextIndexToStart;
                        startedIndex = curIndex;
                        
                        set.clear();
                    } 
                    if(set.size() > 0){
                        nextIndexToStart = curIndex;
                    }
                    lastItem = item;
                    set.add(item);    
                }
            } else {
                lastItem = item;
                set.add(item);
            }
            count++;
            curIndex++;
        }
        treeMap.put(count, startedIndex);
        
        for(Map.Entry entry: treeMap.entrySet()){
            return (int)entry.getKey();
        }
        return 0;
    }
}
