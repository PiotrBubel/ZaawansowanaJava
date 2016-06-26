package frontend.utils;

import frontend.interfaces.BoardController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import npuzzle.Board;

public class DefaultBoardController implements BoardController {

    private Board board;
    private int tileWidth;
    private int tileHeight;
    private JPanel drawingPanel;

    public DefaultBoardController(JPanel drawingPanel) {
        board = createDefaultBoard();
        this.drawingPanel = drawingPanel;
    }

    @Override
    public JPanel createBoardOnWindow() {
        drawingPanel.removeAll();
        int[][] state = board.getState();
        createTiles(drawingPanel, state);
        drawingPanel.repaint();
        drawingPanel.revalidate();

        return drawingPanel;
    }

    @Override
    public void createTiles(JPanel drawingPanel, int[][] state) {
        tileWidth = calculateTileSize(state[0].length, drawingPanel.getWidth());
        tileHeight = calculateTileSize(state[0].length, drawingPanel.getHeight());

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (state[i][j] != 0) {
                    drawingPanel.add(createNewTile(state[i][j], j, i));
                }
            }
        }
    }

    public class TileActionListener implements ActionListener {

        int numberOfTile;

        public TileActionListener(int numberOfTile) {
            this.numberOfTile = numberOfTile;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
    }

    private JButton createNewTile(int numberOfTile, int cordX, int cordY) {
        JButton tile = new JButton("" + numberOfTile);
        tile.addActionListener(new TileActionListener(numberOfTile));
        tile.setBounds(cordX * tileWidth, cordY * tileHeight, tileWidth, tileHeight);
        tile.setVisible(true);
        return tile;
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

    public static int calculateTileSize(int tileAmount, int panelSize) {
        return panelSize / tileAmount;
    }
}
