package frontend.contextMenu;

import exceptions.WrongImageFormatException;
import frontend.interfaces.BoardController;
import frontend.interfaces.ImageLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

class ContextMenu extends JPopupMenu {

    private ImageLoader imageLoader;
    private BoardController puzzleBoard;

    ContextMenu(ImageLoader imageLoader, BoardController puzzleBoard) {
        this.imageLoader = imageLoader;
        this.puzzleBoard = puzzleBoard;

        JMenuItem loadImageOption = new JMenuItem("Load Image");
        JMenuItem deleteImageOption = new JMenuItem("Delete Image");
        add(loadImageOption);
        add(deleteImageOption);
        loadImageOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loadImage();
            }
        });

        deleteImageOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deleteImage();
            }
        });

    }

    private void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();

            try {
                imageLoader.loadImage(selectedFile);
                JOptionPane.showMessageDialog(null, "Loaded Image succesfuly");
                puzzleBoard.setImageLoader(imageLoader);
                puzzleBoard.createBoardOnWindow();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Loading Image failed");
            } catch (WrongImageFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }

    private void deleteImage() {
        puzzleBoard.setImageLoader(null);
        puzzleBoard.createBoardOnWindow();
    }
}
