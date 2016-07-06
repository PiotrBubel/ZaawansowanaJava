package frontend.utils;

import exceptions.BoardWithoutZeroException;
import javax.swing.JButton;
import javax.swing.JPanel;
import npuzzle.Board;

public class AnimatorBoardController extends DefaultBoardController {

    private String pathToWin;

    public AnimatorBoardController(JPanel drawingPanel, Board board, String pathToWin) {
        super(drawingPanel, board);
        this.pathToWin = pathToWin;
    }

    @Override
    public void move(int numberOfMove) {
        try {
            board = board.move(pathToWin.charAt(numberOfMove));

        } catch (BoardWithoutZeroException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected JButton createNewTile(int cordX, int cordY) {
        JButton tile = new JButton("" + board.getState()[cordY][cordX]);
        tile.setBounds(cordX * tileWidth, cordY * tileHeight, tileWidth, tileHeight);
        tile.setVisible(true);
        return tile;
    }

    @Override
    protected JButton createImageTile(int coordX, int coordY) {

        int[] tileCoords = arrangedBoard.findNumber(board.getState()[coordY][coordX]);
        JButton tile = imageLoader.getPartOfImage(tileCoords[1] * tileWidth, tileCoords[0] * tileHeight, tileWidth, tileHeight);
        tile.setBounds(coordX * tileWidth, coordY * tileHeight, tileWidth, tileHeight);
        tile.setVisible(true);
        return tile;
    }
}
