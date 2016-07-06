package frontend;

import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frontend.animator.AnimatorWindow;
import frontend.newGame.NewGameWindow;
import frontend.solver.SolverWindow;
import frontend.statistics.StatisticsWindow;
import frontend.winGame.WinGameWindow;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

public class MainWindowTest {

    private int[][] state;

    private Board testingBoard;
    private FrameFixture window;
    private MainWindow frame;
    private ComponentFinder finder;

    @Before
    public void setUp() {
        state = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        testingBoard = new Board(state);
        frame = new MainWindow();
        window = new FrameFixture(frame);
        window.show();
        finder = BasicComponentFinder.finderWithNewAwtHierarchy();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testStatisticButtonPressed() {
        window.button("Statistics").click();
        finder.findByType(StatisticsWindow.class);
    }

    @Test
    public void testNewGameButtonPressed() {
        window.button("NewGame").click();
        finder.findByType(NewGameWindow.class);
    }

    @Test
    public void testAnimateButtonPressed() {
        window.button("Animate").click();
        finder.findByType(AnimatorWindow.class);
    }

    @Test
    public void testSolverButtonPressed() {
        window.button("Solver").click();
        finder.findByType(SolverWindow.class);
    }

    @Test
    public void testSetNewGameSmallBoard() {

        frame.setNewGame(testingBoard);
        JPanelFixture buttons = window.panel("puzzlePanel");
        for (int i = 1; i < 16; i++) {
            buttons.button("" + i);
        }
    }

    @Test
    public void testSetNewGameBigBoard() {
        testingBoard = BoardUtils.buildArrangedBoard(9, 9);
        frame.setNewGame(testingBoard);
        JPanelFixture buttons = window.panel("puzzlePanel");
        for (int i = 1; i < 81; i++) {
            buttons.button("" + i);
        }
    }

    @Test
    public void testEndGameShowWindow() {
        frame.setNewGame(testingBoard);
        JPanelFixture buttons = window.panel("puzzlePanel");
        buttons.button("15").click();
        finder.findByType(WinGameWindow.class);
    }
}
