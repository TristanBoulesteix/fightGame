package game.fightGame.view.gameFrame;

import javax.swing.JFrame;

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
		this.model = model;
		this.characters = this.model.getCharacters();
		this.panel = new GamePanel(characters[0], characters[1], model);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle(title);
		this.setUndecorated(true);
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.generateGraphicContent(this.getSize().getWidth(), this.getSize().getHeight());

		this.setContentPane(panel);
	}

	private void generateGraphicContent(double width, double height) {
		dimensionFrame = new Dimension(height, width);
		panel.initializeComponents(dimensionFrame);
	}
}
