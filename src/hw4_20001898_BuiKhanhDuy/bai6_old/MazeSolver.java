package hw4_20001898_BuiKhanhDuy.bai6_old;

import hw4_20001898_BuiKhanhDuy.bai2.LinkedListStack;

public class MazeSolver {

    public static void findPath(int[][] maze, LinkedListStack<Position> path) {
        boolean done = false;
        path.push(new Position(2, 0));
        while (!path.isEmpty() && !done) {
            Position current = path.top();
            Position.Direction newDir = current.getUnvisitedDir(maze);

            if (newDir == Position.Direction.NoDir)
                path.pop();
            else {
                Position newPosition = current.move(newDir);
                maze[newPosition.getRow()][newPosition.getCol()] = 2;
                path.push(newPosition);
                if (newPosition.getRow() == 5 && newPosition.getCol() == 7)
                    done = true;
            }
        }
    }
}
