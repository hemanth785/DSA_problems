
/*
 * Find the Bitonic point in a given array
 * arr = [2,4,5,7,9,10,12,8,6,4,2,1]
 * output = 12
 * 
 * Bitonic: In a array, elements values will be keep increasing strictly, until some point after that it decreases strictly
 */


public class A01_Find_bitonic_point {
  public static void main(String[] args) {
    int arr[] = {2,4,5,7,9,10,12,16,18,14,12,1};
    // int arr[] = {2,4,5,7,9,10,12,16,18};

    // int res = solution1(arr, arr.length);
    int res = solution2(arr, arr.length);

    System.out.println("Bitonic point: "+ res);
  }


  /*
   * Solution 1: Compare consecutive elements in array
   * 
   * to find bitonic point, condition would be:  a[i-1] < a[i] > a[i+1]
   * 
   * Time: O(n)
   */
  public static int solution1(int arr[], int n){
    for(int i=1; i<n-1; i++){
      if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
        return arr[i];
      }
    }
    return -1;
  }

  /*
   * Solution 2: using binary search
   * 
   * to find bitonic point, condition would be:  a[i-1] < a[i] > a[i+1]
   * 
   * Time: O(log(n))
   */
  public static int solution2(int arr[], int n){
    int l = 0;
    int r = n-1;
    int mid = 0;

    while (l<r){
      mid = (r+l)/2;
      if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
        return arr[mid];
      } else if(arr[mid] < arr[mid+1]){
        l = mid+1;
      } else {
        r = mid-1;
      }
    }

    return -1;
  }
}
