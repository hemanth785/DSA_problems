
/*
 * LInk: https://leetcode.com/problems/koko-eating-bananas/
 */
public class A08_KokoEatingBananas {
  /*
   * Approach: Using binary search (Efficient) - O(n * log(n)), 
   *    it's not log(n) because, for each k value, we need to loop through entire array for calculating total hours
   * - We know that, min value for k is 1 and max value will be total bananas in biggest pile
   * - So, perform binary search between 1 and max number, to calculate min k value
   */
  public int minEatingSpeed(int[] piles, int h) {
    int maxPileCount = 0;
    for (int i = 0; i < piles.length; i++) {
      maxPileCount = Math.max(maxPileCount, piles[i]);
    }

    int l = 1;
    int r = maxPileCount;

    int minK = 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;

      int totalHourTaken = countTotalHours(piles, mid);
      //if total hours at any moment is less than given target, we can consider that value for result
      // But also check for lesser k value, until (l<=r) condition satisfies.
      
      if (totalHourTaken <= h) {
        minK = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return minK;
  }

  //calculate total hours will be taken for particular k value
  public int countTotalHours(int[] piles, int k) {
    int totalHours = 0;
    for (int i = 0; i < piles.length; i++) {
      totalHours += Math.ceil(piles[i] * 1.0 / k); // multiplying with 1.0, to convert result in float
    }

    return totalHours;
  }
}
