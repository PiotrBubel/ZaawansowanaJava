/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.interfaces;

import java.io.IOException;

/**
 *
 * @author Sebastian
 */
public interface ImageLoader {

    void loadImage(String path)  throws IOException;

    void splitIntoTiles();

}
