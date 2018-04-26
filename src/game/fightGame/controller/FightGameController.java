package game.fightGame.controller;

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
		PopupToStartANewGame popup = new PopupToStartANewGame(null, "Nouvelle partie", true);
		popup.show();
	}

}
