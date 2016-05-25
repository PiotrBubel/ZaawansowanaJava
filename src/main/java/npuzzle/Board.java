package npuzzle;

import org.apache.commons.lang.StringUtils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import autosolving.heuristics.Heuristic;
import autosolving.solvers.PuzzleSolver;
import exceptions.BoardWithoutZeroException;
import npuzzle.utils.BoardUtils;

/**
 * @author Piotrek
 */
public class Board {

    /**
     * Designed to work with custom best-first, not safe to use outside this algorithm, may cause
     * deadlocks (in only 4 cases, but still)
     */
    public static boolean STRONG_LOOP_CONTROL = false;

    /**
     * Safe to use, prevents board to create new states witch undo last move
     */
    public static boolean SIMPLE_LOOP_CONTROL = false;

    private int[][] state;
    private List<Board> nextNodes;
    private String path;
    private int pathValue; //used in IDA*

    /**
     * Creates board with given state, other fields are default
     *
     * @param state given state
     */
    public Board(int[][] state) {
        this.state = state.clone();
        nextNodes = null;
        path = "";
    }

    /**
     * Creates copy of given board, use this when you want to copy state and path. Does not copy
     * parentNode
     *
     * @param original npuzzle.Board
     */
    public Board(Board original) {
        state = new int[original.state.length][original.state[0].length];

        for (int x = 0; x < state.length; x++) {
            for (int y = 0; y < state[0].length; y++) {
                state[x][y] = original.state[x][y];
            }
        }
        nextNodes = null;
        path = original.getPath();
        pathValue = original.pathValue;
    }

    public void setNextStepInPath(String step) {
        this.path = path + step;
    }

    public String getPath() {
        return this.path;
    }

    public List<Board> getNextNodes() {
        return this.nextNodes;
    }

    public int[][] getState() {
        return this.state;
    }

    public boolean isCorrect() {
        return BoardUtils.countMisplaced(this) == 0;
    }

    /**
     * @return x, y coordinates of value, x and y are counted from 0, (0,0) is in upper left corner,
     * x goes down, y goes right. Returns -1,-1 when can't find given number.
     */
    public int[] findNumber(int value) {
        int[] coordinates = new int[2];
        coordinates[0] = coordinates[1] = -1;

        for (int x = 0; x < state.length; x++) {
            for (int y = 0; y < state[0].length; y++) {
                if (state[x][y] == value) {
                    coordinates[0] = x;
                    coordinates[1] = y;
                    return coordinates;
                }
            }
        }
        return coordinates;
    }

    /**
     * @return x, y coordinates of Zero, x and y are counted from 0, (0,0) is in upper left corner,
     * x goes down, y goes right. Returns -1,-1 when can't find zero.
     */
    public int[] findZero() {
        return findNumber(0);
    }

    public boolean canMoveRight() {
        if (SIMPLE_LOOP_CONTROL || STRONG_LOOP_CONTROL) {
            if (!StringUtils.isBlank(this.getPath())) {
                if (this.path.toLowerCase().endsWith(Moves.LEFT_CHAR)) {
                    return false;
                }
                if (STRONG_LOOP_CONTROL && (
                        this.path.toLowerCase().endsWith(loopCauseRight1())
                                || this.path.toLowerCase().endsWith(loopCauseRight2())
                )) {
                    return false;
                }
            }
        }
        int[] zeroCoord = findZero();
        return !(zeroCoord[1] == state[0].length - 1);
    }

    private String loopCauseRight1() {  //DWAS
        return Moves.RIGHT_CHAR + Moves.UP_CHAR + Moves.LEFT_CHAR + Moves.DOWN_CHAR;
    }

    private String loopCauseRight2() {   //DSAW
        return Moves.RIGHT_CHAR + Moves.DOWN_CHAR + Moves.LEFT_CHAR + Moves.UP_CHAR;
    }

    public boolean canMoveLeft() {
        if (SIMPLE_LOOP_CONTROL || STRONG_LOOP_CONTROL) {
            if (!StringUtils.isBlank(this.getPath())) {
                if (this.path.toLowerCase().endsWith(Moves.RIGHT_CHAR)) {
                    return false;
                }
                if (STRONG_LOOP_CONTROL && (
                        this.path.toLowerCase().endsWith(loopCauseLeft1())
                                || this.path.toLowerCase().endsWith(loopCauseLeft2())
                )) {
                    return false;
                }
            }
        }
        int[] zeroCoord = findZero();
        return (zeroCoord[1] > 0);
    }

