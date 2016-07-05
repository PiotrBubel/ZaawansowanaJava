package frontend.interfaces;

import exceptions.WrongImageFormatException;
import java.io.IOException;
import javax.swing.JButton;

public interface ImageLoader {

    void loadImage(String path) throws IOException, WrongImageFormatException;

    JButton getPartOfImage(int startX, int startY, int height, int width);

}
