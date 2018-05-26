package game.fightGame.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;

import javax.swing.JOptionPane;

import game.fightGame.model.IFightGameModel;
import game.fightGame.view.gameFrame.GameFrame;
import game.fightGame.view.setNewGame.PopupToStartANewGame;

public class FightGameController {
	private IFightGameModel model;
	private AI computer;
	private TextGenerator textBuilder;
	private RunGame fight;

	public FightGameController(IFightGameModel model) {
		this.model = model;
	}

	public void start() {
		this.startANewGame();
		this.launchGame();
	}

	private void startANewGame() {
		PopupToStartANewGame popup = new PopupToStartANewGame(null, "Nouvelle partie", true, model.getClassesList(),
				new ArrayList<Difficulty>(EnumSet.allOf(Difficulty.class)));
		popup.setVisible();

		try {
			model.setPlayerClass(popup.getClassSelected());
		} catch (IOException e) {
			e.printStackTrace();
		}

		initilizeAI(popup.getDificulty(), model.getClassesList());
	}

	private void initilizeAI(Difficulty difficulty, ArrayList<String> listClass) {
		instantiantiateComputer(difficulty, listClass);
		model.setAIClass(getComputer().getCharacter());
	}

	private void launchGame() {
		GameFrame frame = new GameFrame("FightGame", model, this);
		textBuilder = new TextGenerator(frame.getTextArea());
		fight = new RunGame(textBuilder, model.getCharacters(), getComputer());
		fight.run();
	}

	public void sendPlayerAction(Order action) {
		fight.setPlayerOrder(action);
	}

	public AI getComputer() {
		return computer;
	}

	private void instantiantiateComputer(Difficulty difficulty, ArrayList<String> listClass) {
		switch (difficulty) {
		case RANDOM:
			this.computer = new RandomAi(listClass);
			break;

		case EASY:
			this.computer = new EasyAI(listClass);
			break;

		case HARD:
			this.computer = new DifficultAI(listClass);
			break;

		default:
			JOptionPane.showMessageDialog(null,
					"Nous n'avons pas pu sélectionner votre niveau de difficulté. Votre niveau par défault est "
							+ Difficulty.RANDOM.toString() + ".",
					"Erreur inconnue", JOptionPane.ERROR_MESSAGE);
			this.computer = new RandomAi(listClass);
			break;
		}
	}

}
