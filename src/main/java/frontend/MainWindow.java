package frontend;

import frontend.interfaces.BoardController;
import frontend.interfaces.ImageLoader;
import frontend.utils.DefaultBoardController;
import frontend.utils.DefaultImageLoader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame {

    private static final String WRONG_FOMRAT = "Wrong format of Image";
    private static final String CORRECT_FORMAT = "Loaded Image succesfully";
    private ImageLoader imageLoader;
    private BoardController puzzleBoard;

    public MainWindow() {
        initComponents();
        imageLoader = new DefaultImageLoader();
        puzzleBoard = new DefaultBoardController(puzzlePanel);
        puzzleBoard.createBoardOnWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newGameButton = new javax.swing.JButton();
        statisticsButton = new javax.swing.JButton();
        puzzlePanel = new javax.swing.JPanel();
        loadImageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(380, 420));

        newGameButton.setText("New Game");

        statisticsButton.setText("Statistics");

        puzzlePanel.setPreferredSize(new java.awt.Dimension(320, 320));

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

        loadImageButton.setText("Load Image");
        loadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newGameButton)
                        .addGap(18, 18, 18)
                        .addComponent(statisticsButton)
                        .addGap(18, 18, 18)
                        .addComponent(loadImageButton)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newGameButton)
                    .addComponent(statisticsButton)
                    .addComponent(loadImageButton))
                .addGap(18, 18, 18)
                .addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageButtonActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();

            try {
                imageLoader.loadImage(selectedFile);
                JOptionPane.showMessageDialog(null, CORRECT_FORMAT);
                puzzleBoard.createBoardOnWindow();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, WRONG_FOMRAT);
            }

        }
    }//GEN-LAST:event_loadImageButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loadImageButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JPanel puzzlePanel;
    private javax.swing.JButton statisticsButton;
    // End of variables declaration//GEN-END:variables
}
