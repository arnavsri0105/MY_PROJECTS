import java.util.*;

//backend
public class RockPaperScissors {

    // all of the choices that a computer can chose
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors" };

    // computerChoice will store the computer choice so that we can retrieve the value and display it to the frontend
    private String computerChoice;

    // store the scores so that we can retrieve the values and display it to the frontend
    private int computerScore, playerScore;

    // getter for computer choice
    public String getComputerChoice() {
        return computerChoice;
    }

    // getter for computer score
    public int getComputerScore() {
        return computerScore;
    }

    // getter for player score
    public int getPlayerScore() {
        return playerScore;
    }

    // used to generate a random number to randomly chose an option for the computer
    private Random random;

    // constructor - to initialize random obj
    public RockPaperScissors() {
        random = new Random();
    }

    // call this method to begin playing rock paper scissors
    // playerChoice - is the choice made by the player (i.e., rock, paper, or scissors)
    // this method will return the result of the game (i.e., computer wins, player wins, or draw)
    public String playRockPaperScissors(String playerChoice) {
        // generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        // Will contain the returning message indicating the result of the game
        String result;

        // evaluate the winner

        // Case 1: Computer chooses Rock
        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Scissors")) {
                result = "Computer Wins";
                computerScore++;
            }
            else {
                result = "Draw";
            }
        }

        // Case 2: Computer chooses Paper
        else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissors")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = "Computer Wins";
                computerScore++;
            }
            else {
                result = "Draw";
            }
        }

        // Case 3: Computer chooses Scissors
        else {
            if (playerChoice.equals("Rock")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "Computer Wins";
                computerScore++;
            }
            else {
                result = "Draw";
            }
        }

        return result;
    }
}
