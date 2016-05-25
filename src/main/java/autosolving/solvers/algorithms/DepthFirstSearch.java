package autosolving.solvers.algorithms;

import autosolving.solvers.NonHeuristicSolver;
import autosolving.solvers.PuzzleSolver;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;


/**
 * DFS Depth-first search - algorytm przeszukiwania wgłąb
 *
 * Przeszukiwanie w głąb polega na badaniu wszystkich krawędzi wychodzących z podanego wierzchołka.
 * Po zbadaniu wszystkich krawędzi wychodzących z danego wierzchołka algorytm powraca do
 * wierzchołka, z którego dany wierzchołek został odwiedzony
 */
public class DepthFirstSearch extends NonHeuristicSolver {

    public DepthFirstSearch() {
        super();
    }

    public DepthFirstSearch(String order) {
        super(order);
    }

    public DepthFirstSearch(String order, int depth) {
        super(order);
        maxDepth = depth - 1;
    }

    public DepthFirstSearch(int depth) {
        super();
        maxDepth = depth - 1;
    }

    @Override
    public Board solve(Board unsolved) throws BoardWithoutZeroException, UnsolvableBoardException {

        BoardUtils.checkBoard(unsolved);

        this.time = System.nanoTime();
        PuzzleSolver.CREATED_BOARDS = 0;
        this.createdBoards = 0;
        Board correct = unsolved.findAnswerWithDFS(order, maxDepth, this.outputStream);
        this.time = System.nanoTime() - time;
        this.createdBoards = PuzzleSolver.CREATED_BOARDS;
        return correct;
    }
}
