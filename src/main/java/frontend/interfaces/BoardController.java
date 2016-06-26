package frontend.interfaces;

import javax.swing.JPanel;

public interface BoardController {

    JPanel createBoardOnWindow(JPanel drawingPanel);

    int calculateTileSize(int tileAmount, int panelSize);

    void createTiles(JPanel drawingPanel, int[][] state);

  //  Board createDefaultBoard();
}
