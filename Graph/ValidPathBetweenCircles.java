package Graph;

import java.util.LinkedList;
import java.util.Queue;
/*
 * Note: current code is not working for all testcases, need to fix it whenever possible
 * link: https://www.interviewbit.com/problems/valid-path/
 */
public class ValidPathBetweenCircles {
  static int adjX[] = {0, 1, 0, -1};
	static int adjY[] = {1, 0, -1, 0};
	
	static int dirX[] = {0, 1, 0, -1, 1, 1, -1, -1};
	static int dirY[] = {1, 0, -1, 0, 1, -1, 1, -1};
	
	static class Point {
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

  static class Circle {
    public int x, y; // Co-ordinates of center
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }
  }

  public static void main(String[] args) {
    int n = 47;
    int m = 26;
    int r = 8;

    // int points[][] = {{0, 2}, {2, 3}, {3, 0}, {4, 1}};
    // int points[][] = {{17, 52}, {16, 61}, {12, 61}, {0, 25}, {40, 31}};
    int points[][] = {{45, 17}, {40, 1}};

    Circle circles[] = new Circle[points.length];
    for(int i=0; i<points.length; i++){
      circles[i] = new Circle(points[i][0], points[i][1]);
    }

    System.out.println(hasValidPath(n, m, r, circles)); 
  }

	static boolean hasValidPath(int n, int m, int r, Circle[] circles) {
    if(n == 0 || m == 0){
      return false;
    }
    int insideCircle[][] = new int[n+1][m+1];

    for(int i=0; i<=n; i++){
      for(int j=0; j<=m; j++){
        for(int k=0; k<circles.length; k++){

          boolean isInside = Math.pow(i-circles[k].x, 2) + Math.pow(j-circles[k].y, 2) <= r*r;
          if(isInside){
            insideCircle[i][j] = 1;
            break;
          }

        }
      }
    }    
		
		//check for initial and final points exists inside circle
		if(insideCircle[0][0] == 1){
			return false;
		}
		
		//find a path using bfs
		return traverseBFS(n, m, insideCircle, 0, 0);
	}
	
	static boolean traverseBFS(int n, int m, int insideCircle[][], int x, int y){
    int visited[][] = new int[n][m];

    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y));
		visited[x][y] = 1;
		
    while(queue.isEmpty()){
      Point point = queue.remove();
      if(point.x == n && point.y == m){
        return true;
      }
      //check for 8 direction points
      for(int k=0; k<8; k++){
        int nextX = point.x + dirX[k];
        int nextY = point.y + dirY[k];
        
        if(isValid(n, m, nextX, nextY) && visited[nextX][nextY] == 0 && insideCircle[nextX][nextY] == 0){
          visited[nextX][nextY] = 1;
          queue.add(new Point(x, y));
        }
      }
    }
		
		return false;
	}
	
	static boolean isValid(int n, int m, int x, int y){
		if(x >= 0 && y >= 0 & x<n && y<m){
			return true;
		}
		return false;
	}
}
