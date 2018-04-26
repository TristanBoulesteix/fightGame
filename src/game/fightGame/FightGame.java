package game.fightGame;

import game.fightGame.controller.FightGameController;
import game.fightGame.model.FightGameModel;

public class FightGame {

	public static void main(String[] args) {
		final FightGameModel model = new FightGameModel();
		final FightGameController controller = new FightGameController(model);
		controller.start();
	}

}
