/* Problem: Find the missing element in the array of size n, having n-1 elements, which only contails element values from 1 to n.

input arr; [1,2,6,4,3,7], n=7
output: 5

Note: the same below solutions will work for one duplicate element in the AP
*/



import java.util.Arrays;

class Find_missing_element {
  public static void main(String[] args) {
    int arr[] = {1,2,6,4,3,7};
    int n = 7;
    
    // int res = findMissingElement1(arr, n);
    // int res = findMissingElement2(arr, n);
    // int res = findMissingElement3(arr, n);
    int res = findMissingElement4(arr, n);

    System.out.print("Missing element: "+res);
  }


  
  //1. bruteforce aproach, O(n^2)
  public static int findMissingElement1(int arr[], int n){
    //loop for sequential iteration of expected Arithmatic progressions (AP)
    for(int i=1; i<=n; i++){ 
      boolean matched = false;

      //loop for iteration of actual array
      for(int j=0; j<n-1; j++){
        if(i == arr[j]){
          matched = true;
          continue;
        }
      }
      if(!matched){
        return i;
      }
    }
    return -1;
  }


  
  //2. sorting the array aproach, O(n * log(n))
  public static int findMissingElement2(int arr[], int n){
    Arrays.sort(arr);  //this causes O(log(n))

    for(int i=0; i<n-2; i++){ //O(n)
      if(arr[i]+1 != arr[i+1]){
        return arr[i]+1;  //this is the missing element
      }
    }
    return -1;
  }



  //formula aproach, O(n)
  public static int findMissingElement3(int arr[], int n){
    //find the expected sum of summation of (1 to n), by using formula
    int summation = (n * (n+1))/2; //this can be done with loop also.

    //find the sum of all elements in array
    int sumOfArray = 0;
    for(int item: arr){
      sumOfArray += item;
    }

    //find the difference b/w 2
    return summation - sumOfArray;
  }


  
  //using XOR menthod - ex: 6^6=0, a^a=0, 3^3^3=3 - O(n)
  public static int findMissingElement4(int arr[], int n){
    int xor = 0;
    for(int i=0; i<n-1; i++){
      xor = xor^arr[i]^i+1;
    }
    xor =  xor^n; // add last element of progression into XOR
    return xor;
  }

}

