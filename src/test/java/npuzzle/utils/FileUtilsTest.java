package npuzzle.utils;

import org.junit.After;
import org.junit.Test;

import java.io.File;

import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Piotrek
 */
public class FileUtilsTest {

    String fileName = "test";
    Board instance;
    int[][] state;


    @After
    public void tearDown() {
        File file = new File(fileName);
        file.delete();
    }

    /**
     * Test of saveBoard method, of class BoardUtils.
     */
    @Test
    public void shouldSaveAndLoadBoard() throws UnsolvableBoardException, BoardWithoutZeroException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        instance = new Board(state);

        FileUtils.saveBoard(fileName, instance);

        Board result = null;
        result = FileUtils.loadBoard(fileName);

        assertArrayEquals(result.getState(), instance.getState());
    }

    /**
     * Test of loadBoard method, of class BoardUtils.
     */
    @Test(expected = BoardWithoutZeroException.class)
    public void shouldThrowBoardWithoutZeroException() throws UnsolvableBoardException, BoardWithoutZeroException {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 15}
        };
        instance = new Board(state);

        FileUtils.saveBoard(fileName, instance);
        FileUtils.loadBoard(fileName);
    }

    /**
     * Test of loadBoard method, of class BoardUtils.
     */
    @Test(expected = UnsolvableBoardException.class)
    public void shouldThrowUnsolvableBoardException() throws UnsolvableBoardException, BoardWithoutZeroException {

        state = new int[][]{
                {0, 0, 0, 0},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 15}
        };
        instance = new Board(state);

        FileUtils.saveBoard(fileName, instance);
        FileUtils.loadBoard(fileName);
    }
}