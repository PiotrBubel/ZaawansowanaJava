package frontend.winGame;

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
    
    public void sendToDatabase(String name) {
        //send to database, probably needs to send an object not only the name
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        movesLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        amount = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        boardSizeLabel = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        timeLabel.setText("Time:");

        movesLabel.setText("Moves:");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        amount.setText("amount");

        time.setText("time");

        boardSizeLabel.setText("Board size: ");

        size.setText("size");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeLabel)
                    .addComponent(movesLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(amount)
                        .addGap(18, 18, 18)
						.addComponent(okButton)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(time)
                        .addGap(18, 18, 18)
                        .addComponent(nameTextField)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(boardSizeLabel)
                .addGap(18, 18, 18)
                .addComponent(size)
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(time)
					.addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movesLabel)
                    .addComponent(okButton)
                    .addComponent(amount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boardSizeLabel)
                    .addComponent(size))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (!nameTextField.getText().isEmpty()) {
            sendToDatabase(nameTextField.getText());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null,"Put the name first");
        }
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JLabel boardSizeLabel;
    private javax.swing.JLabel movesLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel size;
    private javax.swing.JLabel time;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
