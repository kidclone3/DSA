package hw4_20001898_BuiKhanhDuy.bai6.maze;

import javax.swing.*;
import java.awt.*;

public class Graph {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MazePanel mp = new MazePanel();
    frame.add(mp);
    frame.setVisible(true);
  }

  public static class MazePanel extends JPanel // need a JPanel for Graphics
  {
    private int[][] maze = { // initialize the maze 2D array
      //      {0, 0, 1, 0, 1, 1, 0, 0},
      //      {0, 0, 1, 1, 1, 0, 1, 1}, // 0 -> blocked (wall)
      //      {1, 1, 0, 1, 0, 0, 1, 0}, // 1 -> unvisited position
      //      {0, 1, 1, 1, 1, 0, 1, 0}, // 2 -> visited position
      //      {0, 0, 0, 0, 1, 1, 1, 0}, // start point [2][0]
      //      {1, 1, 1, 1, 1, 0, 1, 1}, // goal point [5][7]
      //      {0, 0, 1, 0, 1, 0, 0, 0},
      //      {0, 1, 1, 0, 1, 0, 0, 0}
      //      {1, 1, 0, 1, 0, 0, 1, 1},
      //      {1, 1, 0, 0, 0, 1, 0, 0}, // 1 -> blocked (wall)
      //      {0, 0, 1, 0, 1, 1, 0, 1}, // 0 -> unvisited position
      //      {1, 0, 0, 0, 0, 1, 0, 1}, // 0 -> visited position
      //      {1, 1, 1, 1, 0, 0, 0, 1}, // start point [0][1]
      //      {0, 0, 0, 0, 0, 1, 0, 0}, // goal point [5][7]
      //      {1, 1, 0, 1, 0, 1, 1, 1},
      //      {1, 0, 0, 1, 0, 1, 1, 1}
      //    };
      //    //    private int size, start, end;				// start and end are used in paintComponent to
      // denote the
      //    // starting point in a different color
      //    Point start = new Point(2, 0);
      //    Point end = new Point(5, 7);
      {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}
    };
    Point start = new Point(0, 0);
    Point end = new Point(3, 3);
    MazeSolver mazeSolver = new MazeSolver(maze, start, end);

    public MazePanel() {
      //      size=24;								// size of rows/columns of the maze
      //      start=0;
      //      end=5;
      //      solve(maze,start,end,size);				// start the recursive call starting at coordinate 0,5,
      // use size to ensure that we don't go beyond the bounds of the array
      repaint(); // invoke paintComponent to output the final maze
    }

    public void paintComponent(Graphics g) // draw the maze with solution
        {
      super.paintComponent(g);
      try {
        mazeSolver.dfs();
      } catch (Exception e) {
        e.printStackTrace();
      }
      mazeSolver.printPath();
      for (int j = 0; j < mazeSolver.width; j++) // iterate through all i,j locations in the maze
      for (int i = 0; i < mazeSolver.height; i++) {
          //          if (i == start && j == end) g.setColor(Color.yellow); // starting point in
          // yellow
          if (mazeSolver.maze[i][j] == 0) g.setColor(Color.white); // walls are white
          else if (mazeSolver.maze[i][j] == 1) g.setColor(Color.black); // path is black
          else if (maze[i][j] == 2) g.setColor(Color.red); // ending point is red
          //          else g.setColor(Color.blue); // solution is blue
          g.fillRect(
              i * 20, j * 20, 20, 20); // draw each part of the maze using the above set color
        }
    }
  }
}
