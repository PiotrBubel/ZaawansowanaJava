package frontend.animator;

import frontend.contextMenu.ContextMenuListener;
import frontend.interfaces.BoardController;
import frontend.utils.AnimatorBoardController;
import frontend.utils.DefaultImageLoader;
import javax.swing.JPanel;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

class Animator {

    private String pathToWin;
    private Board startingBoard;
    private int move = 0;

    private BoardController puzzleBoard;

    Animator(JPanel puzzlePanel, Board endBoardState, String pathToWin) {
        this.startingBoard = BoardUtils.getStartingBoard(endBoardState, pathToWin);
        puzzleBoard = new AnimatorBoardController(puzzlePanel, new Board(startingBoard), pathToWin);
        puzzleBoard.setImageLoader(null);
        this.pathToWin = pathToWin;
        this.puzzleBoard.createBoardOnWindow();
    }

    Animator(BoardController puzzleBoard, Board board, String pathToWin) {
        this.startingBoard = BoardUtils.getStartingBoard(board, pathToWin);
        this.puzzleBoard = puzzleBoard;
        this.pathToWin = pathToWin;
        this.puzzleBoard.createBoardOnWindow();
    }

    boolean previousMove() {
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

    ContextMenuListener getContextMenu(int widthOfPanel, int hegithOfPanel) {
        return new ContextMenuListener(new DefaultImageLoader(widthOfPanel, hegithOfPanel), puzzleBoard);
    }

    boolean nextMove() {
        if (move < pathToWin.length() && !pathToWin.isEmpty()) {
            puzzleBoard.move(move);
            move++;
            puzzleBoard.createBoardOnWindow();
            return true;
        }
        return false;
    }

    boolean resetMoves() {
        move = 0;
        if (!pathToWin.isEmpty()) {
            puzzleBoard.setBoard(startingBoard);
            puzzleBoard.createBoardOnWindow();
            return true;
        }
        return false;
    }
}
