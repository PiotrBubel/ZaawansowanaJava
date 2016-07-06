package autosolving.solvers;

import org.junit.Test;

import autosolving.solvers.algorithms.DepthFirstSearch;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 * @author Piotrek
 */
public class DepthFirstSearchTest {

    private Board instance;
    private int[][] state;
    private PuzzleSolver solver;


    /**
     * Test of solve method, of class DepthFirstSearch.
     */
    @Test
    public void shouldSolveSimpleBoard() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch();
        Board solved = solver.solve(instance);
        assertTrue(solved.isCorrect());
    }

    /**
     * Test of solve method, of class DepthFirstSearch.
     */
    @Test
    public void shouldSolveBoard() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {0, 2, 3, 4},
                {1, 6, 7, 8},
                {5, 10, 11, 12},
                {9, 13, 14, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch();
        Board solved = solver.solve(instance);
        assertTrue(solved.isCorrect());
    }

    /**
     * Test of solve method, of class DepthFirstSearch.
     */
    @Test(expected = BoardWithoutZeroException.class)
    public void shouldThrowBoardWithoutZeroException() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 16, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch();
        solver.solve(instance);
    }

    /**
     * Test of solve method, of class DepthFirstSearch.
     */
    @Test(expected = UnsolvableBoardException.class)
    public void shouldThrowUnsolvableBoardException() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 11, 12},
                {13, 14, 16, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch();
        solver.solve(instance);
    }

    /**
     * Test of getTimeInNanos method, of class DepthFirstSearch.
     */
    @Test
    public void nanoTimeShouldBePositiveNonZeroValue() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch();
        solver.solve(instance);
        long time = solver.getTimeInNanos();
        assertTrue(time > 0);
    }

    /**
     * Test of getTimeInMillis method, of class DepthFirstSearch.
     */
    @Test
    public void milliTimeShouldBePositiveNonZeroValue() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch();
        solver.solve(instance);
        double time = solver.getTimeInMillis();
        assertTrue(time > 0d);
    }

    /**
     * Test of solve method, of class DepthFirstSearch.
     */
    @Test
    public void shouldReturnNullWhenTooLowDepthGiven() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {0, 10, 11, 12},
                {9, 13, 14, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch(1);
        Board solved = solver.solve(instance);
        assertNull(solved);
    }
}
