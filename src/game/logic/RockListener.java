package game.logic;
import javax.swing.*;
import java.awt.event.*;

public class RockListener implements ActionListener {
	private GameLogic logic;
	private JLabel result;
	private JLabel playerScore;
	private JLabel aiScore;
	private Choice c = Choice.ROCK;
	
	public RockListener(GameLogic logic, JLabel result, JLabel playerScore, JLabel aiScore) {
		this.result = result;
		this.playerScore = playerScore;
		this.aiScore = aiScore;
		this.logic = logic;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		c = logic.rpsAI();
		
		if(c.equals(Choice.ROCK)) {
			result.setText("The AI picked Rock! It's a draw.");
		}
		else if(c.equals(Choice.PAPER)) {
			result.setText("The AI picked Paper! It's a loss for you.");
			logic.increaseAIWin();
			aiScore.setText("AI wins: " + logic.getAIWin());
		    logic.winnerCheck();
		}
		else if(c.equals(Choice.SCISSORS)) {
			result.setText("The AI picked Scissors! It's a win for you! :)");
			logic.increasePlayerWin();
			playerScore.setText("Player wins: " + logic.getPlayerWin());
			logic.winnerCheck();
		}
	}
}
