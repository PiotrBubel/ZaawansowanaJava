package frontend;

import frontend.animator.AnimatorWindow;
import frontend.contextMenu.ContextMenuListener;
import frontend.interfaces.BoardController;
import frontend.interfaces.GameListener;
import frontend.interfaces.ImageLoader;
import frontend.interfaces.Game;
import frontend.newGame.NewGameWindow;
import frontend.solver.SolverWindow;
import frontend.statistics.StatisticsWindow;
import frontend.utils.DefaultBoardController;
import frontend.utils.DefaultImageLoader;
import frontend.winGame.WinGameWindow;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

import database.DatabaseUtils;
import npuzzle.Board;

public class MainWindow extends JFrame implements Game {

	private ImageLoader imageLoader;
	private BoardController puzzleBoard;
	private long start;
	private boolean isGameActive = false;

	private List<GameListener> listeners = new ArrayList<>();

	MainWindow() {
		DatabaseUtils.connectToDatabase();
		initComponents();
		imageLoader = new DefaultImageLoader(puzzlePanel.getWidth(), puzzlePanel.getHeight());
		puzzleBoard = new DefaultBoardController(puzzlePanel);
		puzzleBoard.createBoardOnWindow();
		addMouseListener(new ContextMenuListener(imageLoader, puzzleBoard));
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				DatabaseUtils.closeConnection();
				System.exit(0);
			}
		});
	}

	@Override
	public void setNewGame(Board board) {
		puzzleBoard.setBoard(board);
		listeners.clear();
		listeners.add(puzzleBoard);
		puzzleBoard.setGame(this);
		puzzleBoard.createBoardOnWindow();
		isGameActive = true;
		start = System.nanoTime();
	}

	@Override
	public void endGame() {
		if (isGameActive) {
			double time = (double) (System.nanoTime() - start) / 10E9;
			isGameActive = false;
			WinGameWindow winGameWindow = new WinGameWindow(time, puzzleBoard.getBoard());
			winGameWindow.show();
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		newGameButton = new javax.swing.JButton();
		statisticsButton = new javax.swing.JButton();
		puzzlePanel = new javax.swing.JPanel();
		animateButton = new javax.swing.JButton();
		solveButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		newGameButton.setText("New Game");
		newGameButton.setName("NewGame"); // NOI18N
		newGameButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newGameButtonActionPerformed(evt);
			}
		});

		statisticsButton.setText("Statistics");
		statisticsButton.setName("Statistics"); // NOI18N
		statisticsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				statisticsButtonActionPerformed(evt);
			}
		});

		puzzlePanel.setName("puzzlePanel"); // NOI18N
		puzzlePanel.setPreferredSize(new java.awt.Dimension(400, 400));

		javax.swing.GroupLayout puzzlePanelLayout = new javax.swing.GroupLayout(puzzlePanel);
		puzzlePanel.setLayout(puzzlePanelLayout);
		puzzlePanelLayout.setHorizontalGroup(puzzlePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		puzzlePanelLayout.setVerticalGroup(puzzlePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));

		animateButton.setText("Animate !");
		animateButton.setActionCommand("Animate");
		animateButton.setName("Animate"); // NOI18N
		animateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				animateButtonActionPerformed(evt);
			}
		});

		solveButton.setText("Solve");
		solveButton.setName("Solver"); // NOI18N
		solveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				solveButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(layout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(newGameButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(statisticsButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(animateButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(solveButton))
						.addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(30, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(newGameButton).addComponent(statisticsButton)
										.addComponent(animateButton).addComponent(solveButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(22, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void animateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_animateButtonActionPerformed
		AnimatorWindow animatorWindow = new AnimatorWindow(puzzleBoard.getBoard());
		animatorWindow.setVisible(true);
	}// GEN-LAST:event_animateButtonActionPerformed

	private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_solveButtonActionPerformed
		isGameActive = false;
		SolverWindow solverWindow = new SolverWindow(puzzleBoard.getBoard());
		solverWindow.setVisible(true);
	}// GEN-LAST:event_solveButtonActionPerformed

	private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newGameButtonActionPerformed
		NewGameWindow newGameWindow = new NewGameWindow(this);
		newGameWindow.setVisible(true);
	}// GEN-LAST:event_newGameButtonActionPerformed

	private void statisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_statisticsButtonActionPerformed
		StatisticsWindow statisticsWindow = new StatisticsWindow();
		statisticsWindow.setVisible(true);
	}// GEN-LAST:event_statisticsButtonActionPerformed

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton animateButton;
	private javax.swing.JButton newGameButton;
	private javax.swing.JPanel puzzlePanel;
	private javax.swing.JButton solveButton;
	private javax.swing.JButton statisticsButton;
	// End of variables declaration//GEN-END:variables

}
