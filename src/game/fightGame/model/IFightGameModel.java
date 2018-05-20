package game.fightGame.model;

import java.io.IOException;
import java.util.ArrayList;

public interface IFightGameModel {
	public ICharacter[] getCharacters();

	public IArea getArea();

	public void buildArea();

	public void setPlayerClass(String string) throws IOException;

	public void setAIClass(ICharacter character);

	public ArrayList<String> getClassesList();
}
