/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.statistics;

import database.DatabaseUtils;
import frontend.GameSummary;
import frontend.animator.AnimatorWindow;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import npuzzle.Board;
import npuzzle.utils.BoardUtils;

/**
 *
 * @author Lalu
 */
public class StatisticsWindow extends javax.swing.JFrame {

    private StatisticsWindowController statisticsController;
    private JButton animateButton;
    private JLabel columnsLabel;
    private JComboBox<String> columnsNumberComboBox;
    private JLabel informationLabel;
    private JScrollPane jScrollPane1;
    private JButton loadStatisticsButton;
    private JLabel rowsLabel;
    private JComboBox<String> rowsNumberComboBox;
    private JLabel setTheBoardSizeLabel;
    private JTable statisticsTable;

    public StatisticsWindow() {
        statisticsController = new StatisticsWindowController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setTheBoardSizeLabel = new JLabel();
        rowsLabel = new JLabel();
        columnsLabel = new JLabel();
        loadStatisticsButton = new JButton();
        animateButton = new JButton();
        rowsNumberComboBox = new JComboBox<>();
        columnsNumberComboBox = new JComboBox<>();
        informationLabel = new JLabel();
        statisticsTable = new JTable();
        jScrollPane1 = new JScrollPane();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Statistics");

        setTheBoardSizeLabel.setFont(new Font("Tahoma", 0, 14));
        setTheBoardSizeLabel.setText("Set the board size");

        rowsLabel.setText("rows");
        columnsLabel.setText("columns");

        loadStatisticsButton.setText("load statistics");
        loadStatisticsButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadStatisticsButtonActionPerformed(evt);
            }
        });

        animateButton.setText("animate");
        animateButton.setEnabled(false);
        animateButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animateButtonActionPerformed(evt);
            }
        });

        rowsNumberComboBox.setModel(new DefaultComboBoxModel<>(statisticsController.getRowsTable()));
        columnsNumberComboBox.setModel(new DefaultComboBoxModel<>(statisticsController.getColumnsTable()));

        informationLabel.setText(" ");
        informationLabel.setVisible(true);

        statisticsTable.setVisible(false);
        jScrollPane1.setViewportView(statisticsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(columnsLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(columnsNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rowsLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(rowsNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(setTheBoardSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 108, Short.MAX_VALUE)
                                        .addComponent(loadStatisticsButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(animateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(informationLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(setTheBoardSizeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rowsLabel)
                                .addComponent(rowsNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(loadStatisticsButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(columnsLabel)
                                        .addComponent(columnsNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(informationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(animateButton)
                        .addGap(10, 10, 10)
                        .addContainerGap())
        );

        pack();
    }

    private void loadStatisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        statisticsTable.setModel(new DefaultTableModel());
        if(!statisticsController.getSortedStatistics(Integer.parseInt(rowsNumberComboBox.getSelectedItem().toString()),
                Integer.parseInt(columnsNumberComboBox.getSelectedItem().toString()))) {
            JOptionPane.showMessageDialog(this, "Not connected to database, cannot load statistics!");
            this.dispose();
            return;
        }
        if (statisticsController.getStatisticsList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Unfortunatelly, there is no data for selected values!\nPlease select another values and try again");
        } else {
            statisticsTable.setModel(new DefaultTableModel(new Object[]{"player name", "game time", "moves number"}, statisticsController.getStatisticsList().size()));
            statisticsTable.setVisible(true);
            createAndFillTable();

            animateButton.setEnabled(true);
            informationLabel.setText("Select a player and click animate button - animation window will appear.");
            informationLabel.setVisible(true);
        }
        this.pack();
    }
    
    private void animateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = statisticsTable.getSelectedRow();
        GameSummary playerSummary = statisticsController.getStatisticsList().get(row);
        String winningPath = playerSummary.getSolution();
        AnimatorWindow animatorWindow = new AnimatorWindow(BoardUtils.buildArrangedBoard(playerSummary.getRows(), playerSummary.getColumns()), winningPath);
        animatorWindow.setVisible(true);
    }

    private void createAndFillTable() {
        for (int i = 0; i < statisticsController.getStatisticsList().size(); i++) {
            statisticsTable.getModel().setValueAt(statisticsController.getStatisticsList().get(i).getPlayerName(), i, 0);
            statisticsTable.getModel().setValueAt(statisticsController.getStatisticsList().get(i).getTime(), i, 1);
            statisticsTable.getModel().setValueAt(statisticsController.getStatisticsList().get(i).getStepsNumber(), i, 2);
        }
    }
}
