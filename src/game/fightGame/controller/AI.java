package game.fightGame.controller;

import java.io.IOException;
import java.util.ArrayList;

import game.fightGame.model.Damager;
import game.fightGame.model.Healer;
import game.fightGame.model.ICharacter;
import game.fightGame.model.Tank;

public abstract class AI {
	private ICharacter character;

	public AI(ArrayList<String> listClass) {
		try {
			this.selectCharacter(listClass);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void selectCharacter(ArrayList<String> listClass) throws IOException {
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

	public abstract Order getAction();

}
