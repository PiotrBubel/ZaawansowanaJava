package autosolving.heuristics;

import npuzzle.Board;

/**
 * Heuristic function: counts distance between every tile and its place + length of path needed to
 * create given board, does not count zero as tile
 *
 * Should be used in A* and IDA* algorithms
 */
public class AManhattanDistanceComparator extends ManhattanDistanceComparator {

    public int compare(Board b1, Board b2) {
        return (this.heuristicValue(b1)) - (this.heuristicValue(b2));
    }

    public int heuristicValue(Board b) {
        return super.heuristicValue(b) + b.getPath().length();
    }
}
