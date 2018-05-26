package game.fightGame.controller;

import java.util.ArrayList;

public class EasyAI extends AI {

	public EasyAI(ArrayList<String> listClass) {
		super(listClass);
	}

	@Override
	public Order getAction() {
		return null;
	}

}
