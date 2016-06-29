package frontend.solver;

import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import frontend.animator.AnimatorWindow;
import javax.swing.JOptionPane;
import npuzzle.Board;

public class SolverWindow extends javax.swing.JFrame {

    SolverController solver;
    Heuristics heuristic;
    Algorithm algorithm;

    public SolverWindow(Board boardToSolve) {
        solver = new SolverController(boardToSolve);
        initComponents();
        heuristicButtonGroup.setSelected(manhattanRadioButton.getModel(), true);
        heuristic = Heuristics.MANHATTAN;
        algorithm = Algorithm.A_STAR;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heuristicButtonGroup = new javax.swing.ButtonGroup();
        solveButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        algorithmScrollPane = new javax.swing.JScrollPane();
        algorithmList = new javax.swing.JList();
        depthSpinner = new javax.swing.JSpinner();
        manhattanRadioButton = new javax.swing.JRadioButton();
        misplacedRadioButton = new javax.swing.JRadioButton();
        depthLabel = new javax.swing.JLabel();
        heuristicLabel = new javax.swing.JLabel();
        algorithmLabel = new javax.swing.JLabel();

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

        algorithmList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "A*", "Best First", "BFS", "DFS", "IDA*", "IDFS" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        algorithmList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        algorithmList.setSelectedIndex(0);
        algorithmScrollPane.setViewportView(algorithmList);

        depthSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(1), null, Integer.valueOf(1)));

        heuristicButtonGroup.add(manhattanRadioButton);
        manhattanRadioButton.setText("Manhattan");
        manhattanRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manhattanRadioButtonActionPerformed(evt);
            }
        });

        heuristicButtonGroup.add(misplacedRadioButton);
        misplacedRadioButton.setText("Missplaced");
        misplacedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misplacedRadioButtonActionPerformed(evt);
            }
        });

        depthLabel.setText("Max Depth (non-heuristic)");

        heuristicLabel.setText("Heuristic");

        algorithmLabel.setText("Algorithm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(algorithmLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(solveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(algorithmScrollPane))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(manhattanRadioButton)
                                    .addComponent(misplacedRadioButton)
                                    .addComponent(depthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(depthLabel)
                                    .addComponent(heuristicLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(showButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(algorithmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(algorithmScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(depthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heuristicLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(manhattanRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(misplacedRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(solveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if (solver.isSolved()) {
            AnimatorWindow animatorWindow = new AnimatorWindow(solver.getBoard());
            animatorWindow.show();
            this.dispose();
            return;
        }
        JOptionPane.showMessageDialog(null, "Puzzle are not solved");
    }//GEN-LAST:event_showButtonActionPerformed

    private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveButtonActionPerformed
        try {
            solver.setSolver(getAlgorithm(algorithmList.getSelectedIndex()), heuristic, (int) depthSpinner.getValue());
            solver.solve();
            if (solver.getBoard() != null) {
                JOptionPane.showMessageDialog(null, "Solved succesfully");
            }

        } catch (BoardWithoutZeroException | UnsolvableBoardException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_solveButtonActionPerformed

    private void manhattanRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manhattanRadioButtonActionPerformed
        // TODO add your handling code here:
        heuristic = Heuristics.MANHATTAN;
    }//GEN-LAST:event_manhattanRadioButtonActionPerformed

    private void misplacedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misplacedRadioButtonActionPerformed
        // TODO add your handling code here:
        heuristic = Heuristics.MISPLACED;
    }//GEN-LAST:event_misplacedRadioButtonActionPerformed

    private Algorithm getAlgorithm(int value) {
        switch (value) {
            case 0:
                return Algorithm.A_STAR;
            case 1:
                return Algorithm.BEST_FIRST;
            case 2:
                return Algorithm.BFS;
            case 3:
                return Algorithm.DFS;
            case 4:
                return Algorithm.IDA_STAR;
            case 5:
                return Algorithm.IDFS;
        }
        return Algorithm.A_STAR;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algorithmLabel;
    private javax.swing.JList algorithmList;
    private javax.swing.JScrollPane algorithmScrollPane;
    private javax.swing.JLabel depthLabel;
    private javax.swing.JSpinner depthSpinner;
    private javax.swing.ButtonGroup heuristicButtonGroup;
    private javax.swing.JLabel heuristicLabel;
    private javax.swing.JRadioButton manhattanRadioButton;
    private javax.swing.JRadioButton misplacedRadioButton;
    private javax.swing.JButton showButton;
    private javax.swing.JButton solveButton;
    // End of variables declaration//GEN-END:variables
}
