package autosolving.solvers;

import autosolving.heuristics.Heuristic;
import autosolving.heuristics.MisplacedComparator;

/**
 * Created by Piotrek on 14.05.2016.
 */
public abstract class HeuristicSolver extends PuzzleSolver {
    protected Heuristic heuristicFunction;

    public HeuristicSolver() {
        super();
        this.heuristicFunction = new MisplacedComparator();
    }

    public HeuristicSolver(int depth) {
        super(depth);
        this.heuristicFunction = new MisplacedComparator();
    }

    public HeuristicSolver(Heuristic h) {
        super();
        this.heuristicFunction = h;
    }

    public HeuristicSolver(int depth, Heuristic h) {
        super(depth);
        this.heuristicFunction = h;
    }

    public Heuristic getHeuristicFunction() {
        return this.heuristicFunction;
    }

    public void setHeuristicFunction(Heuristic heuristic) {
        this.heuristicFunction = heuristic;
    }
}