    private String loopCauseLeft1() {  //AWDS
        return Moves.LEFT_CHAR + Moves.UP_CHAR + Moves.RIGHT_CHAR + Moves.DOWN_CHAR;
    }

    private String loopCauseLeft2() {   //ASDW
        return Moves.LEFT_CHAR + Moves.DOWN_CHAR + Moves.RIGHT_CHAR + Moves.UP_CHAR;
    }

    public boolean canMoveUp() {
        if (SIMPLE_LOOP_CONTROL || STRONG_LOOP_CONTROL) {
            if (!StringUtils.isBlank(this.getPath())) {
                if (this.path.toLowerCase().endsWith(Moves.DOWN_CHAR)) {
                    return false;
                }
                if (STRONG_LOOP_CONTROL && (
                        this.path.toLowerCase().endsWith(loopCauseUp1())
                                || this.path.toLowerCase().endsWith(loopCauseUp2())
                )) {
                    return false;
                }
            }
        }
        int[] zeroCoord = findZero();
        return (zeroCoord[0] > 0);
    }

    private String loopCauseUp1() {  //WDSA
        return Moves.UP_CHAR + Moves.RIGHT_CHAR + Moves.DOWN_CHAR + Moves.LEFT_CHAR;
    }

    private String loopCauseUp2() {   //WASD
        return Moves.UP_CHAR + Moves.LEFT_CHAR + Moves.DOWN_CHAR + Moves.RIGHT_CHAR;
    }

    public boolean canMoveDown() {
        if (SIMPLE_LOOP_CONTROL || STRONG_LOOP_CONTROL) {
            if (!StringUtils.isBlank(this.getPath())) {
                if (this.path.toLowerCase().endsWith(Moves.UP_CHAR)) {
                    return false;
                }
                if (STRONG_LOOP_CONTROL && (
                        this.path.toLowerCase().endsWith(loopCauseDown1())
                                || this.path.toLowerCase().endsWith(loopCauseDown2())
                )) {
                    return false;
                }
            }
        }
        int[] zeroCoord = findZero();
        return !(zeroCoord[0] == state.length - 1);
    }

    private String loopCauseDown1() {  //SDWA
        return Moves.DOWN_CHAR + Moves.RIGHT_CHAR + Moves.UP_CHAR + Moves.LEFT_CHAR;
    }

    private String loopCauseDown2() {   //SAWD
        return Moves.DOWN_CHAR + Moves.LEFT_CHAR + Moves.UP_CHAR + Moves.RIGHT_CHAR;
    }

