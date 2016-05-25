package npuzzle;

import org.apache.commons.lang.StringUtils;

import java.util.List;


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
    private Board parentNode;
    private String path;
    private int pathValue; //used in IDA*

    /**
     * Creates board with given state, other fields are default
     *
     * @param state given state
     */
    public Board(int[][] state) {
        this.state = state.clone();
        parentNode = null;
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
        parentNode = null;
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

    public Board getParentNode() {
        return this.parentNode;
    }

    public void setParentNode(Board parent) {
        this.parentNode = parent;
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
     * x goes down, y goes right
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
     * x goes down, y goes right
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

    public Board moveRight() {
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0]][zeroCoord[1] + 1];
        newState[zeroCoord[0]][zeroCoord[1] + 1] = 0;
        //return new npuzzle.Board(newState);
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.RIGHT_CHAR);
        newB.setParentNode(this);
        return newB;
    }

    public Board moveLeft() {
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0]][zeroCoord[1] - 1];
        newState[zeroCoord[0]][zeroCoord[1] - 1] = 0;
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.LEFT_CHAR);
        newB.setParentNode(this);
        return newB;
    }

    public Board moveUp() {
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0] - 1][zeroCoord[1]];
        newState[zeroCoord[0] - 1][zeroCoord[1]] = 0;
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.UP_CHAR);
        newB.setParentNode(this);
        return newB;
    }

    public Board moveDown() {
        Board newB = new Board(this);
        int[][] newState = newB.state;
        int[] zeroCoord = findZero();

        newState[zeroCoord[0]][zeroCoord[1]] = newState[zeroCoord[0] + 1][zeroCoord[1]];
        newState[zeroCoord[0] + 1][zeroCoord[1]] = 0;
        newB.path = new String(this.path);
        newB.setNextStepInPath(Moves.DOWN_CHAR);
        newB.setParentNode(this);
        return newB;
    }

    /**
     * @param moves - String wih moves to make
     * @return changed Board, or null if wrong direction given or can't move in given
     * direction
     */
    public Board allMoves(String moves) {
        Board afterMoves = this;
        for (char c : moves.toCharArray()) {
            afterMoves = afterMoves.move(c);
        }
        return afterMoves;
    }

    /**
     * @param direction [w|s|a|d]
     * @return changed npuzzle.Board, or null if wrong direction given or can't move in given
     * direction
     */
    public Board move(char direction) {
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
