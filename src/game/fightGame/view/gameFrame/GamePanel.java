package game.fightGame.view.gameFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.fightGame.model.Dimension;
import game.fightGame.model.ICharacter;
import game.fightGame.model.IFightGameModel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083209086675517141L;

	private JTextArea textArea;
	private JPanel buttonArea;
	private JPanel gameArea;

	public GamePanel(ICharacter playerClass, ICharacter AIClass, IFightGameModel model) {
		this.textArea = new JTextArea();
		this.buttonArea = new JPanel();
		this.gameArea = new JPanel();

		this.setLayout(new BorderLayout());

		this.add(gameArea, BorderLayout.NORTH);
		this.add(buttonArea, BorderLayout.CENTER);
		this.add(textArea, BorderLayout.SOUTH);
	}

	void initializeComponents(Dimension dimensionFrame) {
		this.initializeGameArea(dimensionFrame);
		this.initializeButtonArea(dimensionFrame.getWidth());
	}

	private void initializeGameArea(Dimension dimensionFrame) {
		gameArea.setPreferredSize(new java.awt.Dimension(dimensionFrame.getWidth(), dimensionFrame.getHeight() / 2));
		System.out.println(dimensionFrame.getHeight());
		System.out.println(gameArea.getSize());
		gameArea.setBackground(Color.BLACK);
	}

	private void initializeButtonArea(int width) {
		// buttonArea.setBackground(Color.blue);
		// buttonArea.setPreferredSize(new java.awt.Dimension(50, 50));
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JPanel getButtonContener() {
		return buttonArea;
	}

	public JPanel getGame() {
		return gameArea;
	}

}
