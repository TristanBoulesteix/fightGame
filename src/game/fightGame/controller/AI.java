package game.fightGame.controller;

import java.util.ArrayList;

import game.fightGame.model.Damager;
import game.fightGame.model.Healer;
import game.fightGame.model.ICharacter;
import game.fightGame.model.Tank;

public class AI {
	final private Difficulty DIFFICULTY;
	private ICharacter character;

	public AI(final Difficulty DIFFICULTY, ArrayList<String> listClass) {
		this.DIFFICULTY = DIFFICULTY;
		this.selectCharacter(listClass);
	}

	private void selectCharacter(ArrayList<String> listClass) {
		int random = (int) (Math.random() * listClass.size());

		String selected = listClass.get(random);

		switch (selected) {
		case "Damager":
			character = new Damager();
			break;

		case "Healer":
			character = new Healer();
			break;

		case "Tank":
			character = new Tank();
			break;

		default:
			character = new Tank();
			break;
		}
	}

	public ICharacter getCharacter() {
		return character;
	}

}
