package game.fightGame.controller;

import game.fightGame.model.ICharacter;

public class RunGame implements Runnable {
	private TextGenerator text;
	private ICharacter playerCharacter;
	private ICharacter computerCharacter;

	private Order playerOrder;
	private AI computer;

	private boolean playerActionChosed = false;

	public RunGame(TextGenerator text, ICharacter[] characters, AI computer) {
		this.text = text;
		this.playerCharacter = characters[0];
		this.computerCharacter = characters[1];
		this.computer = computer;
	}

	@Override
	public void run() {
		while (playerCharacter.getCurrentLife() >= 0 || computerCharacter.getCurrentLife() >= 0) {
			if (playerActionChosed) {
				Order AIOrder = computer.getAction();

				switch (playerOrder) {
				case ATTACK:
					if (!AIOrder.equals(Order.BLOCK)) {
						int damages = playerCharacter.attack(computerCharacter);
						text.buildText("Joueur a infligé " + damages + " point(s) de dégâts.");
					} else {
						text.buildText("Ordinateur a bloqué l'attaque de Joueur.");
					}
					break;
				case BLOCK:
					playerCharacter.block();
					break;
				case SPECIAL:
					text.buildText(playerCharacter.useSpecialPower(computerCharacter, "Joueur", "ordinateur"));
					break;
				default:
					playerCharacter.block();
					break;
				}

				switch (AIOrder) {
				case ATTACK:
					if (!playerOrder.equals(Order.BLOCK)) {
						int damages = computerCharacter.attack(playerCharacter);
						text.buildText("Ordinateur a infligé " + damages + " point(s) de dégâts.");
					} else {
						text.buildText("Joueur a bloqué l'attaque de Joueur.");
					}
					break;

				case BLOCK:
					computerCharacter.block();
					break;

				case SPECIAL:
					text.buildText(computerCharacter.useSpecialPower(playerCharacter, "Ordinateur", "joueur"));
					break;

				default:
					computerCharacter.block();
					break;
				}

				text.generateText();

				computerCharacter.setReady();
				playerCharacter.setReady();
				playerActionChosed = false;
			}

			System.out.println("a");
		}

	}

	public void setPlayerOrder(Order order) {
		this.playerOrder = order;
		playerActionChosed = true;
	}
}
