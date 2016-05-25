package autosolving.heuristics;

import npuzzle.Board;

/**
 * Heuristic function: counts distance between every tile and its place, does not count zero as
 * tile
 *
 * Should be used in BestFirst algorithm
 */
public class ManhattanDistanceComparator implements Heuristic {

    public int compare(Board b1, Board b2) {
        return this.heuristicValue(b1) - this.heuristicValue(b2);
    }

    public int heuristicValue(Board b) {
        int sum = 0;
        int[][] state = b.getState();
        int correctValue = 1;

        for (int x = 0; x < state.length; x++) {
            for (int y = 0; y < state[0].length; y++) {
                if (x == state.length - 1 && y == state[0].length - 1) {
                    break;
                }
                int[] valueCoord = b.findNumber(correctValue);
                sum = sum + (Math.abs(valueCoord[0] - x) + Math.abs(valueCoord[1] - y));

                correctValue++;
            }
        }
        return sum;
    }
}