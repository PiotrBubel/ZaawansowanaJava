package frontend.contextMenu;

import frontend.interfaces.BoardController;
import frontend.interfaces.ImageLoader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContextMenuListener extends MouseAdapter {

    ContextMenu contextMenu;

    public ContextMenuListener(ImageLoader imageLoader, BoardController puzzleBoard) {
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
