package game.fightGame.view.gameFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import game.fightGame.controller.FightGameController;
import game.fightGame.controller.Order;
import game.fightGame.model.ICharacter;
import game.fightGame.model.IFightGameModel;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9083209086675517141L;

	private JFrame currentFrame;
	private JLabel textArea;
	private JPanel buttonArea;
	private GameArea gameArea;

	private ICharacter playerClass, AIClass;

	private Image background;

	private FightGameController controller;

	private JButton attack, block, special;

	private final Action attacking = new Attack_Action();
	private final Action blocking = new Block_Action();
	private final Action specialAction = new Special_Action();

	public GamePanel(JFrame currentFrame, ICharacter playerClass, ICharacter AIClass, IFightGameModel model,
			Image background, FightGameController controller) {
		this.currentFrame = currentFrame;
		this.textArea = new JLabel();
		this.buttonArea = new JPanel();
		this.gameArea = new GameArea();
		this.playerClass = playerClass;
		this.AIClass = AIClass;
		this.background = background;
		this.controller = controller;

		this.setLayout(new BorderLayout());

		this.add(gameArea, BorderLayout.NORTH);
		this.add(buttonArea, BorderLayout.CENTER);
		this.add(new JScrollPane(textArea), BorderLayout.SOUTH);
	}

	void initializeComponents() {
		this.initializeGameArea();
		this.initializeButtonArea();
		this.initializeTextArea();
	}

	private void initializeGameArea() {
		gameArea.addBackground(background);
		gameArea.setPreferredSize(
				new Dimension(200, (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) + 200));
		gameArea.addCharacterOnScreen(playerClass, AIClass);
		gameArea.setOpaque(true);
	}

	private void initializeButtonArea() {
		buttonArea.setPreferredSize(new Dimension(0, 50));
		buttonArea.setLayout(new GridBagLayout());

		// Putting buttons
		attack = new JButton("Attaque");
		attack.setPreferredSize(new Dimension(100, 400));
		attack.setFont(new Font("Arial", Font.PLAIN, 40));
		attack.setAction(attacking);

		block = new JButton("Bloquage");
		block.setPreferredSize(new Dimension(100, 400));
		block.setFont(new Font("Arial", Font.PLAIN, 40));
		block.setAction(blocking);

		special = new JButton("Pouvoir spécial");
		special.setPreferredSize(new Dimension(100, 400));
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
		textArea.setPreferredSize(new Dimension(0, 700));
		textArea.setHorizontalAlignment(JLabel.LEFT);
		textArea.setVerticalAlignment(JLabel.TOP);
		textArea.setFocusable(false);
	}

	public JLabel getTextArea() {
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
			controller.sendPlayerAction(Order.ATTACK);
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
			controller.sendPlayerAction(Order.BLOCK);
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
			controller.sendPlayerAction(Order.SPECIAL);
		}

	}

}
