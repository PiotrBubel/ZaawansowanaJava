package frontend.animator;

import frontend.contextMenu.ContextMenuListener;
import frontend.interfaces.BoardController;
import frontend.utils.AnimatorBoardController;
import frontend.utils.DefaultImageLoader;
import javax.swing.JPanel;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

public class Animator {

    private String pathToWin;
    private Board startingBoard;
    private int move = 0;

    private BoardController puzzleBoard;

    public Animator(JPanel puzzlePanel, Board board, String pathToWin) {
        this.startingBoard = BoardUtils.getStartingBoard(board);
        puzzleBoard = new AnimatorBoardController(puzzlePanel, new Board(startingBoard), pathToWin);
        puzzleBoard.setImageLoader(null);
        this.pathToWin = pathToWin;
        this.puzzleBoard.createBoardOnWindow();
    }

    public boolean previousMove() {
        if (move > 0 && !pathToWin.isEmpty()) {
            move--;
            puzzleBoard.setBoard(startingBoard);
            for (int i = 0; i < move; i++) {
                puzzleBoard.move(i);
            }
            puzzleBoard.createBoardOnWindow();
            return true;
        }
        return false;
    }

    public ContextMenuListener getContextMenu(int widthOfPanel, int hegithOfPanel) {
        return new ContextMenuListener(new DefaultImageLoader(widthOfPanel, hegithOfPanel), puzzleBoard);
    }

    public boolean nextMove() {
        if (move < pathToWin.length() && !pathToWin.isEmpty()) {
            puzzleBoard.move(move);
            move++;
            puzzleBoard.createBoardOnWindow();
            return true;
        }
        return false;
    }

    public void resetMoves() {
        move = 0;
        if (!pathToWin.isEmpty()) {
            puzzleBoard.setBoard(startingBoard);
            puzzleBoard.createBoardOnWindow();
        }
    }
}
