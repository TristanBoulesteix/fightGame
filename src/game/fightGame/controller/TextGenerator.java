package game.fightGame.controller;

import javax.swing.JLabel;

public class TextGenerator {
	private JLabel pane;

	private StringBuilder textToBuild;

	public TextGenerator(JLabel pane) {
		this.setPane(pane);
		setTextToBuild(new StringBuilder(getPane().getText()));
		this.getTextToBuild().append("<html><font size = 8>");
	}

	synchronized public void buildText(String text) {
		getTextToBuild().append(text);
		getTextToBuild().append("<br />");
	}

	synchronized public void generateText() {
		this.getTextToBuild().append("</font></html>");
		getPane().setText(getTextToBuild().toString());
	}

	private JLabel getPane() {
		return pane;
	}

	private void setPane(JLabel pane) {
		this.pane = pane;
	}

	private StringBuilder getTextToBuild() {
		return textToBuild;
	}

	private void setTextToBuild(StringBuilder textToBuild) {
		this.textToBuild = textToBuild;
	}
}
