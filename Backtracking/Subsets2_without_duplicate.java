package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * link: https://workat.tech/problem-solving/practice/subsets-ii
 * 
 */
public class Subsets2_without_duplicate {
  List<List<Integer>> subsets(int[] A) {
		Arrays.sort(A);
		
	  List<List<Integer>> subsetList = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		
		subsetsRecursive(A, subsetList, subset, 0);
		
		return subsetList;
	}
	
	void subsetsRecursive(int[] A, List<List<Integer>> subsetList, List<Integer> subset, int index){
		if(index > A.length){
			return;
		}
		if(index == A.length){
			subsetList.add(new ArrayList<>(subset));
			return;
		}
		
		//including current element, (including duplicate also)
		subset.add(A[index]);
		subsetsRecursive(A, subsetList, subset, index+1);
		subset.remove(subset.size()-1);
			
	  //excluding current element, (exluding duplicate also)
    int nextIndex = index+1;
		while(nextIndex < A.length && A[nextIndex] == A[index]){
			nextIndex++;
		}
		subsetsRecursive(A, subsetList, subset, nextIndex);
	}
}
