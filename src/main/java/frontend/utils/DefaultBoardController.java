package frontend.utils;

import exceptions.BoardWithoutZeroException;
import frontend.interfaces.BoardController;
import frontend.interfaces.Game;
import frontend.interfaces.ImageLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

public class DefaultBoardController implements BoardController {

    public static final int DEFAULT_COLUMNS_AMOUNT = 4;
    public static final int DEFAULT_ROW_AMOUNT = 4;
    Board board;
    ImageLoader imageLoader;
    Board arrangedBoard;
    int tileWidth;
    int tileHeight;
    private JPanel drawingPanel;
    private Game game;

    public DefaultBoardController(JPanel drawingPanel) {
        board = BoardUtils.buildArrangedBoard(DEFAULT_ROW_AMOUNT, DEFAULT_COLUMNS_AMOUNT);
        this.drawingPanel = drawingPanel;
        this.arrangedBoard = BoardUtils.buildArrangedBoard(DEFAULT_ROW_AMOUNT, DEFAULT_COLUMNS_AMOUNT);
    }

    public DefaultBoardController(JPanel drawingPanel, Board board) {
        this.board = board;
        this.drawingPanel = drawingPanel;
        this.arrangedBoard = BoardUtils.buildArrangedBoard(board.getState().length, board.getState()[0].length);
    }

    @Override
    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Override
    public JPanel createBoardOnWindow() {
        drawingPanel.removeAll();
        createTiles(drawingPanel);
        drawingPanel.repaint();
        drawingPanel.revalidate();

        return drawingPanel;
    }

    @Override
    public void createTiles(JPanel drawingPanel) {
        tileWidth = calculateTileSize(board.getState()[0].length, drawingPanel.getWidth());
        tileHeight = calculateTileSize(board.getState().length, drawingPanel.getHeight());

        for (int i = 0; i < board.getState().length; i++) {
            for (int j = 0; j < board.getState()[0].length; j++) {
                if (board.getState()[i][j] != 0) {
                    if (imageLoader != null) {
                        drawingPanel.add(createImageTile(j, i));
                    } else {
                        drawingPanel.add(createNewTile(j, i));
                    }

                }
            }
        }
    }

    @Override
    public void move(int tile) {
        try {
            board = board.move(tile);
            boardChanged();
        } catch (BoardWithoutZeroException ex) {
        }
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
        this.arrangedBoard = BoardUtils.buildArrangedBoard(board.getState().length, board.getState()[0].length);

    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void boardChanged() {
        if (game != null && board.isCorrect()) {
            game.endGame();
        }
    }

    private class TileActionListener implements ActionListener {

        int numberOfTile;

        public TileActionListener(int numberOfTile) {
            this.numberOfTile = numberOfTile;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            move(numberOfTile);
            createBoardOnWindow();
        }
    }

    protected JButton createNewTile(int cordX, int cordY) {
        JButton tile = new JButton("" + board.getState()[cordY][cordX]);
        tile.addActionListener(new TileActionListener(board.getState()[cordY][cordX]));
        tile.setBounds(cordX * tileWidth, cordY * tileHeight, tileWidth, tileHeight);
        tile.setVisible(true);
        return tile;
    }

    protected JButton createImageTile(int coordX, int coordY) {

        int[] tileCoords = arrangedBoard.findNumber(board.getState()[coordY][coordX]);
        JButton tile = imageLoader.getPartOfImage(tileCoords[1] * tileWidth, tileCoords[0] * tileHeight, tileWidth, tileHeight);
        tile.addActionListener(new TileActionListener(board.getState()[coordY][coordX]));
        tile.setBounds(coordX * tileWidth, coordY * tileHeight, tileWidth, tileHeight);
        tile.setVisible(true);
        return tile;
    }

    protected static int calculateTileSize(int tileAmount, int panelSize) {
        return panelSize / tileAmount;
    }
}
