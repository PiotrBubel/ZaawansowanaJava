package frontend.solver;

import autosolving.heuristics.AManhattanDistanceComparator;
import autosolving.solvers.algorithms.BestFirstSearch;
import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import frontend.animator.AnimatorWindow;
import javax.swing.JOptionPane;
import npuzzle.Board;

public class SolverWindow extends javax.swing.JFrame {

    private Board board;
    private boolean isSolved;

    public SolverWindow(Board boardToSolve) {
        this.board = new Board(boardToSolve.getState());
        isSolved = false;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        solveButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        solveButton.setText("Solve");
        solveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveButtonActionPerformed(evt);
            }
        });

        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(solveButton)
                    .addComponent(showButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(solveButton)
                .addGap(18, 18, 18)
                .addComponent(showButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if (isSolved) {
            AnimatorWindow animatorWindow = new AnimatorWindow(board);
            animatorWindow.show();
            this.dispose();
            return;
        }
        JOptionPane.showMessageDialog(null, "Puzzle are not solved");
    }//GEN-LAST:event_showButtonActionPerformed

    private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveButtonActionPerformed
        try {
            BestFirstSearch solver = new BestFirstSearch(new AManhattanDistanceComparator());
            board = solver.solve(board);
            isSolved = true;
            System.out.println(board.getPath());
        } catch (BoardWithoutZeroException | UnsolvableBoardException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_solveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton showButton;
    private javax.swing.JButton solveButton;
    // End of variables declaration//GEN-END:variables
}
