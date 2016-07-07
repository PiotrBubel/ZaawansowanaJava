package frontend.animator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import npuzzle.Board;

public final class AnimatorWindow extends javax.swing.JFrame {

    private Timer timer;
    private Animator animator;

    public AnimatorWindow(Board endBoardState ){
        this(endBoardState, endBoardState.getPath());
    }

    public AnimatorWindow(Board endBoardstate, String pathToWin) {
        initComponents();
        animator = new Animator(puzzlePanel, endBoardstate, pathToWin);
        addMouseListener(animator.getContextMenu(puzzlePanel.getWidth(), puzzlePanel.getHeight()));
        initTimer();
    }
    
    private void initTimer() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (!animator.nextMove()) {
                    timer.stop();
                }
            }
        };
        timer = new Timer(500, actionListener);
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
        setPreferredSize(new java.awt.Dimension(450, 480));
        setResizable(false);

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

        puzzlePanel.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout puzzlePanelLayout = new javax.swing.GroupLayout(puzzlePanel);
        puzzlePanel.setLayout(puzzlePanelLayout);
        puzzlePanelLayout.setHorizontalGroup(
            puzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        puzzlePanelLayout.setVerticalGroup(
            puzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousMove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextMove))
                    .addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
        animator.resetMoves();
        timer.start();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void nextMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextMoveActionPerformed
        timer.stop();
        animator.nextMove();
    }//GEN-LAST:event_nextMoveActionPerformed

    private void previousMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousMoveActionPerformed
        timer.stop();
        animator.previousMove();
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
