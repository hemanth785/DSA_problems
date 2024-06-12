package Backtracking;
/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * 
 * Note: A queen in chessboard can attack in all 8 directions
 */


public class N_Queens {
  public static void main(String[] args) {
    int n = 5;

    placeNQueens(n);
  }  

  /*
   * Approach:
   * - loop through each coloumn in chessboard, starting for col 0, place the 1st queen in safest position
   * - in the second coloumn check for the safest row to place a queen, so that the 1st queen will not be able attack
   * - continue placing queen till we complete n coloumns
   * 
   * Hint: we know queen can attack in all 8 directions, but while placing queen in any coloumn, 
   *      we just need to check for the left 3 directions, 'LEFT', 'TOP LEFT' AND 'BOTTOM LEFT', since on the right side coloumns we are yet to place a queen
   */

  public static void placeNQueens(int n){
    //create a board and prefill with empty space '.'
    char board[][] = new char[n][n];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        board[i][j] = '.';
      }
    }

    placeQueenRec(n, board, 0);
  }

  private static void placeQueenRec(int n, char[][] board, int col){
    if(col == n){
      printBoard(n, board);
      System.out.println("-------------");
      return;
    }

    for(int row=0; row<n; row++){
      if(isSafe(board, n, row, col)){
        board[row][col] = 'Q';
        placeQueenRec(n, board, col+1);
        board[row][col] = '.';
      }
    }
    
  }



  private static boolean isSafe(char[][] board, int n, int row, int col){
    //check in the same row if any other queen placed
    int dupCol, dupRow;

    dupCol = col;
    while(dupCol>=0){
      if(board[row][dupCol] == 'Q'){
        return false;
      }
      dupCol--;
    }

    //check in upper left diaganal, if any queen is placed
    dupRow=row;
    dupCol=col;
    while(dupRow>=0 && dupCol>=0){
      if(board[dupRow][dupCol] == 'Q'){
        return false;
      }
      dupRow--;
      dupCol--;
    }

    //check in bottom left diaganal, if any queen is placed
    dupRow=row;
    dupCol=col;
    while(dupRow<n && dupCol>=0){
      if(board[dupRow][dupCol] == 'Q'){
        return false;
      }
      dupRow++;
      dupCol--;
    }

    return true;
  }

  private static void printBoard(int n, char[][] board){
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        System.out.print(board[i][j]+" ");
      }
      System.out.println("");
    }
  }
}
