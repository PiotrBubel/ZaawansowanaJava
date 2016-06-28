/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import frontend.interfaces.BoardController;
import frontend.interfaces.ImageLoader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Sebastian
 */
public class ContextMenuListener extends MouseAdapter {

    ContextMenu contextMenu;

    ContextMenuListener(ImageLoader imageLoader, BoardController puzzleBoard) {
        contextMenu = new ContextMenu(imageLoader, puzzleBoard);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    private void showMenu(MouseEvent e) {
        contextMenu.show(e.getComponent(), e.getX(), e.getY());
    }
}
