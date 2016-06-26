/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.interfaces;

import exceptions.WrongImageFormatException;
import java.io.IOException;
import javax.swing.JButton;

/**
 *
 * @author Sebastian
 */
public interface ImageLoader {

    void loadImage(String path)  throws IOException,WrongImageFormatException;

    JButton getPartOfImage(int startX,int startY, int height,int width);

}
