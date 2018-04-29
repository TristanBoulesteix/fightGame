package game.fightGame.controller;

import java.util.ArrayList;
import java.util.EnumSet;

import game.fightGame.model.IFightGameModel;
import game.fightGame.view.gameFrame.GameFrame;
import game.fightGame.view.setNewGame.PopupToStartANewGame;

public class FightGameController {
	private IFightGameModel model;
	private AI computer;

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
		model.setPlayerClass(popup.getClassSelected());
		initilizeAI(popup.getDificulty(), model.getClassesList());
	}

	private void initilizeAI(Difficulty difficulty, ArrayList<String> listClass) {
		setComputer(new AI(difficulty, listClass));
		model.setAIClass(getComputer().getCharacter());
	}

	private void launchGame() {
		GameFrame frame = new GameFrame("FightGame", model);
		frame.setVisible(true);
	}

	public AI getComputer() {
		return computer;
	}

	private void setComputer(AI computer) {
		this.computer = computer;
	}

}
