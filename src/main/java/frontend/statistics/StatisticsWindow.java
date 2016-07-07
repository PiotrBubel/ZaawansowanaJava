/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.statistics;

import database.DatabaseUtils;
import frontend.GameSummary;
import frontend.animator.AnimatorWindow;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
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
        initComponents();
        statisticsController = new StatisticsWindowController();
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
        jScrollPane1 = new JScrollPane();
        statisticsTable = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Statistics");

        setTheBoardSizeLabel.setFont(new Font("Tahoma", 0, 14));
        setTheBoardSizeLabel.setText("Set the board size");

        rowsLabel.setText("rows");
        columnsLabel.setText("columns");
        
        loadStatisticsButton.setText("load statistics");		
        loadStatisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadStatisticsButtonActionPerformed(evt);
            }
        });

        animateButton.setText("animate");
	animateButton.setEnabled(false);
	animateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animateButtonActionPerformed(evt);
            }
        });
		
        rowsNumberComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
        //rowsNumberComboBox.setModel(new DefaultComboBoxModel<String>(DatabaseUtils.getRows()));
        columnsNumberComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
        //columnsNumberComboBox.setModel(new DefaultComboBoxModel<String>(DatabaseUtils.getColumns()));

	informationLabel.setText(" ");
        informationLabel.setVisible(true);

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
        statisticsController.getSortedStatistics(Integer.parseInt(rowsNumberComboBox.getSelectedItem().toString()),
                Integer.parseInt(columnsNumberComboBox.getSelectedItem().toString()));
        if (statisticsController.getStatisticsList().isEmpty()) {
            informationLabel.setText("Unfortunatelly, there is no data for selected values!");
            informationLabel.setVisible(true);
        } else {
            createAndFillTable();
            statisticsTable.setVisible(true);
            animateButton.setEnabled(true);            
            informationLabel.setText("You can select a player and after clicking animate button animation window will appear.");
            informationLabel.setVisible(true);
        }
    }

    private void animateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = statisticsTable.getSelectedRow();
        GameSummary playerSummary = statisticsController.getStatisticsList().get(row);
        String winningPath = playerSummary.getSolution();
        AnimatorWindow animatorWindow = new AnimatorWindow(
                new Board(BoardUtils.buildArrangedBoard(playerSummary.getRows(), playerSummary.getColumns())), winningPath);
        animatorWindow.setVisible(true);
    }

    private void createAndFillTable() {
        statisticsTable = new JTable(statisticsController.getStatisticsList().size(), 3);
        for (int i = 0; i < statisticsController.getStatisticsList().size(); i++) {
            statisticsTable.getModel().setValueAt(statisticsController.getStatisticsList().get(i).getPlayerName(), i, 0);
            statisticsTable.getModel().setValueAt(statisticsController.getStatisticsList().get(i).getTime(), i, 1);
            statisticsTable.getModel().setValueAt(statisticsController.getStatisticsList().get(i).getStepsNumber(), i, 2);
        }
    }
}
