package frontend.interfaces;

import javax.swing.JPanel;

public interface BoardController {

    JPanel createBoardOnWindow();

    void createTiles(JPanel drawingPanel, int[][] state);

    void move(int numberOfTile);
}
