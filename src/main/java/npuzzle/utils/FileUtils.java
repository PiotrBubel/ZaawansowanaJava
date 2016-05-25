/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npuzzle.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import npuzzle.Board;

/**
 * @author Piotrek
 */
public class FileUtils {

    public static void saveBoard(String filePath, Board board) {
        try (PrintStream out = new PrintStream(new FileOutputStream(filePath))) {
            int[][] state = board.getState();
            for (int x = 0; x < state.length; x++) {
                for (int y = 0; y < state[0].length; y++) {
                    out.print(state[x][y]);
                    out.print(" ");
                }
                out.println("");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Encountered error when saving to file: " + ex.getMessage());
        }
    }

    public static Board loadBoard(String filePath) throws UnsolvableBoardException, BoardWithoutZeroException {
        int[][] state;

        ArrayList<String> lines = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(filePath))) {
            while (in.hasNextLine()) {
                lines.add(in.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Encountered error when loading from file: " + ex.getMessage());
        }
        ArrayList<String[]> l = new ArrayList<>();
        for (String line : lines) {
            l.add(line.split(" "));
        }

        state = new int[lines.size()][l.get(0).length];

        for (int x = 0; x < state.length; x++) {
            for (int y = 0; y < state[0].length; y++) {
                state[x][y] = Integer.parseInt(l.get(x)[y]);
            }
        }

        Board loaded = new Board(state);

        if (!BoardUtils.containsZero(loaded)) {
            throw new BoardWithoutZeroException("Board loaded from file does not contain zero");
        }

        if (BoardUtils.correctState(state)) {
            return loaded;
        } else {
            throw new UnsolvableBoardException("Board loaded from file is unsolvable");
        }
    }
}
