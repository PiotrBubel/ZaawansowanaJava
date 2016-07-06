package frontend.animator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frontend.interfaces.BoardController;
import npuzzle.Board;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AnimatorTest {

    private Board board;
    private Animator animator;
    private BoardController controller;

    @Before
    public void setUp() {
        controller = mock(BoardController.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPreviousMoveBoardWithoutMoves() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        board = new Board(state);
        String path = "";
        animator = new Animator(controller, board, path);

        boolean expResult = false;
        boolean result = animator.previousMove();
        assertEquals(expResult, result);
    }

    @Test
    public void testPreviousMoveBoardWithMoves() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        board = new Board(state);
        String path = "d";
        animator = new Animator(controller, board, path);
        animator.nextMove();

        boolean expResult = true;
        boolean result = animator.previousMove();
        assertEquals(expResult, result);
    }

    @Test
    public void testNextMoveBoardWithoutMoves() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        board = new Board(state);
        String path = "";
        animator = new Animator(controller, board, path);

        boolean expResult = false;
        boolean result = animator.nextMove();
        assertEquals(expResult, result);
    }

    @Test
    public void testNextMoveBoardWithMoves() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        board = new Board(state);
        String path = "d";
        animator = new Animator(controller, board, path);

        boolean expResult = true;
        boolean result = animator.nextMove();
        assertEquals(expResult, result);
    }

    @Test
    public void testResetBoardWithoutMoves() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        board = new Board(state);
        String path = "";
        animator = new Animator(controller, board, path);

        boolean expResult = false;
        boolean result = animator.resetMoves();
        assertEquals(expResult, result);
    }

    @Test
    public void testResetBoardWithMoves() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        board = new Board(state);
        String path = "d";
        animator = new Animator(controller, board, path);
        animator.nextMove();
        boolean expResult = true;
        boolean result = animator.resetMoves();
        assertEquals(expResult, result);
    }
}
