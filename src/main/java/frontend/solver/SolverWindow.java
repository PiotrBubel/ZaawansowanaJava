package frontend.solver;

import exceptions.BoardWithoutZeroException;
import exceptions.UnsolvableBoardException;
import frontend.animator.AnimatorWindow;
import javax.swing.JOptionPane;
import npuzzle.Board;

public class SolverWindow extends javax.swing.JFrame {

    private SolverController solver;
    Heuristics heuristic;

    public SolverWindow(Board boardToSolve) {
        this(boardToSolve, new SolverController(boardToSolve));
    }

    public SolverWindow(Board boardToSolve, SolverController controller) {
        solver = controller;
        initComponents();
        heuristicButtonGroup.setSelected(manhattanRadioButton.getModel(), true);
        heuristic = Heuristics.MANHATTAN;
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
        setTitle("Solver");

        solveButton.setText("Solve");
        solveButton.setName("solve"); // NOI18N
        solveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveButtonActionPerformed(evt);
            }
        });

        showButton.setText("Show");
        showButton.setName("show"); // NOI18N
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
        algorithmList.setName("algorithms"); // NOI18N
        algorithmList.setSelectedIndex(0);
        algorithmScrollPane.setViewportView(algorithmList);

        depthSpinner.setModel(new javax.swing.SpinnerNumberModel(20, 1, null, 1));
        depthSpinner.setName("depth"); // NOI18N

        heuristicButtonGroup.add(manhattanRadioButton);
        manhattanRadioButton.setText("Manhattan");
        manhattanRadioButton.setName("manhattan"); // NOI18N
        manhattanRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manhattanRadioButtonActionPerformed(evt);
            }
        });

        heuristicButtonGroup.add(misplacedRadioButton);
        misplacedRadioButton.setText("Missplaced");
        misplacedRadioButton.setName("missplaced"); // NOI18N
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
            animatorWindow.setVisible(true);
            this.dispose();
            return;
        }
        JOptionPane.showMessageDialog(null, "Puzzle are not solved");
    }//GEN-LAST:event_showButtonActionPerformed

    private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveButtonActionPerformed
        try {
            solver.setSolver(getAlgorithm(), heuristic, (int) depthSpinner.getValue());
            solver.solve();
            if (solver.getBoard() != null) {
                JOptionPane.showMessageDialog(null, "Solved succesfully");
            }

        } catch (BoardWithoutZeroException | UnsolvableBoardException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_solveButtonActionPerformed

    private void manhattanRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manhattanRadioButtonActionPerformed
        heuristic = Heuristics.MANHATTAN;
    }//GEN-LAST:event_manhattanRadioButtonActionPerformed

    private void misplacedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misplacedRadioButtonActionPerformed
        heuristic = Heuristics.MISPLACED;
    }//GEN-LAST:event_misplacedRadioButtonActionPerformed

    public Algorithm getAlgorithm() {
        int value = algorithmList.getSelectedIndex();
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
