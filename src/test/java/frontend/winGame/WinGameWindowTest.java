package frontend.winGame;

import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import npuzzle.Board;
import npuzzle.utils.BoardUtils;

public class WinGameWindowTest {

    private FrameFixture window;
    private WinGameWindow frame;
    private ComponentFinder finder;
    private Board testingBoard;

    @Before
    public void setUp() {
        testingBoard = BoardUtils.buildArrangedBoard(4, 4);
        frame = new WinGameWindow(3.14, testingBoard);
        window = new FrameFixture(frame);
        window.show();
        finder = BasicComponentFinder.finderWithNewAwtHierarchy();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testShowResult() {
        window.label("time").requireText("3.14s");
        window.label("amount").requireText("0");
        window.label("size").requireText("4x4");
    }
}
