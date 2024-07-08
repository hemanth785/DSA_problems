package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * link: https://workat.tech/problem-solving/practice/subsets
 */
public class A_02_Subsets {
  List<List<Integer>> subsets(int[] A) {
	  List<List<Integer>> subsetList = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		
		subsetsRecursive(A, subsetList, subset, 0);
		
		return subsetList;
	}
	
	void subsetsRecursive(int[] A, List<List<Integer>> subsetList, List<Integer> subset, int index){
		if(index == A.length){
			subsetList.add(new ArrayList<>(subset));
			return;
		}
		
		//including current element
		subset.add(A[index]);
		subsetsRecursive(A, subsetList, subset, index+1);
		subset.remove(subset.size()-1);
			
	    //excluding current element
		subsetsRecursive(A, subsetList, subset, index+1);
	}
}
