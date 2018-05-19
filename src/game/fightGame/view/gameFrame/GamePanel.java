package game.fightGame.view.gameFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import game.fightGame.model.Dimension;
import game.fightGame.model.ICharacter;
import game.fightGame.model.IFightGameModel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083209086675517141L;

	private JFrame currentFrame;
	private JEditorPane textArea;
	private JPanel buttonArea;
	private GameArea gameArea;

	private Image background;

	private JButton attack, block, special;

	private final Action attacking = new Attack_Action();
	private final Action blocking = new Block_Action();
	private final Action specialAction = new Special_Action();

	public GamePanel(JFrame currentFrame, ICharacter playerClass, ICharacter AIClass, IFightGameModel model,
			Image backgroung) {
		this.currentFrame = currentFrame;
		this.textArea = new JEditorPane();
		this.buttonArea = new JPanel();
		this.gameArea = new GameArea();
		this.background = backgroung;

		this.setLayout(new BorderLayout());

		this.add(gameArea, BorderLayout.NORTH);
		this.add(buttonArea, BorderLayout.CENTER);
		this.add(new JScrollPane(textArea), BorderLayout.SOUTH);
	}

	void initializeComponents(Dimension dimensionFrame) {
		this.initializeGameArea(dimensionFrame);
		this.initializeButtonArea();
		this.initializeTextArea();
	}

	private void initializeGameArea(Dimension dimensionFrame) {
		gameArea.addBackground(background);
		gameArea.setPreferredSize(
				new java.awt.Dimension(200, (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) + 200));
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
		attack.setAction(attacking);

		block = new JButton("Bloquage");
		block.setPreferredSize(new java.awt.Dimension(100, 400));
		block.setFont(new Font("Arial", Font.PLAIN, 40));
		block.setAction(blocking);

		special = new JButton("Pouvoir spécial");
		special.setPreferredSize(new java.awt.Dimension(100, 400));
		special.setFont(new Font("Arial", Font.PLAIN, 40));
		special.setAction(specialAction);

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

	// ---------------------Actions executed by buttons----------------------------

	@SuppressWarnings("serial")
	private class Attack_Action extends AbstractAction {
		public Attack_Action() {
			putValue(NAME, "Attaque");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			currentFrame.requestFocusInWindow();
		}

	}

	@SuppressWarnings("serial")
	private class Block_Action extends AbstractAction {
		public Block_Action() {
			putValue(NAME, "Blockage");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			currentFrame.requestFocusInWindow();
		}

	}

	@SuppressWarnings("serial")
	private class Special_Action extends AbstractAction {
		public Special_Action() {
			putValue(NAME, "Action spéciale");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			currentFrame.requestFocusInWindow();
		}

	}

}
