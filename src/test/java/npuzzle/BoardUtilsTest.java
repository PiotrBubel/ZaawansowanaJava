package npuzzle;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import npuzzle.BoardUtils;
import npuzzle.Board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Piotrek
 */
public class BoardUtilsTest {

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
    public void testCountMisplaced() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        Board instance = new Board(state);
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
    public void testCountMisplacedUnsymmetrical() {

        int[][] state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 11},};

        Board instance = new Board(state);
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
}
