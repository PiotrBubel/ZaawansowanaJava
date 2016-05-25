package npuzzle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.BoardWithoutZeroException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Piotrek
 */
public class BoardTest {

    Board instance;
    int[][] state;

    public BoardTest() {
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
     * Test of isCorrect method, of class npuzzle.Board.
     */
    @Test
    public void isCorrectShoultReturnTrue() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        instance = new Board(state);
        boolean expResult = true;
        boolean result = instance.isCorrect();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCorrect method, of class npuzzle.Board.
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
        boolean expResult = false;
        boolean result = instance.isCorrect();
        assertEquals(expResult, result);
    }

    /**
     * Test of moveDown method, of class npuzzle.Board.
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
     * Test of moveDown method, of class npuzzle.Board.
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
     * Test of moveDown method, of class npuzzle.Board.
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
     * Test of moveDown method, of class npuzzle.Board.
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
     * Test of findZero method, of class npuzzle.Board.
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
     * Test of findZero method, of class npuzzle.Board.
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
     * Test of canMoveRight method, of class npuzzle.Board.
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
        boolean expResult = true;
        boolean result = instance.canMoveRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveRight method, of class npuzzle.Board.
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
        boolean expResult = false;
        boolean result = instance.canMoveRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveLeft method, of class npuzzle.Board.
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
        boolean expResult = true;
        boolean result = instance.canMoveLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveLeft method, of class npuzzle.Board.
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
        boolean expResult = false;
        boolean result = instance.canMoveLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveUp method, of class npuzzle.Board.
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
        boolean expResult = true;
        boolean result = instance.canMoveUp();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveUp method, of class npuzzle.Board.
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
        boolean expResult = false;
        boolean result = instance.canMoveUp();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveDown method, of class npuzzle.Board.
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
        boolean expResult = false;
        boolean result = instance.canMoveDown();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveDown method, of class npuzzle.Board.
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
        boolean expResult = true;
        boolean result = instance.canMoveDown();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class npuzzle.Board.
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
     * Test of moveRight method, of class npuzzle.Board.
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
     * Test of moveLeft method, of class npuzzle.Board.
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
     * Test of moveUp method, of class npuzzle.Board.
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
     * Test of moveDown method, of class npuzzle.Board.
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
     * Test of isCorrect method, of class npuzzle.Board.
     */
    @Test
    public void isCorrectShoultReturnTrueUnsymmetrical() {

        state = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0}
        };

        instance = new Board(state);
        boolean expResult = true;
        boolean result = instance.isCorrect();
        assertEquals(expResult, result);
    }

    @Test
    public void isCorrectShoultReturnFalseUnsymmetrical() {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 11},};

        instance = new Board(state);
        boolean expResult = false;
        boolean result = instance.isCorrect();
        assertEquals(expResult, result);
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
     * Test of canMoveRight method, of class npuzzle.Board.
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
        boolean expResult = true;
        boolean result = instance.canMoveRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveRight method, of class npuzzle.Board.
     */
    @Test
    public void canMoveRightShouldReturnFalseUnsymmetrical() {
        state = new int[][]{
                {1, 2, 3, 0},
                {5, 6, 7, 8},
                {9, 10, 11, 4}
        };

        instance = new Board(state);
        boolean expResult = false;
        boolean result = instance.canMoveRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveLeft method, of class npuzzle.Board.
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
        boolean expResult = true;
        boolean result = instance.canMoveLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveLeft method, of class npuzzle.Board.
     */
    @Test
    public void canMoveLeftShouldReturnFalseUnsymmetrical() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {0, 9, 10, 11}
        };

        instance = new Board(state);
        boolean expResult = false;
        boolean result = instance.canMoveLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveUp method, of class npuzzle.Board.
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
        boolean expResult = false;
        boolean result = instance.canMoveUp();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveUp method, of class npuzzle.Board.
     */
    @Test
    public void canMoveUpShouldReturnTrueUnsymmetrical() {
        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 11}
        };

        Board instance = new Board(state);
        boolean expResult = true;
        boolean result = instance.canMoveUp();
        assertEquals(expResult, result);

    }

    /**
     * Test of canMoveDown method, of class npuzzle.Board.
     */
    @Test
    public void canMoveDownShouldReturnTrueUnsymmetrical() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 0},
                {9, 10, 11, 8},};

        instance = new Board(state);
        boolean expResult = true;
        boolean result = instance.canMoveDown();
        assertEquals(expResult, result);
    }

    /**
     * Test of canMoveDown method, of class npuzzle.Board.
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
        boolean expResult = false;
        boolean result = instance.canMoveDown();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class npuzzle.Board.
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
     * Test of moveRight method, of class npuzzle.Board.
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
     * Test of moveLeft method, of class npuzzle.Board.
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
     * Test of moveUp method, of class npuzzle.Board.
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
     * Test of moveDown method, of class npuzzle.Board.
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
}
