package npuzzle;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Piotrek
 */
public class BoardUtilsTest {

    Board instance;
    int[][] state;

    public BoardUtilsTest() {
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
        boolean expResult = true;
        boolean result = instance.isCorrect();
        assertEquals(expResult, result);

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

        boolean expResult = true;
        boolean result = BoardUtils.correctState(state);
        assertEquals(expResult, result);
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

        boolean expResult = false;
        boolean result = BoardUtils.correctState(state);
        assertEquals(expResult, result);
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
}
