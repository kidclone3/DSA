package hw4_20001898_BuiKhanhDuy.bai6.maze;

import hw4_20001898_BuiKhanhDuy.bai2.LinkedListStack;

public class MazeSolver {
  // Matrix look like:
  //        {{1, 0, 0, 1},
  //        {0, 0, 1, 0},
  //        {1, 0, 1, 1},
  //        {0, 0, 0, 0}}
  final int[][] maze;
  final int width;
  final int height;
  boolean[][] visited;
  Point[][] parent; // Save parent position for trace the path (when dfs finish).
  // SOS: x is the row, y is the col, not like descartes coordinates.
  // This is java 2D array.

  Point start, end;

  // 4 directions
  final int[] dx = {1, 0, -1, 0};
  final int[] dy = {0, 1, 0, -1};

  public MazeSolver(int[][] maze, Point start, Point end) {
    // Need to input maze from keyboard or file or ...
    this.maze = maze;
    this.start = start;
    this.end = end;

    width = maze[0].length; // chiều rộng
    height = maze.length; // chieu cao
    visited = new boolean[height][width];
    parent = new Point[height][width];
  }
  // Use Stack for solving this maze.
  // Another name for this algorithm is DFS - Depth First Search
  private boolean accessible(int x, int y) {
    return 0 <= x && x < height && 0 <= y && y < width && maze[x][y] == 0 && !visited[x][y];
  }

  public void printPath() {
    Point current = end;
    while (!parent[current.x][current.y].equal(new Point(-1, -1))) {
//      System.out.print("(" + current.x + ", " + current.y + "); ");
      maze[current.x][current.y] = 2;
      current = parent[current.x][current.y];

    }
    System.out.println();
  }

  public void dfs() throws Exception {
    // Need an array to mark the visited points.
    // We use visited[][]
    LinkedListStack<Point> stack = new LinkedListStack<>();
    parent[start.x][start.y] = new Point(-1, -1);
    stack.push(start);
    visited[start.x][start.y] = true;
    while (!stack.isEmpty()) {
      Point current = stack.pop();
      if (current.equal(end)) {
        stack.push(current);
        printPath();
        return;
      }
      for (int i = 0; i < 4; i++) {
        // Access to neighbour point.
        int x = current.x + dx[i];
        int y = current.y + dy[i];
        Point temp = new Point(x, y);
        if (accessible(x, y)) {
          if (parent[x][y] == null) parent[x][y] = current;
          stack.push(temp);
          visited[x][y] = true;
        }
      }
    }
  }

  public boolean finished() {
    return visited[end.x][end.y];
  }
}
