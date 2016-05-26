package autosolving.heuristics;

import org.junit.Test;

import npuzzle.Board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Piotrek
 */
public class ManhattanDistanceComparatorTest {

    private Board board;
    private int[][] state;
    private Heuristic heuristic;

    public ManhattanDistanceComparatorTest() {
        heuristic = new ManhattanDistanceComparator();
    }

    /**
     * Test of heuristicValue method, of class ManhattanDistanceComparator
     */
    @Test
    public void shouldReturnIntMaxValueIfGivenUnsolvableBoard() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 0}
        };

        board = new Board(state);
        int result = heuristic.heuristicValue(board);
        assertEquals(Integer.MAX_VALUE, result);
    }

    /**
     * Test of heuristicValue method, of class ManhattanDistanceComparator
     */
    @Test
    public void heuristicValueReturnZeroWhenCorrectBoard() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        board = new Board(state);
        int expResult = 0;
        int result = heuristic.heuristicValue(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of heuristicValue method, of class ManhattanDistanceComparator
     */
    @Test
    public void heuristicValueShouldNotCountZero() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        board = new Board(state);
        int expResult = 1;
        int result = heuristic.heuristicValue(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class ManhattanDistanceComparator
     */
    @Test
    public void heuristicComparatorShouldWorkCorrectly() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        board = new Board(state);

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        Board board2 = new Board(state);
        int result = heuristic.compare(board, board2);
        assertTrue(result > 0);
    }
}
