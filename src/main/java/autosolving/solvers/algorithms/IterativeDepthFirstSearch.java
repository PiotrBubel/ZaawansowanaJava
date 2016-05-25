package autosolving.solvers.algorithms;

import autosolving.solvers.NonHeuristicSolver;
import autosolving.solvers.PuzzleSolver;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

/**
 * iDFS iterative Depth-first search - algorytm przeszukiwania wgłąb z pogłębianiem iteracyjnym
 *
 * Przeszukiwanie w głąb polega na badaniu wszystkich krawędzi wychodzących z podanego wierzchołka.
 * Po zbadaniu wszystkich krawędzi wychodzących z danego wierzchołka algorytm powraca do
 * wierzchołka, z którego dany wierzchołek został odwiedzony
 */
public class IterativeDepthFirstSearch extends NonHeuristicSolver {

    public IterativeDepthFirstSearch(String order) {
        super(order);
    }

    public IterativeDepthFirstSearch(String order, int depth) {
        super(order, depth);
    }

    public IterativeDepthFirstSearch(int depth) {
        super(depth);
    }

    public IterativeDepthFirstSearch() {
        super();
        maxDepth = DEFAULT_MAX_DEPTH;
        this.createdBoards = 0;
    }

    @Override
    public Board solve(Board unsolved) throws BoardWithoutZeroException, UnsolvableBoardException {

        BoardUtils.checkBoard(unsolved);

        int depth = 1;
        PuzzleSolver depthFirstSolver;
        Board solved = null;

        this.time = System.nanoTime();
        PuzzleSolver.CREATED_BOARDS = 0;
        this.createdBoards = 0;

        while (depth <= maxDepth && solved == null) {
            depthFirstSolver = new DepthFirstSearch(this.order, depth);
            depthFirstSolver.setOutputStream(this.outputStream);
            Board toSolve = new Board(unsolved);
            solved = depthFirstSolver.solve(toSolve);
            this.createdBoards = this.createdBoards + depthFirstSolver.getCreatedBoards();
            depth++;
        }
        this.time = System.nanoTime() - time;
        return solved;
    }

}
