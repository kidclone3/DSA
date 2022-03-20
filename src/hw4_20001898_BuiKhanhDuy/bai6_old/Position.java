package hw4_20001898_BuiKhanhDuy.bai6_old;

public class Position {
    private int row;
    private int col;
    enum Direction {Right, Left, Up, Down, NoDir}

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Direction getUnvisitedDir(int[][] maze) {
        if (col + 1 < maze.length) {
            if (maze[row][col + 1] == 1)
                return Direction.Right;
        }

        if (col - 1 >= 0) {
            if (maze[row][col - 1] == 1)
                return Direction.Left;
        }

        if (row - 1 >= 0) {
            if (maze[row - 1][col] == 1)
                return Direction.Up;
        }

        if (row + 1 < maze.length) {
            if (maze[row + 1][col] == 1)
                return Direction.Down;
        }

        return Direction.NoDir;
    }

    public Position move(Direction newDir) {
        switch (newDir) {
            case Right:
                return new Position(row, col + 1);
            case Left:
                return new Position(row, col - 1);
            case Up:
                return new Position(row - 1, col);
            default:
                return new Position(row + 1, col);
        }
    }
}
