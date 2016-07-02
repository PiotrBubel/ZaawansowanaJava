/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.winGame;

/**
 *
 * @author Lalu
 */
public class WinGameController {

    private String path;
    private double time;
    private int rows;
    private int columns;

    public WinGameController(String path, double time, int rows, int columns) {
        this.path = path;
        this.time = time;
        this.rows = rows;
        this.columns = columns;
    }

    public double getTime() {
        return time;
    }

    public int getRows() {
        return rows;
    }

    public String getPath() {
        return path;
    }

    public int getColumns() {
        return columns;
    }

}
