package autosolving.solvers;

import java.io.PrintStream;

import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;


/**
 * @author Piotrek
 */
public abstract class PuzzleSolver {

    public static int DEFAULT_MAX_DEPTH = 25;
    protected static int CREATED_BOARDS = 0;

    protected int createdBoards;
    protected long time = 0;
    protected int maxDepth;
    protected PrintStream outputStream;

    public PuzzleSolver() {
        this.createdBoards = 0;
        this.maxDepth = DEFAULT_MAX_DEPTH;
        this.outputStream = null;
    }

    public PuzzleSolver(int maxDepth) {
        this.createdBoards = 0;
        this.maxDepth = maxDepth;
        this.outputStream = null;
    }

    /**
     * Method for counting created boards, to use only in Board class
     */
    public static void addCreated(int i) {
        PuzzleSolver.CREATED_BOARDS = PuzzleSolver.CREATED_BOARDS + i;
    }

    /**
     * You can set output stream, where will be printed paths of every checked board in algorithm,
     * in right order. You can put here System.out to print paths in console or leave this null.
     */
    public void setOutputStream(PrintStream stream) {
        this.outputStream = stream;
    }

    public long getTimeInNanos() {
        return this.time;
    }

    public double getTimeInMillis() {
        return this.time / 1000000d;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getCreatedBoards() {
        return this.createdBoards;
    }

    /**
     * Method solves given board, and returns solution or null if answer can not be found by
     * algorithm. Method saves its execution time in 'time' field, and created boards in
     * 'createdBoards' field.
     *
     * @param unsolved board
     * @return solved board or null when algorithm cannot find solution
     */
    public abstract Board solve(Board unsolved) throws BoardWithoutZeroException, UnsolvableBoardException;

}
