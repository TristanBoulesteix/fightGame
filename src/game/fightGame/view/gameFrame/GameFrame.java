package game.fightGame.view.gameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import game.fightGame.model.Dimension;
import game.fightGame.model.ICharacter;
import game.fightGame.model.IFightGameModel;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4326883871741402241L;

	private IFightGameModel model;
	private final ICharacter[] characters;
	private GamePanel panel;
	private Dimension dimensionFrame;

	public GameFrame(String title, IFightGameModel model) {
		model.buildArea();

		this.model = model;
		this.characters = this.model.getCharacters();
		this.panel = new GamePanel(this, characters[0], characters[1], model,
				model.getArea().getRandomBackgroungImage());

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle(title);
		this.setUndecorated(true);
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
					int choice = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de quitter le jeu ?", "Pause",
							JOptionPane.OK_CANCEL_OPTION);

					if (choice == JOptionPane.OK_OPTION) {
						System.exit(0);
					}
				}
			}
		});

		this.setVisible(true);

		this.generateGraphicContent(this.getSize().getWidth(), this.getSize().getHeight());

		this.add(panel);

		this.pack();

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.requestFocusInWindow();
	}

	private void generateGraphicContent(double width, double height) {
		dimensionFrame = new Dimension(height, width);
		panel.initializeComponents(dimensionFrame);
	}
}
