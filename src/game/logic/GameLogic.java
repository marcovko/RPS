package game.logic;
import java.util.Random;
import javax.swing.*;

public class GameLogic {
	private Random r;
	private Choice c = Choice.ROCK;
	private int playerWins;
	private int aiWins;
	private JLabel result;
	private JButton rock;
	private JButton paper;
	private JButton scissors;

	public GameLogic(JLabel result, JButton rock, JButton paper, JButton scissors) {
		this.result = result;
		this.playerWins = 0;
		this.aiWins = 0;
		this.rock = rock;
		this.paper = paper;
		this.scissors = scissors;
	}
	
	//Method for picking the AI's choice
	public Choice rpsAI() {
		c = getRandom();
		return c;
	}
	
	//Method for randomly giving the AI a choice
	public Choice getRandom() {
		r = new Random();
		return Choice.values()[r.nextInt(Choice.values().length)];
	}
	
	//Increasing the player scorecount by one
	public void increasePlayerWin() {
		this.playerWins++;
	}
	
	//Increasing the AI scorecount by one
	public void increaseAIWin() {
		this.aiWins++;
	}
	
	//Getter for the player score
	public int getPlayerWin() {
		return this.playerWins;
	}
	
	//Getter for the AI score
	public int getAIWin() {
		return this.aiWins;
	}
	
	//Checks if either the player or the AI has reached a score of 5
	public void winnerCheck() {
		if(playerWins == 5) {
			gameEnd(true);
		}
		else if(aiWins == 5) {
			gameEnd(false);
		}
	}
	
	//The game ending screen
	public void gameEnd(boolean playerWon) {
		if(playerWon) {
			result.setText("Player won! " + playerWins + " - " + aiWins);
			System.out.println("Thanks for playing!");
			rock.setEnabled(false);
			paper.setEnabled(false);
			scissors.setEnabled(false);
		}
		else if (!playerWon) {
			result.setText("AI won! " + aiWins + " - " + playerWins);
			System.out.println("Thanks for playing!");
			rock.setEnabled(false);
			paper.setEnabled(false);
			scissors.setEnabled(false);
		}
	}
}
