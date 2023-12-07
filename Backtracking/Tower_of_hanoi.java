package Backtracking;
/*
 * Link: https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1
 */

/*
 * The main objective of the Tower of Hanoi problem is to move all the "N" number of disks 
 * from the given peg to the destination peg by following the simple rules mentioned below.
 * 
 * Rules to be Followed During Shifting From the Source to destination peg:
 * - We can move only one disk at a time.
 * - Each move consists of taking the upper disk from one of the pegs and placing it on top of another peg i.e, 
 *      a disk can only be moved if it is the uppermost disk on a peg.
 * - No disk should be placed at the top of the smaller disk which means 
 *      that the disk of larger diameter cannot be placed on a disk of smaller diameter.
 * - 
 * Constraints:
 *   - Number of pegs = 3 (source, auxiliary, destination)
 *   - 1 <= N (Number of disks) < 100
 * 
 * 
 * Output: print the sequence of moves required to move all the disks from 'Auxilary' to 'Destination'
 * Move disk 1 from SRC to DEST
 * Move disk 2 from SRC to SPARE
 * Move disk 1 from DEST to SPARE
 */

public class Tower_of_hanoi {
  public static void main(String[] args) {
    String source = "SRC";
    String spare = "SPARE";
    String destination = "DEST";
    int n = 2;
    printTowerOfHanoiSequence(n, source, destination, spare);
  }


  /*
   * Logic here is that
   * To move n disks to destination, first we need to move n-1 disks to Spare
   * 
   * Here initial order of disks
   * 1
   * 2
   * 3
   * ...
   */
  public static void printTowerOfHanoiSequence(int n, String source, String destination, String spare){
    if(n==1){
      System.out.println("Move disk " +n+ " from " +source+ " to "+ destination);
      return;
    }

    //to move n disks to 'Dest'
    printTowerOfHanoiSequence(n-1, source, spare, destination); //first we need to move 'n-1' disks from 'Src' to 'Spare' (for this step spare acts as destination for n-1 disks)
    System.out.println("Move disk " +n+ " from " +source+ " to "+ destination);  //move nth(Bottom) disk from 'Src' to 'Destination'
    printTowerOfHanoiSequence(n-1, spare, destination, source); //then move n-1 disk again from 'Spare' to 'Destination'

    /* Actual code is written here for n=2, But once we run it, it works for any number of n */
  }
}
