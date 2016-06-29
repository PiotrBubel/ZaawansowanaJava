package frontend.solver;

import autosolving.heuristics.AManhattanDistanceComparator;
import autosolving.heuristics.AMisplacedComparator;
import autosolving.heuristics.ManhattanDistanceComparator;
import autosolving.heuristics.MisplacedComparator;
import autosolving.solvers.PuzzleSolver;
import autosolving.solvers.algorithms.BestFirstSearch;
import autosolving.solvers.algorithms.BreadthFirstSearch;
import autosolving.solvers.algorithms.DepthFirstSearch;
import autosolving.solvers.algorithms.IterativeAStarSearch;
import autosolving.solvers.algorithms.IterativeDepthFirstSearch;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;

public class SolverController {

    private Board board;
    private Board startingBoard;
    private boolean solved;
    private PuzzleSolver solver;

    public SolverController(Board board) {
        this.startingBoard = new Board(board);
        this.board = board;
    }

    Board getBoard() {
        return board;
    }

    boolean isSolved() {
        return solved;
    }

    void setSolver(Algorithm algorithm, Heuristics heuristic, int depth) {
        switch (algorithm) {
            case A_STAR:
                if (heuristic.equals(Heuristics.MANHATTAN)) {
                    solver = new BestFirstSearch(new AManhattanDistanceComparator());
                } else {
                    solver = new BestFirstSearch(new AMisplacedComparator());
                }
                break;
            case IDA_STAR:
                if (heuristic.equals(Heuristics.MANHATTAN)) {
                    solver = new IterativeAStarSearch(new AManhattanDistanceComparator(), depth);
                } else {
                    solver = new IterativeAStarSearch(new AMisplacedComparator(), depth);
                }
                break;
            case BEST_FIRST:
                if (heuristic.equals(Heuristics.MANHATTAN)) {
                    solver = new BestFirstSearch(new ManhattanDistanceComparator());
                } else {
                    solver = new BestFirstSearch(new MisplacedComparator());
                }
                break;
            case BFS:
                solver = new BreadthFirstSearch(depth);
                break;
            case DFS:
                solver = new DepthFirstSearch(depth);
                break;
            case IDFS:
                solver = new IterativeDepthFirstSearch(depth);
                break;
        }
    }

    boolean solve() throws BoardWithoutZeroException, UnsolvableBoardException {
        if (solver != null) {
            board = solver.solve(startingBoard);
            solved = true;
        }
        return solved;
    }

}
