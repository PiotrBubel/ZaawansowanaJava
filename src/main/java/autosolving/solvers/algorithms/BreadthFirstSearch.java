package autosolving.solvers.algorithms;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

import autosolving.solvers.NonHeuristicSolver;
import autosolving.solvers.PuzzleSolver;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

/**
 * BFS Breadth-first search - algorytm przeszukiwania wszerz
 *
 *
 * Przechodzenie grafu rozpoczyna się od zadanego wierzchołka s i polega na odwiedzeniu wszystkich
 * osiągalnych z niego wierzchołków. Wynikiem działania algorytmu jest drzewo przeszukiwania wszerz
 * o korzeniu w s, zawierające wszystkie wierzchołki osiągalne z s. Do każdego z tych wierzchołków
 * prowadzi dokładnie jedna ścieżka z s, która jest jednocześnie najkrótszą ścieżką w grafie
 * wejściowym.
 */
public class BreadthFirstSearch extends NonHeuristicSolver {

    private List<Board> uncheckedNodes;
    private List<Board> checkedNodes;
    private List<Board> newNodes;

    public BreadthFirstSearch() {
        super();
    }

    public BreadthFirstSearch(String order) {
        super(order);
    }

    public BreadthFirstSearch(String order, int maxDepth) {
        super(order, maxDepth);
    }

    public BreadthFirstSearch(int maxDepth) {
        super(maxDepth);
    }

    @Override
    public Board solve(Board unsolved) throws BoardWithoutZeroException, UnsolvableBoardException {

        BoardUtils.checkBoard(unsolved);

        uncheckedNodes = new ArrayList<>();
        checkedNodes = new ArrayList<>();
        newNodes = new ArrayList<>();
        Board current;
        PuzzleSolver.CREATED_BOARDS = 0;
        this.createdBoards = 0;

        this.time = System.nanoTime();

        uncheckedNodes.add(new Board(unsolved.getState()));

        while (!uncheckedNodes.isEmpty()) {

            current = uncheckedNodes.get(0);

            newNodes = current.getPossibleStates(this.order);
            this.createdBoards = this.createdBoards + newNodes.size();

            newNodes = removeChecked();
            uncheckedNodes.addAll(newNodes);

            if (outputStream != null && !StringUtils.isBlank(current.getPath())) {
                outputStream.println(current.getPath());
            }
            if (current.isCorrect()) {
                this.time = System.nanoTime() - time;
                return current;
            }

            addToChecked(current);

            if (current.getPath().length() > maxDepth) {
                break;
            }
        }

        this.time = System.nanoTime() - time;
        return null;
    }

    private List<Board> removeChecked() {
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
