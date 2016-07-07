package frontend.solver;

import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.finder.JOptionPaneFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import autosolving.solvers.PuzzleSolver;
import frontend.animator.AnimatorWindow;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SolverWindowTest {

    private FrameFixture window;
    private SolverWindow frame;
    private Board board;
    private PuzzleSolver solver;
    private SolverController controller;
    private ComponentFinder finder;
    private JOptionPaneFixture optionPane;

    public SolverWindowTest() {
    }

    @Before
    public void setUp() {
        board = mock(Board.class);
        solver = mock(PuzzleSolver.class);
        controller = mock(SolverController.class);

        frame = new SolverWindow(board, controller);
        window = new FrameFixture(frame);
        window.show();
        finder = BasicComponentFinder.finderWithNewAwtHierarchy();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testShowButtonWithoutSolve() {
        window.button("show").click();
        optionPane = JOptionPaneFinder.findOptionPane().withTimeout(2500).using(BasicRobot.robotWithCurrentAwtHierarchyWithoutScreenLock());
        optionPane.buttonWithText("OK").click();
    }

    @Test
    public void testShowButtonWithSolved() {
        when(controller.getBoard()).thenReturn(BoardUtils.buildArrangedBoard(4, 4));
        when(controller.isSolved()).thenReturn(true);
        window.button("solve").click();
        optionPane = JOptionPaneFinder.findOptionPane().withTimeout(2500).using(BasicRobot.robotWithCurrentAwtHierarchyWithoutScreenLock());
        optionPane.buttonWithText("OK").click();
        window.button("show").click();
        finder.findByType(AnimatorWindow.class);
    }

    @Test
    public void testSolveButton() {
        when(controller.getBoard()).thenReturn(BoardUtils.buildArrangedBoard(4, 4));
        window.button("solve").click();
        optionPane = JOptionPaneFinder.findOptionPane().withTimeout(2500).using(BasicRobot.robotWithCurrentAwtHierarchyWithoutScreenLock());
        optionPane.buttonWithText("OK").click();
    }

    @Test
    public void testSpinnerDefaultValue() {
        window.spinner("depth").requireValue(20);

    }

    @Test
    public void testSpinnerMinimumValue() {
        window.spinner("depth").decrement(20).requireValue(1);
    }

    @Test
    public void testHeuristicRadioButton() {
        window.radioButton("missplaced").click();
        assertTrue(frame.heuristic == Heuristics.MISPLACED);
        window.radioButton("manhattan").click();
        assertTrue(frame.heuristic == Heuristics.MANHATTAN);
    }

    @Test
    public void testAlgorithmChoose() {
        assertTrue(frame.getAlgorithm() == Algorithm.A_STAR);
        window.list("algorithms").clickItem(1);
        assertTrue(frame.getAlgorithm() == Algorithm.BEST_FIRST);
        window.list("algorithms").clickItem(2);
        assertTrue(frame.getAlgorithm() == Algorithm.BFS);
        window.list("algorithms").clickItem(3);
        assertTrue(frame.getAlgorithm() == Algorithm.DFS);
        window.list("algorithms").clickItem(4);
        assertTrue(frame.getAlgorithm() == Algorithm.IDA_STAR);
        window.list("algorithms").clickItem(5);
        assertTrue(frame.getAlgorithm() == Algorithm.IDFS);
    }
}
