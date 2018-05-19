package game.fightGame.model;

import java.util.ArrayList;
import java.util.Arrays;

public class FightGameModel implements IFightGameModel {
	private ICharacter[] characters;
	private ArrayList<String> classesList;
	private IArea background;

	public FightGameModel() {
		setCharacters(new ICharacter[2]);
		setClassesList(new ArrayList<String>(Arrays.asList("Damager", "Healer", "Tank")));
	}

	@Override
	public ICharacter[] getCharacters() {
		return characters;
	}

	private void setCharacters(ICharacter[] characters) {
		this.characters = characters;
	}

	@Override
	public void setPlayerClass(String character) {
		ICharacter selectedCharacter = null;

		switch (character) {
		case "Healer":
			selectedCharacter = new Healer();
			break;

		case "Damager":
			selectedCharacter = new Damager();
			break;

		case "Tank":
			selectedCharacter = new Tank();
			break;

		default:
			selectedCharacter = new Damager();
			break;
		}

		getCharacters()[0] = selectedCharacter;
	}

	@Override
	public void setAIClass(ICharacter character) {
		getCharacters()[1] = character;
	}

	@Override
	public ArrayList<String> getClassesList() {
		return classesList;
	}

	private void setClassesList(ArrayList<String> classesList) {
		this.classesList = classesList;
	}

	@Override
	public IArea getArea() {
		return background;
	}

	@Override
	public void buildArea() {
		this.background = new Background();
	}

}
