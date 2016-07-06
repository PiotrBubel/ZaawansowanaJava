package npuzzle.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import autosolving.heuristics.Heuristic;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;
import npuzzle.Moves;

public class BoardUtils {

    public static void printBoard(Board b) {
        int[][] state = b.getState();
        System.out.println("");
        System.out.println("---------");
        for (int x = 0; x < state.length; x++) {
            for (int y = 0; y < state[0].length; y++) {
                System.out.print(state[x][y]);
                if (y < state[0].length - 1) {
                    System.out.print("\t");
                }
            }
            if (x < state.length - 1) {
                System.out.println();
            }
        }
        System.out.println();

        if (b.getPath() != null && !b.getPath().isEmpty()) {
            System.out.println("Moves: " + b.getPath().length());
            System.out.println("Path: " + b.getPath());
        } else {
            System.out.println("No path attached");
        }
    }

    /**
     * Method checks if state is correct for N-Puzzle It checks if there is every number from 0to N,
     * with no duplicates or negative numbers
     *
     * @param state table with state
     * @return true if state id correct, false otherwise
     */
    public static boolean correctState(int[][] state) {

        List<Integer> intList = new ArrayList<>();
        for (int[] line : state) {
            for (int i : line) {
                intList.add(i);
            }
        }
        Collections.sort(intList);
        for (int i = 0; i < intList.size(); i++) {
            if (i != intList.get(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method randomize order for solving puzzle
     *
     * @return string (w,s,a,d) in random order
     */
    public static String randomizeOrder() {
        List<String> ord = new ArrayList<>();
        ord.add(Moves.DOWN_CHAR);
        ord.add(Moves.LEFT_CHAR);
        ord.add(Moves.RIGHT_CHAR);
        ord.add(Moves.UP_CHAR);
        String randOrd = new String();
        while (ord.size() > 0) {
            Random r = new Random();
            int i = r.nextInt(ord.size());
            randOrd = randOrd + ord.get(i);
            ord.remove(i);
        }
        return randOrd;
    }

    public static int countMisplaced(Board b) {
        int[][] state = b.getState();
        int misplaced = 0;
        int correctValue = 1;

        for (int x = 0; x < state.length; x++) {
            for (int y = 0; y < state[0].length; y++) {
                if (x == state.length - 1 && y == state[0].length - 1) {
                    correctValue = 0;
                }
                if (state[x][y] != correctValue) {
                    misplaced++;
                }
                correctValue++;
            }
        }
        return misplaced;
    }

    /**
     * @return arranged (correct) board of given size
     */
    public static Board buildArrangedBoard(int xState, int yState) {
        Board randomizedBoard = null;
        int[][] state = new int[xState][yState];
        int correctValue = 1;

        for (int x = 0; x < state.length; x++) {
            for (int y = 0; y < state[0].length; y++) {
                if (x == state.length - 1 && y == state[0].length - 1) {
                    correctValue = 0;
                }
                state[x][y] = correctValue;
                correctValue++;
            }
        }
        randomizedBoard = new Board(state);
        return randomizedBoard;
    }

    /**
     * @param board           - arranged board to randomize
     * @param maxMovesToSolve - moves to perform on given board
     * @return board after random moves, board path is cleared
     */
    public static Board randomizeBoard(Board board, int maxMovesToSolve) throws BoardWithoutZeroException {
        boolean temp_lc = Board.STRONG_LOOP_CONTROL;
        Board.STRONG_LOOP_CONTROL = false;    //FIXME dont work with strong loop control enabled
        Board randomizedBoard = new Board(board);
        int moves = 0;

        while (moves < maxMovesToSolve) {
            Random rand = new Random();
            int direction = rand.nextInt(4);// % 4;

            switch (direction) {
                case 0:
                    if (randomizedBoard.canMoveUp()) {
                        randomizedBoard = randomizedBoard.moveUp();
                        moves++;
                    }
                    break;
                case 1:
                    if (randomizedBoard.canMoveDown()) {
                        randomizedBoard = randomizedBoard.moveDown();
                        moves++;
                    }
                    break;
                case 2:
                    if (randomizedBoard.canMoveLeft()) {
                        randomizedBoard = randomizedBoard.moveLeft();
                        moves++;
                    }
                    break;
                case 3:
                    if (randomizedBoard.canMoveRight()) {
                        randomizedBoard = randomizedBoard.moveRight();
                        moves++;
                    }
                    break;
            }
        }
        Board.STRONG_LOOP_CONTROL = temp_lc;
        return new Board(randomizedBoard.getState());
    }

    /**
     * @return board of given size, after random moves, should never return null if
     * buildArrangedBoard works correctly (and it works correctly)
     */
    public static Board randomizeBoard(int xState, int yState, int maxMovesToSolve) {
        try {
            return BoardUtils.randomizeBoard(BoardUtils.buildArrangedBoard(xState, yState), maxMovesToSolve);
        } catch (BoardWithoutZeroException e) {
            return null;
        }
    }

    /**
     * @return reversed moves, which can be used to bring board to first state
     */
    public static String reverseMoves(String moves) {
        char[] directions = new StringBuilder(moves).reverse().toString().toCharArray();
        String reverseM = "";
        for (char s : directions) {
            boolean addedDirection = false;
            String d = new String(new char[]{s});
            if (Moves.RIGHT_CHAR.equals(d)) {
                reverseM = reverseM + Moves.LEFT_CHAR;
                addedDirection = true;
            }
            if (Moves.LEFT_CHAR.equals(d)) {
                reverseM = reverseM + Moves.RIGHT_CHAR;
                addedDirection = true;
            }
            if (Moves.UP_CHAR.equals(d)) {
                reverseM = reverseM + Moves.DOWN_CHAR;
                addedDirection = true;
            }
            if (Moves.DOWN_CHAR.equals(d)) {
                reverseM = reverseM + Moves.UP_CHAR;
                addedDirection = true;
            }

            if (!addedDirection) {
                return null;
            }
        }

        return reverseM;
    }

    /**
     * @return true if given boards state contains zero
     */
    public static boolean containsZero(Board b) {
        for (int[] line : b.getState()) {
            for (int i : line) {
                if (i == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void checkBoard(Board board) throws BoardWithoutZeroException, UnsolvableBoardException {
        if (!BoardUtils.containsZero(board)) {
            throw new BoardWithoutZeroException("Trying to solve board without zero");
        }
        if (!BoardUtils.correctState(board.getState())) {
            throw new UnsolvableBoardException("Trying to solve unsolvable board");
        }
    }

    public static List<Board> deleteBoardsAboveMaxHeuristicCost(List<Board> list, int maxCost, Heuristic heuristic) {
        List<Board> toReturn = new ArrayList<>();
        for (Board b : list) {
            if (heuristic.heuristicValue(b) <= maxCost) {
                toReturn.add(b);
            }
        }
        return toReturn;
    }

    public static Board getStartingBoard(Board board) {
        String path = reverseMoves(board.getPath());
        Board temp = new Board(board);
        for (int i = 0; i < path.length(); i++) {
            try {
                temp = temp.move(path.charAt(i));
            } catch (BoardWithoutZeroException ex) {
            }
        }
        return temp;
    }
}
