package game.fightGame.controller;

import java.util.ArrayList;
import java.util.EnumSet;

import game.fightGame.model.Difficulty;
import game.fightGame.model.IFightGameModel;
import game.fightGame.view.setNewGame.PopupToStartANewGame;

public class FightGameController {
	private IFightGameModel model;

	public FightGameController(IFightGameModel model) {
		this.model = model;
	}

	public void start() {
		this.startANewGame();
	}

	private void startANewGame() {
		ArrayList<Difficulty> difficulties = new ArrayList<Difficulty>(EnumSet.allOf(Difficulty.class));
		PopupToStartANewGame popup = new PopupToStartANewGame(null, "Nouvelle partie", true, null, difficulties);
		popup.show();
	}

}
