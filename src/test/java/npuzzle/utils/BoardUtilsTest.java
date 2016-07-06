package npuzzle.utils;

import org.junit.Test;

import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;
import npuzzle.Moves;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Piotrek
 */
public class BoardUtilsTest {

    private Board instance;
    private int[][] state;

    /**
     * Test of countMisplaced method, of class BoardUtils.
     */
    @Test
    public void shouldCorrectlyCountMisplacedTiles() {

        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 0, 15}
        };

        instance = new Board(state);
        int expResult = 2;
        int result = BoardUtils.countMisplaced(instance);
        assertEquals(expResult, result);

        state = new int[][]{
            {2, 1, 4, 3},
            {6, 5, 8, 7},
            {10, 9, 12, 11},
            {0, 15, 14, 13}
        };

        instance = new Board(state);
        expResult = 16;
        result = BoardUtils.countMisplaced(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of countMisplaced method, of class BoardUtils.
     */
    @Test
    public void shouldCorrectlyCountMisplacedTilesUnsymmetrical() {

        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 0, 11},};

        instance = new Board(state);
        int expResult = 2;
        int result = BoardUtils.countMisplaced(instance);
        assertEquals(expResult, result);

        state = new int[][]{
            {2, 3, 1},
            {6, 4, 5},
            {8, 9, 7},
            {11, 0, 10}
        };

        instance = new Board(state);
        expResult = 12;
        result = BoardUtils.countMisplaced(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of buildArrangedBoard method, of class BoardUtils.
     */
    @Test
    public void shouldReturnCorrectBoard() {

        instance = BoardUtils.buildArrangedBoard(4, 4);
        boolean result = instance.isCorrect();
        assertTrue(result);

        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };

        assertArrayEquals(instance.getState(), state);
    }

    /**
     * Test of correctState method, of class BoardUtils.
     */
    @Test
    public void correctStateShouldReturnTrue() {

        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };

        boolean result = BoardUtils.correctState(state);
        assertTrue(result);
    }

    /**
     * Test of correctState method, of class BoardUtils.
     */
    @Test
    public void correctStateShouldReturnFalse() {

        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {0, 0, 0, 0}
        };

        boolean result = BoardUtils.correctState(state);
        assertFalse(result);
    }

    /**
     * Test of correctState method, of class BoardUtils.
     */
    @Test
    public void randomizedOrderShouldContainEveryDirection() {

        String result = BoardUtils.randomizeOrder();
        assertTrue(result.contains(Moves.DOWN_CHAR)
                && result.contains(Moves.UP_CHAR)
                && result.contains(Moves.RIGHT_CHAR)
                && result.contains(Moves.LEFT_CHAR));
    }

    /**
     * Test of randomizeBoard method, of class BoardUtils.
     */
    @Test
    public void shouldReturnRandomizedBoard() {

        instance = BoardUtils.randomizeBoard(4, 4, 50);

        assertNotNull(instance);
        assertNotNull(instance.getState());
        assertTrue(instance.getState().length == 4);
        assertTrue(instance.getState()[0].length == 4);
        assertFalse(instance.isCorrect());
    }

    /**
     * Test of reverseMoves method, of class BoardUtils.
     */
    @Test
    public void shouldReturnReversedMoves() {
        String moves = Moves.DOWN_CHAR + Moves.LEFT_CHAR + Moves.UP_CHAR + Moves.RIGHT_CHAR;
        String reversedMoves = BoardUtils.reverseMoves(moves);
        String expected = Moves.LEFT_CHAR + Moves.DOWN_CHAR + Moves.RIGHT_CHAR + Moves.UP_CHAR;

        assertNotNull(reversedMoves);
        assertTrue(reversedMoves.equals(expected));
    }

    /**
     * Test of reverseMoves method, of class BoardUtils.
     */
    @Test
    public void shouldReturnNullWhenGivenWrongDirections() {

        String moves = Moves.DOWN_CHAR + Moves.LEFT_CHAR + Moves.UP_CHAR + Moves.RIGHT_CHAR + "!@#$";
        String reversedMoves = BoardUtils.reverseMoves(moves);

        assertTrue(reversedMoves == null);
    }

    /**
     * Test of checkBoard method, of class BoardUtils.
     */
    @Test(expected = BoardWithoutZeroException.class)
    public void checkBoardShouldThrowBoardWithoutZeroException() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {1, 1, 1, 1}
        };
        instance = new Board(state);
        BoardUtils.checkBoard(instance);
    }

    /**
     * Test of checkBoard method, of class BoardUtils.
     */
    @Test(expected = UnsolvableBoardException.class)
    public void checkBoardShouldThrowUnsolvableBoardException() throws BoardWithoutZeroException, UnsolvableBoardException {

        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {1, 1, 1, 0}
        };
        instance = new Board(state);
        BoardUtils.checkBoard(instance);
    }

    @Test
    public void testGetStartingBoard() throws BoardWithoutZeroException {
        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };
        instance = new Board(state);
        instance.moveLeft();
        instance.moveLeft();
        instance.moveLeft();
        instance.moveUp();
        Board result = BoardUtils.getStartingBoard(instance);
        assertTrue(result.equals(new Board(state)));
    }

    @Test
    public void testGetStartingBoardWithPath() throws BoardWithoutZeroException {
        state = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };

        int[][] state2 = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {10, 0, 11, 12},
            {9, 13, 14, 15}
        };
        instance = new Board(state);
        String path = "ldppp";
        Board result = BoardUtils.getStartingBoard(instance, path);
        assertTrue(result.equals(new Board(state2)));
    }

}
