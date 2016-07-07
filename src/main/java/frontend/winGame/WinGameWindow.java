package frontend.winGame;

import frontend.GameSummary;
import javax.swing.JOptionPane;
import npuzzle.Board;

public class WinGameWindow extends javax.swing.JFrame {

    private WinGameController winController;

    public WinGameWindow(double time, Board board) {
        initComponents();
        int rows = board.getState().length;
        int columns = board.getState()[0].length;
        winController = new WinGameController(board.getPath(), time, rows, columns);
        showResult();
    }

    public final void showResult() {
        this.time.setText(String.valueOf(winController.getTime()) + "s");
        this.amount.setText(String.valueOf(winController.getPath().length()));
        this.size.setText(winController.getRows() + "x" + winController.getColumns());
    }

    public void sendToDatabase(GameSummary summary) {
        //DatabaseUtils.sendToDatabase(summary)
        //send to database, probably needs to send an object not only the name
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        movesLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        amount = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        boardSizeLabel = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        enterNameLabel = new javax.swing.JLabel();
        saveScoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Game summary");
        setLocation(new java.awt.Point(30, 30));
        setResizable(false);

        timeLabel.setText("Time:");

        movesLabel.setText("Moves:");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        amount.setText("amount");
        amount.setName("amount"); // NOI18N

        time.setText("time");
        time.setName("time"); // NOI18N

        boardSizeLabel.setText("Board size: ");

        size.setText("size");
        size.setName("size"); // NOI18N

        enterNameLabel.setText("Enter your name:");

        saveScoreLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveScoreLabel.setText("SAVE YOUR SCORE!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterNameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(movesLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(amount))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(timeLabel)
                                        .addGap(70, 70, 70)
                                        .addComponent(time))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boardSizeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(size)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(saveScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amount)
                    .addComponent(movesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boardSizeLabel)
                    .addComponent(size))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(saveScoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterNameLabel)
                .addGap(1, 1, 1)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (!nameTextField.getText().isEmpty()) {
            GameSummary summary = new GameSummary(nameTextField.getText(), winController.getPath(), 
                    winController.getTime(), winController.getRows(), winController.getColumns(), winController.getPath().length());
            sendToDatabase(summary);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Put the name first");
        }
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JLabel boardSizeLabel;
    private javax.swing.JLabel enterNameLabel;
    private javax.swing.JLabel movesLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel saveScoreLabel;
    private javax.swing.JLabel size;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel time;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
