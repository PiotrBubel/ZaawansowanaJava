package autosolving.heuristics;

import java.util.Comparator;

import npuzzle.Board;

/**
 * Created by Piotrek on 06.05.2016.
 */
public interface Heuristic extends Comparator<Board> {
    /**
     * @return heuristic value of given board, returns Integer.MAX_VALUE if board is unsolvable
     */
    int heuristicValue(Board board);

    int compare(Board b1, Board b2);
}
