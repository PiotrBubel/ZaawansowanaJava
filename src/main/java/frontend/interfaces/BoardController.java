package frontend.interfaces;

import javax.swing.JPanel;

public interface BoardController {

    JPanel createBoardOnWindow(JPanel drawingPanel);

    void createTiles(JPanel drawingPanel, int[][] state);

}
