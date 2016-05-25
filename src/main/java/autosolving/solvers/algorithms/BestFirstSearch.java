package autosolving.solvers.algorithms;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import autosolving.heuristics.Heuristic;
import autosolving.solvers.HeuristicSolver;
import autosolving.solvers.PuzzleSolver;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

/**
 * A* - algorytm 'najpierw najlepszy'
 *
 *
 * Celem tej strategii jest wyznaczenie najtańszej drogi w grafie.
 *
 * A* do dzialania wymaga komparatora A, gdy podany zostanie komparator nie-A dziala jak zwykle
 * best-first
 */
public class BestFirstSearch extends HeuristicSolver {

    private List<Board> uncheckedNodes;
    private List<Board> checkedNodes;

    public BestFirstSearch() {
        super();
    }

    public BestFirstSearch(Heuristic heuristicFunction, int depth) {
        super(depth, heuristicFunction);
    }

    public BestFirstSearch(Heuristic heuristicFunction) {
        super(heuristicFunction);
    }

    @Override
    public Board solve(Board unsolved) throws BoardWithoutZeroException, UnsolvableBoardException {

        BoardUtils.checkBoard(unsolved);

        uncheckedNodes = new ArrayList<>();
        checkedNodes = new ArrayList<>();
        List<Board> newNodes = new ArrayList<>();
        Board current;
        PuzzleSolver.CREATED_BOARDS = 0;
        this.createdBoards = 0;
        this.time = System.nanoTime();

        uncheckedNodes.add(new Board(unsolved.getState()));

        while (!uncheckedNodes.isEmpty()) {
            Collections.sort(uncheckedNodes, heuristicFunction);
            current = uncheckedNodes.get(0);

            if (current.getPath().length() > maxDepth) {
                this.time = System.nanoTime() - time;
                return null;
            }

            if (outputStream != null && !StringUtils.isBlank(current.getPath())) {
                outputStream.println(current.getPath());
            }
            if (current.isCorrect()) {
                this.time = System.nanoTime() - time;
                return current;
            }

            addToChecked(current);
            newNodes = current.getPossibleStates(heuristicFunction);
            this.createdBoards = this.createdBoards + newNodes.size();
            newNodes = newNodesWithoutChecked(newNodes);
            uncheckedNodes.addAll(newNodes);
        }

        this.time = System.nanoTime() - time;
        return null;
    }

    private List<Board> newNodesWithoutChecked(List<Board> newNodes) {
        List<Board> tmp = new ArrayList<>();
        boolean isChecked = false;
        for (Board newNode : newNodes) {
            for (Board checkedNode : checkedNodes) {
                if (newNode.equals(checkedNode)) {
                    isChecked = true;
                }
            }
            if (isChecked) {
                isChecked = false;
            } else {
                tmp.add(newNode);
            }
        }
        return tmp;
    }

    private void addToChecked(Board current) {
        checkedNodes.add(current);
        uncheckedNodes.remove(current);
    }
}

