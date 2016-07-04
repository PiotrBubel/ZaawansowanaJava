/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import frontend.animator.AnimatorWindow;
import frontend.newGame.NewGameWindow;
import frontend.solver.SolverWindow;
import frontend.statistics.StatisticsWindow;
import npuzzle.Board;
import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

//    /**
//     * Test of setNewGame method, of class MainWindow.
//     */
//    @Test
//    public void testSetNewGame() {
//        System.out.println("setNewGame");
//        Board board = null;
//        MainWindow instance = new MainWindow();
//        instance.setNewGame(board);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of endGame method, of class MainWindow.
//     */
//    @Test
//    public void testEndGame() {
//        System.out.println("endGame");
//        MainWindow instance = new MainWindow();
//        instance.endGame();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class MainWindow.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        MainWindow.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
