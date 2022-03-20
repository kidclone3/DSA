package hw4_20001898_BuiKhanhDuy.bai6_old;

import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MazeView mazeView = new MazeView();
            mazeView.setVisible(true);
        });

        MazeView mazeView = new MazeView();
        mazeView.test();
    }
}
