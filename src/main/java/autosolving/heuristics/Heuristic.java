package autosolving.heuristics;

import npuzzle.Board;

import java.util.Comparator;

/**
 * Created by Piotrek on 06.05.2016.
 */
public interface Heuristic extends Comparator<Board> {
    /**
     * @return heuristic value of given board
     */
    int heuristicValue(Board board);

    int compare(Board b1, Board b2);
}
