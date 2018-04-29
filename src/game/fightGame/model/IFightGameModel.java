package game.fightGame.model;

import java.util.ArrayList;

public interface IFightGameModel {
	public ICharacter[] getCharacters();

	public void setPlayerClass(String string);

	public void setAIClass(ICharacter character);

	public ArrayList<String> getClassesList();
}
