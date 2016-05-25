package npuzzle.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import npuzzle.utils.FileUtils;
import npuzzle.Board;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Piotrek
 */
public class FileUtilsTest {

    String fileName = "test";
    Board instance;
    int[][] state;

    public FileUtilsTest() {
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
        File file = new File(fileName);
        file.delete();
    }

    /**
     * Test of saveBoard method, of class BoardUtils.
     */
    @Test
    public void shouldSaveAndLoadBoard() {

        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        instance = new Board(state);

        FileUtils.saveBoard(fileName, instance);

        Board result = FileUtils.loadBoard(fileName);

        assertArrayEquals(result.getState(), instance.getState());
    }
}