package frontend.interfaces;

import javax.swing.JPanel;

public interface BoardController {

    JPanel createBoardOnWindow();

    public void setImageLoader(ImageLoader imageLoader);

    void createTiles(JPanel drawingPanel);

    void move();
}
