package frontend.utils;

import frontend.interfaces.BoardController;
import javax.swing.JButton;
import javax.swing.JPanel;
import npuzzle.Board;

public class DefaultBoardController implements BoardController {

    private Board board;

    public DefaultBoardController() {
        board=createDefaultBoard();
    }

    @Override
    public JPanel createBoardOnWindow(JPanel drawingPanel) {
        drawingPanel.removeAll();
        int[][] state = board.getState();
        createTiles(drawingPanel, state);
        drawingPanel.repaint();
        drawingPanel.revalidate();

        return drawingPanel;
    }

    @Override
    public int calculateTileSize(int tileAmount, int panelSize) {
        return panelSize / tileAmount;
    }

    @Override
    public void createTiles(JPanel drawingPanel, int[][] state) {
        int tileWidth = calculateTileSize(state[0].length, drawingPanel.getWidth());
        int tileHeight = calculateTileSize(state[0].length, drawingPanel.getHeight());

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (state[i][j] != 0) {
                    JButton tile = new JButton("" + state[i][j]);
                    tile.setBounds(j * tileWidth, i * tileHeight, tileWidth, tileHeight);
                    tile.setVisible(true);
                    drawingPanel.add(tile);
                }
            }
        }
    }

    public static Board createDefaultBoard() {
        int[][] state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };
        return new Board(state);
    }
}
