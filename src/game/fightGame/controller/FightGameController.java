package game.fightGame.controller;

import java.util.ArrayList;
import java.util.EnumSet;

import game.fightGame.model.IFightGameModel;
import game.fightGame.view.setNewGame.PopupToStartANewGame;

public class FightGameController {
	private IFightGameModel model;
	private Difficulty currentDifficulty;

	public FightGameController(IFightGameModel model) {
		this.model = model;
	}

	public void start() {
		this.startANewGame();
	}

	private void startANewGame() {
		PopupToStartANewGame popup = new PopupToStartANewGame(null, "Nouvelle partie", true, model.getClassesList(),
				new ArrayList<Difficulty>(EnumSet.allOf(Difficulty.class)));
		popup.setVisible();
		setCurrentDifficulty(popup.getDificulty());
		model.setPlayerClass(popup.getClassSelected());
	}

	public Difficulty getCurrentDifficulty() {
		return currentDifficulty;
	}

	private void setCurrentDifficulty(Difficulty currentDifficulty) {
		this.currentDifficulty = currentDifficulty;
	}

}
