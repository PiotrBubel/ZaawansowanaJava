package npuzzle;

import org.junit.Test;

import exceptions.BoardWithoutZeroException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Piotrek
 */
public class BoardTest {

    private Board instance;
    private int[][] state;

    /**
     * Test of isCorrect method, of class Board.
     */
    @Test
    public void isCorrectShouldReturnTrue() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        instance = new Board(state);
        boolean result = instance.isCorrect();
        assertTrue(result);
    }

    /**
     * Test of isCorrect method, of class Board.
     */
    @Test
    public void isCorrectShouldReturnFalse() {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        boolean result = instance.isCorrect();
        assertFalse(result);
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test(expected = BoardWithoutZeroException.class)
    public void moveDownShouldThrowBoardWithoutZeroException() throws BoardWithoutZeroException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 1, 15}
        };

        instance = new Board(state);
        instance = instance.moveDown();
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test(expected = BoardWithoutZeroException.class)
    public void moveLeftShouldThrowBoardWithoutZeroException() throws BoardWithoutZeroException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 1, 15}
        };

        instance = new Board(state);
        instance = instance.moveLeft();
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test(expected = BoardWithoutZeroException.class)
    public void moveRightShouldThrowBoardWithoutZeroException() throws BoardWithoutZeroException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 1, 15}
        };

        instance = new Board(state);
        instance = instance.moveRight();
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test(expected = BoardWithoutZeroException.class)
    public void moveUpShouldThrowBoardWithoutZeroException() throws BoardWithoutZeroException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 1, 15}
        };

        instance = new Board(state);
        instance = instance.moveUp();
    }

    /**
     * Test of findZero method, of class Board.
     */
    @Test
    public void shouldFindZero() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        int[] expResult = new int[2];
        expResult[0] = 3;
        expResult[1] = 2;
        int[] result = instance.findZero();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }

    /**
     * Test of findZero method, of class Board.
     */
    @Test
    public void shouldReturnNegativeNumberWhenCantFindZero() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 9, 15}
        };

        instance = new Board(state);
        int[] expResult = new int[2];
        expResult[0] = -1;
        expResult[1] = -1;
        int[] result = instance.findZero();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }

    /**
     * Test of canMoveRight method, of class Board.
     */
    @Test
    public void canMoveRightShouldReturnTrue() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        boolean result = instance.canMoveRight();
        assertTrue(result);
    }

    /**
     * Test of canMoveRight method, of class Board.
     */
    @Test
    public void canMoveRightShouldReturnFalse() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        instance = new Board(state);
        boolean result = instance.canMoveRight();
        assertFalse(result);
    }

    /**
     * Test of canMoveLeft method, of class Board.
     */
    @Test
    public void canMoveLeftShouldReturnTrue() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        boolean result = instance.canMoveLeft();
        assertTrue(result);
    }

    /**
     * Test of canMoveLeft method, of class Board.
     */
    @Test
    public void canMoveLeftShouldReturnFalse() {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {0, 14, 15, 13}
        };

        instance = new Board(state);
        boolean result = instance.canMoveLeft();
        assertFalse(result);
    }

    /**
     * Test of canMoveUp method, of class Board.
     */
    @Test
    public void canMoveUpShouldReturnTrue() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        boolean result = instance.canMoveUp();
        assertTrue(result);
    }

    /**
     * Test of canMoveUp method, of class Board.
     */
    @Test
    public void canMoveUpShouldReturnFalse() {
        state = new int[][]{
                {1, 2, 3, 0},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 4}
        };

        instance = new Board(state);
        boolean result = instance.canMoveUp();
        assertFalse(result);
    }

    /**
     * Test of canMoveDown method, of class Board.
     */
    @Test
    public void canMoveDownShouldReturnFalse() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        instance = new Board(state);
        boolean result = instance.canMoveDown();
        assertFalse(result);
    }

    /**
     * Test of canMoveDown method, of class Board.
     */
    @Test
    public void canMoveDownShouldReturnTrue() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 0},
                {13, 14, 15, 12}
        };

        instance = new Board(state);
        boolean result = instance.canMoveDown();
        assertTrue(result);
    }

    /**
     * Test of getState method, of class Board.
     */
    @Test
    public void getStateShouldReturnGivenState() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        instance = new Board(state);
        int[][] result = instance.getState();
        assertArrayEquals(state, result);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void zeroShouldMoveRight() throws BoardWithoutZeroException {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveRight();

        assertArrayEquals(expResult.getState(), result.getState());
    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void zeroShouldMoveLeft() throws BoardWithoutZeroException {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 0, 14, 15}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveLeft();

        assertArrayEquals(expResult.getState(), result.getState());
    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void zeroShouldMoveUp() throws BoardWithoutZeroException {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 11, 15}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveUp();

        assertArrayEquals(expResult.getState(), result.getState());
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void zeroShouldMoveDown() throws BoardWithoutZeroException {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 11, 15}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveDown();

        assertArrayEquals(expResult.getState(), result.getState());
    }

    // tests with unsymmetrical boards

    /**
     * Test of isCorrect method, of class Board.
     */
    @Test
    public void isCorrectShouldReturnTrueUnsymmetrical() {

        state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };

        instance = new Board(state);
        boolean result = instance.isCorrect();
        assertTrue(result);
    }

    @Test
    public void isCorrectShouldReturnFalseUnsymmetrical() {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 11},};

        instance = new Board(state);
        boolean result = instance.isCorrect();
        assertFalse(result);
    }

    @Test
    public void shouldFindZeroUnsymmetrical() {

        state = new int[][]{
                {1, 3, 2},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };

        instance = new Board(state);
        int[] expResult = new int[2];
        expResult[0] = 3;
        expResult[1] = 2;
        int[] result = instance.findZero();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }

    /**
     * Test of canMoveRight method, of class Board.
     */
    @Test
    public void canMoveRightShouldReturnTrueUnsymmetrical() {
        state = new int[][]{
                {0, 1, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 2, 11}
        };

        instance = new Board(state);
        boolean result = instance.canMoveRight();
        assertTrue(result);
    }

    /**
     * Test of canMoveRight method, of class Board.
     */
    @Test
    public void canMoveRightShouldReturnFalseUnsymmetrical() {
        state = new int[][]{
                {1, 2, 3, 0},
                {5, 6, 7, 8},
                {9, 10, 11, 4}
        };

        instance = new Board(state);
        boolean result = instance.canMoveRight();
        assertFalse(result);
    }

    /**
     * Test of canMoveLeft method, of class Board.
     */
    @Test
    public void canMoveLeftShouldReturnTrueUnsymmetrical() {
        state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };

        instance = new Board(state);
        boolean result = instance.canMoveLeft();
        assertTrue(result);
    }

    /**
     * Test of canMoveLeft method, of class Board.
     */
    @Test
    public void canMoveLeftShouldReturnFalseUnsymmetrical() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {0, 9, 10, 11}
        };

        instance = new Board(state);
        boolean result = instance.canMoveLeft();
        assertFalse(result);
    }

    /**
     * Test of canMoveUp method, of class Board.
     */
    @Test
    public void canMoveUpShouldReturnFalseUnsymmetrical() {
        state = new int[][]{
                {1, 2, 0},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 3}
        };

        instance = new Board(state);
        boolean result = instance.canMoveUp();
        assertFalse(result);
    }

    /**
     * Test of canMoveUp method, of class Board.
     */
    @Test
    public void canMoveUpShouldReturnTrueUnsymmetrical() {
        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 11}
        };

        Board instance = new Board(state);
        boolean result = instance.canMoveUp();
        assertTrue(result);

    }

    /**
     * Test of canMoveDown method, of class Board.
     */
    @Test
    public void canMoveDownShouldReturnTrueUnsymmetrical() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 0},
                {9, 10, 11, 8},};

        instance = new Board(state);
        boolean result = instance.canMoveDown();
        assertTrue(result);
    }

    /**
     * Test of canMoveDown method, of class Board.
     */
    @Test
    public void canMoveDownShouldReturnFalseUnsymmetrical() {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };

        Board instance = new Board(state);
        boolean result = instance.canMoveDown();
        assertFalse(result);
    }

    /**
     * Test of getState method, of class Board.
     */
    @Test
    public void getStateShouldReturnGivenStateUnsymmetrical() {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };
        Board instance = new Board(state);
        int[][] result = instance.getState();
        assertArrayEquals(state, result);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void zeroShouldMoveRightUnsymmetrical() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 11}
        };
        Board instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveRight();

        assertArrayEquals(instance.getState(), state);
        assertArrayEquals(expResult.getState(), result.getState());
    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void zeroShouldMoveLeftUnsymmetrical() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };
        Board instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 11}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveLeft();

        assertArrayEquals(expResult.getState(), result.getState());
    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void zeroShouldMoveUpUnsymmetrical() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };
        Board instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
                {10, 11, 9}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveUp();

        assertArrayEquals(expResult.getState(), result.getState());
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void zeroShouldMoveDownUnsymmetrical() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
                {10, 11, 9}
        };
        Board instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };

        Board expResult = new Board(state2);
        Board result = instance.moveDown();

        assertArrayEquals(expResult.getState(), result.getState());
    }

    @Test
    public void testMoveByTileNearZero() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
                {10, 11, 9}
        };

        Board expResult = new Board(state2);
        Board result = instance.move(9);

        assertArrayEquals(expResult.getState(), result.getState());
    }

    @Test
    public void testMoveByTileNotCloseToZero() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };
        instance = new Board(state);
        Board expResult = new Board(state);
        Board result = instance.move(7);

        assertArrayEquals(expResult.getState(), result.getState());
    }

    @Test
    public void testChoseMoveDown() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {4, 8, 6},
                {7, 0, 5}
        };

        Board expResult = new Board(state2);
        Board result = instance.chooseMove(1, 0);

        assertArrayEquals(expResult.getState(), result.getState());
    }

    @Test
    public void testChoseMoveUp() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 0, 3},
                {4, 2, 6},
                {7, 8, 5}
        };

        Board expResult = new Board(state2);
        Board result = instance.chooseMove(-1, 0);

        assertArrayEquals(expResult.getState(), result.getState());
    }

    @Test
    public void testChoseMoveRigth() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {4, 6, 0},
                {7, 8, 5}
        };

        Board expResult = new Board(state2);
        Board result = instance.chooseMove(0, 1);

        assertArrayEquals(expResult.getState(), result.getState());
    }

    @Test
    public void testChoseMoveLeft() throws BoardWithoutZeroException {
        int[][] state = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}
        };
        instance = new Board(state);
        int[][] state2 = new int[][]{
                {1, 2, 3},
                {0, 4, 6},
                {7, 8, 5}
        };

        Board expResult = new Board(state2);
        Board result = instance.chooseMove(0, -1);

        assertArrayEquals(expResult.getState(), result.getState());
    }

}
