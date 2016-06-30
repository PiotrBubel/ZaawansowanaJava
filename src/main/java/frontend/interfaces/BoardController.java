package frontend.interfaces;

import javax.swing.JPanel;
import npuzzle.Board;

public interface BoardController extends GameListener {

    JPanel createBoardOnWindow();

    public void setImageLoader(ImageLoader imageLoader);

    void createTiles(JPanel drawingPanel);

    void move(int tileMove);

    Board getBoard();

    void setBoard(Board board);
}
