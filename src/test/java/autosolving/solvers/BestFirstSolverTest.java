package autosolving.solvers;

import org.junit.Test;

import autosolving.heuristics.AMisplacedComparator;
import autosolving.heuristics.MisplacedComparator;
import autosolving.solvers.algorithms.BestFirstSearch;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 * @author Piotrek
 */
public class BestFirstSolverTest {

    private Board instance;
    private int[][] state;
    private PuzzleSolver solver;


    /**
     * Test of solve method, of class BestFirstSearch.
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
        solver = new BestFirstSearch(new MisplacedComparator());
        Board solved = solver.solve(instance);
        assertTrue(solved.isCorrect());
    }

    /**
     * Test of solve method, of class BestFirstSearch.
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
        solver = new BestFirstSearch();
        Board solved = solver.solve(instance);
        assertTrue(solved.isCorrect());
    }

    /**
     * Test of solve method, of class BestFirstSearch.
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
        solver = new BestFirstSearch(new MisplacedComparator());
        solver.solve(instance);
    }

    /**
     * Test of solve method, of class BestFirstSearch.
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
        solver = new BestFirstSearch(new MisplacedComparator());
        solver.solve(instance);
    }

    /**
     * Test of getTimeInNanos method, of class BestFirstSearch.
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
        solver = new BestFirstSearch(new MisplacedComparator());
        solver.solve(instance);
        long time = solver.getTimeInNanos();
        assertTrue(time > 0);
    }

    /**
     * Test of getTimeInMilis method, of class BestFirstSearch.
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
        solver = new BestFirstSearch(new MisplacedComparator());
        solver.solve(instance);
        double time = solver.getTimeInMilis();
        assertTrue(time > 0d);
    }

    /**
     * Test of solve method, of class BestFirstSearch.
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
        solver = new BestFirstSearch(new MisplacedComparator(), 1);
        Board solved = solver.solve(instance);
        assertNull(solved);
    }

    //A* tests, it's the same algorithm, but heuristic is different

    /**
     * Test of solve method, of class BestFirstSearch.
     */
    @Test
    public void shouldSolveSimpleBoardAStar() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        solver = new BestFirstSearch(new AMisplacedComparator());
        Board solved = solver.solve(instance);
        assertTrue(solved.isCorrect());
    }

    /**
     * Test of solve method, of class BestFirstSearch.
     */
    @Test
    public void shouldReturnNullWhenTooLowDepthGivenAStar() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {0, 10, 11, 12},
                {9, 13, 14, 15}
        };

        instance = new Board(state);
        solver = new BestFirstSearch(new AMisplacedComparator(), 1);
        Board solved = solver.solve(instance);
        assertNull(solved);
    }
}
