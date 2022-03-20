package hw4_20001898_BuiKhanhDuy.bai6.maze;

public class Point {
    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    Point(int[] coors) {
      x = coors[0];
      y = coors[1];
    }
    boolean equal(Point another) {
        return x == another.x && y == another.y;
    }
  }
