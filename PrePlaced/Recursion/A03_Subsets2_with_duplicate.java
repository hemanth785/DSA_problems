package PrePlaced.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of integers A, return all possible subsets. The array might contain duplicates.
 * 
 * link: https://workat.tech/problem-solving/practice/subsets-ii
 */
public class A03_Subsets2_with_duplicate {
  public static void main(String[] args) {
    int arr[] = {1, 3, 3};
    List<List<Integer>> powerSet = subsets(arr);

    for(int i=0; i<powerSet.size(); i++){
      System.out.print(powerSet.get(i).toString()+" ");
    }
  }
  static List<List<Integer>> subsets(int[] A) {
    //here sorting of elements is necessary
		Arrays.sort(A);
		
	  List<List<Integer>> subsetList = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		
		subsetsRecursive(A, subsetList, subset, 0);
		
		return subsetList;
	}
	
	static void subsetsRecursive(int[] A, List<List<Integer>> subsetList, List<Integer> subset, int index){
		if(index > A.length){
			return;
		}
		if(index == A.length){
			subsetList.add(new ArrayList<>(subset));
			return;
		}
		
		//including current element
		subset.add(A[index]);
		subsetsRecursive(A, subsetList, subset, index+1);
		subset.remove(subset.size()-1);
			
	  //excluding current element, (exlude all occurence of current element): THIS IS IMPORTANT
    int nextIndex = index+1;
		while(nextIndex < A.length && A[index] == A[nextIndex]){
			nextIndex++;
		}
		subsetsRecursive(A, subsetList, subset, nextIndex);
	}
}
