import java.util.ArrayList;

/*
 * Link: https://www.naukri.com/code360/problems/allocate-books_1090540
 */
class A09_Allocate_min_pages{
  /*
   * Apprach: Using linear search
   */

  /*
   * Approach: Using binary search
   * - For binary search, find we need to find the min and max value.
   * - To assume l value, we need to assume best case. that is one student will get only one book. 
   *      - So in this case, max pages assinged to any student will be the pages in biggest book
   * - For 'r' pointer value, we need to assume worst, that case all books will be assinged to single student
   *      - in that case max pages assigned to that student is, sum of all the pages of all the books
   * 
   * Time: O(n * log(n))
   */


  public static int findPages(ArrayList<Integer> arr, int n, int m) {
    if (m > n) {
      return -1;
    }

    // l - max pages in single book
    // r - sum of all pages of all books
    int maxPage = 0;
    int allBookPages = 0;
    for (int i = 0; i < n; i++) {
      allBookPages += arr.get(i);
      maxPage = Math.max(maxPage, arr.get(i));
    }

    int l = maxPage;
    int r = allBookPages;

    int maxPagesPerStudent = 0;

    while (l <= r) {
      int mid = (l + r) / 2; // here mid represents the max number of pages that can be assigned to single
                             // student
      boolean isPossible = isPossibleToAssign(mid, arr, n, m);

      if (isPossible) {
        maxPagesPerStudent = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return maxPagesPerStudent;
  }

  public static boolean isPossibleToAssign(int maxPagesPerStudent, ArrayList<Integer> arr, int n, int m) {
    int student = 1;
    int curPages = 0;

    for (int i = 0; i < n; i++) {

      int pages = arr.get(i);
      if (curPages + pages <= maxPagesPerStudent) {
        curPages = curPages + pages;
      } else {
        student++;
        curPages = pages;
      }

      if (student > m) {
        return false;
      }
    }

    return true;
  }
}