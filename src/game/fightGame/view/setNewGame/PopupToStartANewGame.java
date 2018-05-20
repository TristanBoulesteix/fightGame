package game.fightGame.view.setNewGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import game.fightGame.controller.Difficulty;

public class PopupToStartANewGame extends JDialog {
	private static final long serialVersionUID = 2329737124851905773L;

	private JComboBox<String> classNames;
	private JRadioButton[] buttons;

	private String classSelected;
	private Difficulty difficulty;

	public PopupToStartANewGame(JFrame frame, String title, boolean modal, ArrayList<String> allClasses,
			ArrayList<Difficulty> difficulties) {
		super(frame, title, modal);
		this.setSize(400, 220);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent(allClasses, difficulties);
	}

	// To show the popup
	public void setVisible() {
		this.setVisible(true);
	}

	// To put component on popup
	private void initComponent(ArrayList<String> allClasses, ArrayList<Difficulty> difficulties) {
		// Initialization of the panel to choose the character class
		JPanel classPanel = new JPanel();
		classPanel.setBackground(Color.white);
		classPanel.setPreferredSize(new Dimension(380, 60));
		classPanel.setBorder(BorderFactory.createTitledBorder("Sélectionnez votre classe"));
		classNames = new JComboBox<String>();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

		for (String className : allClasses) {
			classNames.addItem(className);
		}

		classPanel.add(classNames);

		// Initialization of the panel to select the difficulty AI
		JPanel difficultyPanel = new JPanel();
		difficultyPanel.setBackground(Color.WHITE);
		difficultyPanel.setPreferredSize(new Dimension(380, 60));
		difficultyPanel.setBorder(BorderFactory.createTitledBorder("Sélectionnez la difficulté de l'IA"));
		buttons = new JRadioButton[difficulties.size()];
		ButtonGroup group = new ButtonGroup();

		for (int i = 0; i < difficulties.size(); i++) {
			buttons[i] = new JRadioButton(difficulties.get(i).toString());
			group.add(buttons[i]);
			difficultyPanel.add(buttons[i]);
		}

		buttons[0].setSelected(true);

		// Initialization of buttons
		JPanel controlPanel = new JPanel();

		JButton okButton = new JButton("OK");
		this.getRootPane().setDefaultButton(okButton);
		this.addConfirmActionToButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		this.addCancelActionToButton(cancelButton);

		controlPanel.add(okButton);
		controlPanel.add(cancelButton);

		JPanel content = new JPanel();
		content.add(classPanel);
		content.add(difficultyPanel);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(controlPanel, BorderLayout.SOUTH);
	}

	// Set action to buttons
	private void addConfirmActionToButton(JButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				classSelected = (String) classNames.getSelectedItem();
				difficulty = getBoxSelected();
				setVisible(false);
			}
		});
	}

	private void addCancelActionToButton(JButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}

	private Difficulty getBoxSelected() {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].isSelected()) {
				return Difficulty.values()[i];
			}
		}

		return null;
	}

	// Returning data
	public String getClassSelected() {
		return classSelected;
	}

	public Difficulty getDificulty() {
		return difficulty;
	}
}
