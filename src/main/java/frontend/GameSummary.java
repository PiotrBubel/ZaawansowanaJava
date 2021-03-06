/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author Lalu
 */
public class GameSummary {
    
    private String playerName;
    private String solution; 
    private double time;
    private int rows;
    private int columns;
    private int stepsNumber;

    /**
     * This object is a representation of database table and store 
     * the most important info about the game
     * @param playerName
     * @param solution - path which was user solution of the game
     * @param time - duration of the game
     * @param rows
     * @param columns
     * @param stepsNumber - number of steps made by user
     */
    public GameSummary(String playerName, String solution, double time, int rows, int columns, int stepsNumber) {
        this.playerName = playerName;
        this.solution = solution;
        this.time = time;
        this.rows = rows;
        this.columns = columns;
        this.stepsNumber = stepsNumber;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public String getSolution() {
        return solution;
    }

    public double getTime() {
        return time;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    public int getStepsNumber() {
        return stepsNumber;
    }    
}
