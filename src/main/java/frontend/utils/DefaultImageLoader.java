package frontend.utils;

import frontend.interfaces.ImageLoader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DefaultImageLoader implements ImageLoader {

    private BufferedImage loadedImage;

    @Override
    public void loadImage(String path) throws IOException {
        loadedImage = ImageIO.read(new File(path));
    }

    @Override
    public void splitIntoTiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
