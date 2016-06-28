package frontend.animator;

import exceptions.BoardWithoutZeroException;
import frontend.contextMenu.ContextMenuListener;
import frontend.interfaces.BoardController;
import frontend.utils.AnimatorBoardController;
import frontend.utils.DefaultImageLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import npuzzle.Board;
import static npuzzle.utils.BoardUtils.reverseMoves;

public class AnimatorWindow extends javax.swing.JFrame {

    private String pathToWin;
    private Board startingBoard;
    private int move = 0;
    private Timer timer;
    private BoardController puzzleBoard;

    public AnimatorWindow(Board board) {
        initComponents();
        this.pathToWin = board.getPath();
        this.startingBoard = getStartingBoard(board);
        puzzleBoard = new AnimatorBoardController(puzzlePanel, new Board(startingBoard), pathToWin);
        puzzleBoard.setImageLoader(null);
        addMouseListener(new ContextMenuListener(new DefaultImageLoader(), puzzleBoard));

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (move < pathToWin.length() && !pathToWin.isEmpty()) {
                    puzzleBoard.move(move);
                    move++;
                    puzzleBoard.createBoardOnWindow();
                } else {
                    timer.stop();
                }
            }
        };
        timer = new Timer(500, actionListener);
        puzzleBoard.createBoardOnWindow();
    }

    private Board getStartingBoard(Board board) {
        String path = reverseMoves(board.getPath());
        Board temp = new Board(board);
        for (int i = 0; i < path.length(); i++) {
            try {
                temp = temp.move(path.charAt(i));
            } catch (BoardWithoutZeroException ex) {
            }
        }
        return temp;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        puzzlePanel = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        previousMove = new javax.swing.JButton();
        nextMove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout puzzlePanelLayout = new javax.swing.GroupLayout(puzzlePanel);
        puzzlePanel.setLayout(puzzlePanelLayout);
        puzzlePanelLayout.setHorizontalGroup(
            puzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        puzzlePanelLayout.setVerticalGroup(
            puzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        previousMove.setText("<<");
        previousMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousMoveActionPerformed(evt);
            }
        });

        nextMove.setText(">>");
        nextMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextMoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousMove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextMove))
                    .addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playButton)
                    .addComponent(stopButton)
                    .addComponent(resetButton)
                    .addComponent(previousMove)
                    .addComponent(nextMove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        timer.stop();
        timer.start();
    }//GEN-LAST:event_playButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        timer.stop();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        timer.stop();
        move = 0;
        if (!pathToWin.isEmpty()) {
            puzzleBoard.setBoard(startingBoard);
            puzzleBoard.createBoardOnWindow();
        }
        timer.start();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void nextMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextMoveActionPerformed
        timer.stop();
        if (move < pathToWin.length() && !pathToWin.isEmpty()) {
            puzzleBoard.move(move);
            move++;
            puzzleBoard.createBoardOnWindow();
        }
    }//GEN-LAST:event_nextMoveActionPerformed

    private void previousMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousMoveActionPerformed
        timer.stop();

        if (move > 0 && !pathToWin.isEmpty()) {
            move--;
            puzzleBoard.setBoard(startingBoard);
            for (int i = 0; i < move; i++) {
                puzzleBoard.move(i);
            }
            puzzleBoard.createBoardOnWindow();

        }

    }//GEN-LAST:event_previousMoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton nextMove;
    private javax.swing.JButton playButton;
    private javax.swing.JButton previousMove;
    private javax.swing.JPanel puzzlePanel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
