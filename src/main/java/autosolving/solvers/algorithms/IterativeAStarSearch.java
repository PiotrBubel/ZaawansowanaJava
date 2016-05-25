package autosolving.solvers.algorithms;

import autosolving.heuristics.Heuristic;
import autosolving.solvers.HeuristicSolver;
import autosolving.solvers.PuzzleSolver;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

/**
 * A* - algorytm 'najpierw najlepszy' z poglebieniem iteracyjnym
 *
 *
 * Celem tej strategii jest wyznaczenie najtańszej drogi w grafie.
 */
public class IterativeAStarSearch extends HeuristicSolver {

    public IterativeAStarSearch(Heuristic heuristicFunction, int depth) {
        super(depth, heuristicFunction);
    }

    public IterativeAStarSearch(Heuristic heuristicFunction) {
        super(heuristicFunction);
        maxDepth = DEFAULT_MAX_DEPTH;
    }

    @Override
    public Board solve(Board unsolved) throws BoardWithoutZeroException, UnsolvableBoardException {

        BoardUtils.checkBoard(unsolved);

        int depth = 1;
        Board solved = null;

        this.time = System.nanoTime();
        this.createdBoards = 0;
        Board toSolve = new Board(unsolved);

        while (depth <= maxDepth && solved == null) {
            PuzzleSolver.CREATED_BOARDS = 0;
            solved = toSolve.findAnswerWithIDA(heuristicFunction, depth, outputStream);
            this.createdBoards = this.createdBoards + CREATED_BOARDS;
            depth++;
        }
        this.time = System.nanoTime() - time;
        return solved;
    }
}