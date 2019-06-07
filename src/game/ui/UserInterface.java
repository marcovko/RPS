package game.ui;
import game.logic.*;
import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {
	private JFrame frame;
	private GameLogic logic;
	private JLabel result;
	private JLabel playerScore;
	private JLabel aiScore;
	private JButton rock;
	private JButton paper;
	private JButton scissors;
	
	public UserInterface() {
		result = new JLabel("");
		rock = new JButton("Rock");
		paper = new JButton("Paper");
		scissors = new JButton("Scissors");
		playerScore = new JLabel("Player wins: 0");
		aiScore = new JLabel("AI wins: 0");
		logic = new GameLogic(result, rock, paper, scissors);
	}

	@Override
	public void run() {
		frame = new JFrame("RPS");
		frame.setPreferredSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public void createComponents(Container container) {
		
		container.add(createScorePanel(), BorderLayout.NORTH);
		container.add(createButtonPanel(), BorderLayout.SOUTH);
		container.add(createResultPanel(), BorderLayout.CENTER);
	}
	
	//Creates the 3 RPS buttons
	private JPanel createButtonPanel() {
		GridLayout layout = new GridLayout(1, 3);
		JPanel panel = new JPanel(layout);
		
		//rock = new JButton("Rock");
		RockListener rockListener = new RockListener(logic, result, playerScore, aiScore);
		rock.addActionListener(rockListener);
		
		//paper = new JButton("Paper");
		PaperListener paperListener = new PaperListener(logic, result, playerScore, aiScore);
		paper.addActionListener(paperListener);
		
		//scissors = new JButton("Scissors");
		ScissorsListener scissorsListener = new ScissorsListener(logic, result, playerScore, aiScore);
		scissors.addActionListener(scissorsListener);
		
		panel.add(rock);
		panel.add(paper);
		panel.add(scissors);
		
		return panel;
	}
	
	//Creates the result panel for individual turns
	private JPanel createResultPanel() {
		BorderLayout layout = new BorderLayout();
		JPanel panel = new JPanel(layout);
		
		panel.add(result);
		
		return panel;
	}
	
	//Creates the panel that keeps track of the score
	private JPanel createScorePanel() {
		GridLayout layout = new GridLayout(1, 2);
		JPanel panel = new JPanel(layout);
		
		playerScore.setText("Player wins: " + logic.getPlayerWin());
		aiScore.setText("AI wins: " + logic.getAIWin());
		
		panel.add(playerScore);
		panel.add(aiScore);
		
		return panel;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JLabel getResult() {
		return result;
	}
	
}
