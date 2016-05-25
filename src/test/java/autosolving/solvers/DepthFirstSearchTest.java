package autosolving.solvers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

    Board instance;
    int[][] state;
    PuzzleSolver solver;

    public DepthFirstSearchTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

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
     * Test of getTimeInMilis method, of class DepthFirstSearch.
     */
    @Test
    public void miliTimeShouldBePositiveNonZeroValue() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        solver = new DepthFirstSearch();
        solver.solve(instance);
        double time = solver.getTimeInMilis();
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