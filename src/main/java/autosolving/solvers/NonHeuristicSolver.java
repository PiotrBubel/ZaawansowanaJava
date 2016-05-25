package autosolving.solvers;

import npuzzle.Moves;
import npuzzle.utils.BoardUtils;

/**
 * Created by Piotrek on 14.05.2016.
 */
public abstract class NonHeuristicSolver extends PuzzleSolver {
    protected String order;

    public NonHeuristicSolver(String order) {
        super();
        this.order = checkOrder(order);
        this.createdBoards = 0;
    }

    public NonHeuristicSolver(String order, int depth) {
        super(depth);
        this.order = checkOrder(order);
        this.createdBoards = 0;
    }

    public NonHeuristicSolver() {
        super();
        this.order = BoardUtils.randomizeOrder();
    }

    public NonHeuristicSolver(int depth) {
        super(depth);
        this.order = BoardUtils.randomizeOrder();
    }

    public String getOrder() {
        return this.order;
    }

    private String checkOrder(String given) {
        if (given.length() != 4
                || !(given.toLowerCase().contains(Moves.DOWN_CHAR)
                && given.toLowerCase().contains(Moves.LEFT_CHAR)
                && given.toLowerCase().contains(Moves.RIGHT_CHAR)
                && given.toLowerCase().contains(Moves.UP_CHAR)) ^ given.toLowerCase().contains("r")) {
            return BoardUtils.randomizeOrder();
        } else {
            return given;
        }
    }

}
