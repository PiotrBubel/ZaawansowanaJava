package frontend.utils;

import frontend.interfaces.ImageLoader;
import javax.swing.JButton;
import javax.swing.JPanel;
import npuzzle.Board;

public class BoardWithImageController extends DefaultBoardController {

    private ImageLoader imageLoader;
    private Board arrangedBoard;

    public BoardWithImageController(JPanel drawingPanel, ImageLoader imageLoader) {
        super(drawingPanel);
        this.arrangedBoard = new Board(board);
        this.imageLoader = imageLoader;
    }

    @Override
    protected JButton createNewTile(int coordX, int coordY) {

        int[] tileCoords = arrangedBoard.findNumber(board.getState()[coordY][coordX]);
        JButton tile = imageLoader.getPartOfImage(tileCoords[1] * tileWidth, tileCoords[0] * tileHeight, tileWidth, tileHeight);
        tile.addActionListener(new TileActionListener(board.getState()[coordY][coordX]));
        tile.setBounds(coordX * tileWidth, coordY * tileHeight, tileWidth, tileHeight);
        tile.setVisible(true);
        return tile;
    }

}
