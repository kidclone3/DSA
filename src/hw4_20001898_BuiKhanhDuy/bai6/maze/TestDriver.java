package hw4_20001898_BuiKhanhDuy.bai6.maze;

public class TestDriver {
  public static void main(String[] args) throws Exception {
    int[][] maze = {
//      {1, 1, 0, 1, 0, 0, 1, 1},
//      {1, 1, 0, 0, 0, 1, 0, 0}, // 1 -> blocked (wall)
//      {0, 0, 1, 0, 1, 1, 0, 1}, // 0 -> unvisited position
//      {1, 0, 0, 0, 0, 1, 0, 1},
//      {1, 1, 1, 1, 0, 0, 0, 1}, // start point [2][0]
//      {0, 0, 0, 0, 0, 1, 0, 0}, // goal point [5][7]
//      {1, 1, 0, 1, 0, 1, 1, 1},
//      {1, 0, 0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };
    Point start = new Point(0, 0);
    Point end = new Point(3, 3);
    MazeSolver mazeSolver= new MazeSolver(maze, start, end);
    mazeSolver.dfs();
    System.out.println(mazeSolver.finished());
  }
}