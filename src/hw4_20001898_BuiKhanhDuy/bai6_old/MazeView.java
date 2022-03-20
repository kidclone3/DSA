package hw4_20001898_BuiKhanhDuy.bai6_old;

import hw4_20001898_BuiKhanhDuy.bai2.LinkedListStack;

import javax.swing.*;
import java.awt.*;

public class MazeView extends JFrame {
  private final int[][] maze = {
//    {0, 0, 1, 0, 1, 1, 0, 0},
//    {0, 0, 1, 1, 1, 0, 1, 1}, // 0 -> blocked (wall)
//    {1, 1, 0, 1, 0, 0, 1, 0}, // 1 -> unvisited position
//    {0, 1, 1, 1, 1, 0, 1, 0}, // 2 -> visited position
//    {0, 0, 0, 0, 1, 1, 1, 0}, // start point [2][0]
//    {1, 1, 1, 1, 1, 0, 1, 1}, // goal point [5][7]
//    {0, 0, 1, 0, 1, 0, 0, 0},
//    {0, 1, 1, 0, 1, 0, 0, 0},
          {1, 1, 1, 1, 1, 1, 1, 1},
          {1, 1, 1, 1, 1, 1, 1, 1},
          {1, 1, 1, 1, 1, 1, 1, 1},
          {1, 1, 1, 1, 1, 1, 1, 1},
          {1, 1, 1, 1, 1, 1, 1, 1},
          {1, 1, 1, 1, 1, 1, 1, 1},
          {1, 1, 1, 1, 1, 1, 1, 1},
          {1, 1, 1, 1, 1, 1, 1, 1}
  };

  private final LinkedListStack<Position> path = new LinkedListStack<>();

  public MazeView() {
    setSize(500, 500); // set Frame view size to 500 * 500
    setLocationRelativeTo(null); // set Frame view position to the center of your computer screen
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MazeSolver.findPath(maze, path);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    // create graphic for the game
    for (int row = 0; row < maze.length; row++) {
      for (int col = 0; col < maze[0].length; col++) {
        Color color;
        // base on the position's value to choose its color
        switch (maze[row][col]) {
          case 0:
            color = Color.black;
            break;
          case -1:
            color = Color.yellow;
            break;
          case 3:
            color = Color.green;
            break;
          default:
            color = Color.white;
        }
        g.setColor(color);

        /*  fill the position with chosen color
           each position has a size of 50 x 50
           and starting coordinate at (x,y) = (50 * (col + 1), 50 * (row + 1))
        */
        g.fillRect(50 * (col + 1), 50 * (row + 1), 50, 50);
      }
    }

    // draw the path
    while (!path.isEmpty()) {
      int pathX = path.top().getCol();
      int pathY = path.top().getRow();
      System.out.println(pathX + " " + pathY);
      g.setColor(Color.orange);
      g.fillRect(50 * (pathX + 1), 50 * (pathY + 1), 50, 50);
      path.pop();
    }
  }

  public void test() {
    for (int i = 0; i < maze.length; ++i) {
      for (int j = 0; j < maze[0].length; j++) {
        System.out.print(maze[i][j] + ' ');
      }
      System.out.println();
    }
  }
}
