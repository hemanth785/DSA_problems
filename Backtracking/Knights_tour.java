package Backtracking;
import java.util.Arrays;
/*
 * Given a N*N board with the Knight placed on the first block of an empty board. 
 * Moving according to the rules of chess knight must visit each square exactly once. 
 * Print the order of each cell in which they are visited.
 * 
 * Input : 
 *   N = 8
 * Output:
 *   0  59  38  33  30  17   8  63
 *   37  34  31  60   9  62  29  16
 *   58   1  36  39  32  27  18   7
 *   35  48  41  26  61  10  15  28
 *   42  57   2  49  40  23   6  19
 *   47  50  45  54  25  20  11  14
 *   56  43  52   3  22  13  24   5
 *   51  46  55  44  53   4  21  12
 */
public class Knights_tour {
  public static void main(String[] args) {
    int n = 3; //it can be given in terms of n X m also
    printKnightMoves(n);
  }

  public static void printKnightMoves(int n){
    //identify the possible moves for a knight inside the chess board from any given position
    int xMoves[] = {2, 2, -2, -2, 1, -1, 1, -1};
    int yMoves[] = {1, -1, 1, -1, 2, 2, -2, -2};

    //initialize a board to record the sequence of moves of knights, and mark all positions as not visited (-1)
    int board[][] = new int[n][n];
    for(int i=0; i<n; i++){
      Arrays.fill(board[i], -1); //Array.fill only work for 1 dimensional array
    }
    
    //define initialize position 0,0
    int x=0, y=0, moves=0;
    if(!knightTraverse(n, board, xMoves, yMoves, x, y, moves+1)){

    } else {
      printBoard(n, board);
    }


    
  }

  public static boolean knightTraverse(int n, int[][] board, int[] xMoves, int[] yMoves, int x, int y, int moves){
    if(moves > n*n){
      return true; //if it has reached max moves, means knight has successfully visited all the boxes
    }
    int possibleMoves = xMoves.length;
    for(int i=0; i<possibleMoves; i++){
      int nextMoveX = x+xMoves[i];
      int nextMoveY = y+yMoves[i];
      boolean isSafe = isSafe(n, nextMoveX, nextMoveY, board);
      if(isSafe){
        board[nextMoveX][nextMoveY] = moves;
        if(knightTraverse(n, board, xMoves, yMoves, nextMoveX, nextMoveY, moves+1)){
          return true;   //for all return true loop will not run, it'll call for next move
        } else {
          board[nextMoveX][nextMoveY] = -1;   //for all else condition, it'll check for alternate path in given 8 possible paths
        }
      }
    }

    return false; //if all possible 8 moves is not feasisble means, current posititon is not a 100% feasible solution
  }

  public static boolean isSafe(int n, int x, int y, int[][] board){
    if(x >= 0 && x < n &&
      y >= 0 && y < n && 
      board[x][y] == -1){
        return true;
    }
    return false;
  }

  public static void printBoard(int n, int[][] board){
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        System.out.print(board[i][j]+" ");
      }
      System.out.println("");
    }
  }
}
