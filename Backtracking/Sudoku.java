package Backtracking;
/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells. 
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 1. Each of the digits 1-9 must occur exactly once in each row.
 * 2. Each of the digits 1-9 must occur exactly once in each column.
 * 3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public class Sudoku {
  public static void main(String[] args) {
    char board[][] = {
      {'5','3','.','.','7','.','.','.','.'},
      {'6','.','.','1','9','5','.','.','.'},
      {'.','9','8','.','.','.','.','6','.'},
      {'8','.','.','.','6','.','.','.','3'},
      {'4','.','.','8','.','3','.','.','1'},
      {'7','.','.','.','2','.','.','.','6'},
      {'.','6','.','.','.','.','2','8','.'},
      {'.','.','.','4','1','9','.','.','5'},
      {'.','.','.','.','8','.','.','7','9'}
    };
    int n = board.length;

    solveSudokuBacktrack(board, n);

    System.out.println((char)(2+'0'));

    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        System.out.print(board[i][j]+" ");
      }
      System.out.println("");
    }
  }
/*
 * Approach: 
 * - Find the first unfilled box, from top left
 * - Fill the appropriate value, and call this rec function
 * - Next recursive call, find the next unfilled box using nexted for loop
 * - Continue this untill all boxes are filled with proper values
 */
  public static boolean solveSudokuBacktrack(char[][] board, int n){
    int row = -1;
    int col = -1;
    boolean isEmpty = false;
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(board[i][j] == '.'){
          row = i;
          col = j;
          isEmpty = true;
          break;
        }
      }
      if(isEmpty){
        break;
      }
    }

    if(!isEmpty){
      return true;
    }

    for(int value = 1; value<=n; value++){
      if(isSafe(board, n, row, col, (char)(value+'0'))){
        board[row][col] = (char)(value+'0');
        if(solveSudokuBacktrack(board, n)){
          return true;
        } else {
           board[row][col] = '.';
        }
      }
    }
    return false;
  }

  private static boolean isSafe(char[][] board, int n, int row, int col, char value){
    //check for row
    for(int i=0; i<n; i++){
      if(board[row][i] == value){
        return false;
      }
    }

    //check for col
    for(int i=0; i<n; i++){
      if(board[i][col] == value){
        return false;
      }
    }

    //check in smaller matrix
    int sqrt = (int)Math.sqrt(n);

    int minRow = row - (row%sqrt);
    int minCol = col - (col%sqrt);

    int maxRow = minRow + sqrt;
    int maxCol = minCol + sqrt;

    for(int i=minRow; i<maxRow; i++){
      for(int j=minCol; j<maxCol; j++){
        if(board[i][j] == value){
          return false;
        }
      }
    }

    return true;
  }


  /*
   * Approach 2: start with 0,0 cell and keep on filling empty cells, which backtracking
   * 
   * -----MY CODE-----
   */

  void sudokuSolver(char[][] sudoku) {
    int n = 9;
    solveSudokuRec(sudoku, n, 0, 0);
  }

  boolean solveSudokuRec(char[][] sudoku, int n, int row, int col){
    if(row >= n){
      return true;
    }
    
    int nextCol = (col+1) % 9;
    int nextRow = nextCol == 0 ? row+1 : row ; 
        // System.out.println("nextRow: "+nextRow+", nextCol: "+nextCol);
    
    if(sudoku[row][col] == '.'){
      for(int i=1; i<=9; i++){
        if(isSafe(sudoku, n, row, col, (char)(i + '0'))){
          sudoku[row][col] = (char)(i + '0');
          if(solveSudokuRec(sudoku, n, nextRow, nextCol)){
            return true;
          } else {
            sudoku[row][col] = '.';
          }
        }
      }
      return false;
    } else {
      if(solveSudokuRec(sudoku, n, nextRow, nextCol)){
        return true;
      }
      return false;
    }
  }
}
