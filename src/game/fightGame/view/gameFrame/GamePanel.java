package game.fightGame.view.gameFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

import game.fightGame.model.Dimension;
import game.fightGame.model.ICharacter;
import game.fightGame.model.IFightGameModel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083209086675517141L;

	private JEditorPane textArea;
	private JPanel buttonArea;
	private JPanel gameArea;

	private JButton attack, block, special;

	public GamePanel(ICharacter playerClass, ICharacter AIClass, IFightGameModel model) {
		this.textArea = new JEditorPane();
		this.buttonArea = new JPanel();
		this.gameArea = new JPanel();

		this.setLayout(new BorderLayout());

		this.add(gameArea, BorderLayout.NORTH);
		this.add(buttonArea, BorderLayout.CENTER);
		this.add(textArea, BorderLayout.SOUTH);
	}

	void initializeComponents(Dimension dimensionFrame) {
		this.initializeGameArea(dimensionFrame);
		this.initializeButtonArea();
		this.initializeTextArea();
	}

	private void initializeGameArea(Dimension dimensionFrame) {
		gameArea.setBackground(Color.BLACK);
		gameArea.setPreferredSize(
				new java.awt.Dimension(200, (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) + 200));
		gameArea.setBackground(Color.BLACK);
		gameArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gameArea.setOpaque(true);
	}

	private void initializeButtonArea() {
		buttonArea.setPreferredSize(new java.awt.Dimension(0, 50));
		buttonArea.setLayout(new GridBagLayout());

		// Putting buttons
		attack = new JButton("Attaque");
		attack.setPreferredSize(new java.awt.Dimension(100, 400));
		attack.setFont(new Font("Arial", Font.PLAIN, 40));

		block = new JButton("Bloquage");
		block.setPreferredSize(new java.awt.Dimension(100, 400));
		block.setFont(new Font("Arial", Font.PLAIN, 40));

		special = new JButton("Pouvoir spécial");
		special.setPreferredSize(new java.awt.Dimension(100, 400));
		special.setFont(new Font("Arial", Font.PLAIN, 40));

		GridBagConstraints cAttack = new GridBagConstraints();
		cAttack.gridx = 0;
		cAttack.gridy = 0;
		cAttack.weightx = 1;

		GridBagConstraints cBlock = new GridBagConstraints();
		cBlock.gridx = 1;
		cBlock.gridy = 0;
		cBlock.weightx = 1;

		GridBagConstraints cSpecial = new GridBagConstraints();
		cSpecial.gridx = 2;
		cSpecial.gridy = 0;
		cSpecial.weightx = 1;

		buttonArea.add(attack, cAttack);
		buttonArea.add(block, cBlock);
		buttonArea.add(special, cSpecial);
	}

	private void initializeTextArea() {
		textArea.setPreferredSize(new java.awt.Dimension(0, 700));
		textArea.setEditable(false);
		textArea.setEditable(false);
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setFocusable(false);
	}

	public JEditorPane getTextArea() {
		return textArea;
	}

	public JPanel getButtonContener() {
		return buttonArea;
	}

	public JPanel getGame() {
		return gameArea;
	}

}
