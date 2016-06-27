package frontend.utils;

import exceptions.WrongImageFormatException;
import frontend.interfaces.ImageLoader;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DefaultImageLoader implements ImageLoader {

    private static final int DEFAULT_HEIGHT = 320;
    private static final int DEFAULT_WIDTH = 320;

    private BufferedImage loadedImage;

    @Override
    public void loadImage(String path) throws IOException, WrongImageFormatException {
        loadedImage = ImageIO.read(new File(path));
        if (loadedImage != null) {
            loadedImage = scaleImage(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        } else {
            throw new WrongImageFormatException("Can't load image - wrong format");
        }

    }

    @Override
    public JButton getPartOfImage(int startX, int startY, int height, int width) {

        BufferedImage subImage = loadedImage.getSubimage(startX, startY, height, width);
        JButton tile = new JButton(new ImageIcon(subImage));
        tile.setBorder(BorderFactory.createEmptyBorder());
        tile.setContentAreaFilled(false);

        return tile;
    }

    public BufferedImage scaleImage(int width, int height) {
        Image temp = loadedImage.getScaledInstance(height, width, Image.SCALE_SMOOTH);
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(temp, 0, 0, null);
        g2d.dispose();

        return scaledImage;
    }
}
