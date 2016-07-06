package frontend.winGame;

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