    /**
     * @return changed Board with zero moved right, or null if can't move right
     */
    public Board moveRight() throws BoardWithoutZeroException {
        if (!BoardUtils.containsZero(this)) {
            throw new BoardWithoutZeroException("Trying to move in board without zero");
        }

        if (!canMoveRight()) {
            return null;
        }
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0]][zeroCoord[1] + 1];
        newState[zeroCoord[0]][zeroCoord[1] + 1] = 0;
        //return new npuzzle.Board(newState);
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.RIGHT_CHAR);
        return newB;
    }

    /**
     * @return changed Board with zero moved left, or null if can't move left
     */
    public Board moveLeft() throws BoardWithoutZeroException {
        if (!BoardUtils.containsZero(this)) {
            throw new BoardWithoutZeroException("Trying to move in board without zero");
        }
        if (!canMoveLeft()) {
            return null;
        }
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0]][zeroCoord[1] - 1];
        newState[zeroCoord[0]][zeroCoord[1] - 1] = 0;
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.LEFT_CHAR);
        return newB;
    }

    /**
     * @return changed Board with zero moved up, or null if can't move up
     */
    public Board moveUp() throws BoardWithoutZeroException {
        if (!BoardUtils.containsZero(this)) {
            throw new BoardWithoutZeroException("Trying to move in board without zero");
        }
        if (!canMoveUp()) {
            return null;
        }
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0] - 1][zeroCoord[1]];
        newState[zeroCoord[0] - 1][zeroCoord[1]] = 0;
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.UP_CHAR);
        return newB;
    }

    /**
     * @return changed Board with zero moved down, or null if can't move down
     */
    public Board moveDown() throws BoardWithoutZeroException {
        if (!BoardUtils.containsZero(this)) {
            throw new BoardWithoutZeroException("Trying to move in board without zero");
        }
        if (!canMoveDown()) {
            return null;
        }
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0] + 1][zeroCoord[1]];
        newState[zeroCoord[0] + 1][zeroCoord[1]] = 0;
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.DOWN_CHAR);
        return newB;
    }

    /**
     * Method returns possible states from this Board in given order
     */
    public List<Board> getPossibleStates(String ord) throws BoardWithoutZeroException {
        String order = new String(ord);
        if (order.contains("r") || order.contains("R")) {
            order = BoardUtils.randomizeOrder();
        }
        List<Board> possibleStates = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Board toAdd = this.move(order.charAt(i));
            if (toAdd != null) {
                possibleStates.add(toAdd);
            }
        }
        if (possibleStates.isEmpty()) {
            System.out.println("DEADLOCK - brak mozliwosci ruchu bez zapetlenia.");
        }
        return possibleStates;
    }

    /**
     * Method returns possible states from this Board in given order
     */
    public List<Board> getPossibleStates(Heuristic heuristics) throws BoardWithoutZeroException {
        List<Board> possibleStates = this.getPossibleStates("rrrr");
        Collections.sort(possibleStates, heuristics);
        return possibleStates;
    }

    public Board findAnswerWithDFS(String order, int depth, PrintStream stream) throws BoardWithoutZeroException {
        if (depth >= 0) {
            this.nextNodes = getPossibleStates(order);
            PuzzleSolver.addCreated(this.nextNodes.size());
            for (Board nextNode : nextNodes) {
                if (stream != null && !nextNode.getPath().isEmpty() && nextNode.getPath() != null) {
                    stream.println(nextNode.getPath());
                }
                if (nextNode.isCorrect()) {
                    return nextNode;
                } else {
                    Board possibleAnswer = nextNode.findAnswerWithDFS(order, depth - 1, stream);
                    if (possibleAnswer != null) {
                        return possibleAnswer;
                    }
                }
            }
        } else {
            this.nextNodes = null;
            return null;
        }
        return null;
    }

    public Board findAnswerWithIDA(Heuristic heuristics, int maxCost, PrintStream stream) throws BoardWithoutZeroException {
        //FIXME not sure if it works exactly as definition says

        if (maxCost > 0) {
            this.nextNodes = getPossibleStates(heuristics);
            this.nextNodes = BoardUtils.deleteBoardsAboveMaxHeuristicCost(this.nextNodes, maxCost, heuristics);

            PuzzleSolver.addCreated(this.nextNodes.size());
            for (Board nextNode : nextNodes) {
                if (stream != null && !nextNode.getPath().isEmpty() && nextNode.getPath() != null) {
                    stream.println(nextNode.getPath());
                }
                if (nextNode.isCorrect()) {
                    return nextNode;
                } else {
                    Board possibleAnswer = nextNode.findAnswerWithIDA(heuristics, maxCost - 1, stream);
                    if (possibleAnswer != null) {
                        return possibleAnswer;
                    }
                }
            }
        } else {
            this.nextNodes = null;
            return null;
        }
        return null;
    }

    /**
     * @param moves - String wih moves to make
     * @return changed Board, or null if wrong direction given or can't move in given direction
     */
    public Board allMoves(String moves) throws BoardWithoutZeroException {
        Board afterMoves = this;
        for (char c : moves.toCharArray()) {
            afterMoves = afterMoves.move(c);
        }
        return afterMoves;
    }

    /**
     * @param direction [p|l|g|d]
     * @return changed Board, or null if wrong direction given or can't move in given direction
     */
    public Board move(char direction) throws BoardWithoutZeroException {
        String directionString = new String(new char[]{direction});
        switch (directionString) {
            case Moves.UP_CHAR:
                if (canMoveUp()) {
                    return moveUp();
                } else {
                    return null;
                }
            case Moves.DOWN_CHAR:
                if (canMoveDown()) {
                    return moveDown();
                } else {
                    return null;
                }
            case Moves.LEFT_CHAR:
                if (canMoveLeft()) {
                    return moveLeft();
                } else {
                    return null;
                }
            case Moves.RIGHT_CHAR:
                if (canMoveRight()) {
                    return moveRight();
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object other) {
        Board otherB = (Board) other;
        try {
            for (int i = 0; i < this.state.length; i++) {
                for (int j = 0; j < this.state[0].length; j++) {
                    if (this.state[i][j] != otherB.getState()[i][j]) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
