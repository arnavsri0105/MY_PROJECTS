import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

//frontend
public class RPS_GUI extends JFrame implements ActionListener{
    // player buttons
    JButton rockButton, paperButton, scissorButton;

    // will display choice of the Computer
    JLabel computerChoice;

    // will display choice of the Player
    JLabel playerChoice1;

    // will display the score of the computer and the player
    JLabel computerScoreLabel, playerScoreLabel;

    // backend object
    RockPaperScissors rockPaperScissors;

    public RPS_GUI() {
        // invoke JFrame constructor and add title  to the GUI

        super("Rock, Paper, Scissors");

        // set the sze of the GUI
        setSize(450, 754);

        //set layout to null to disable layout management, so we can absolute positioning for the elements
        // (i.e., setting x,y coordinates and width/height values)
        setLayout(null);

        //terminate the java virtual machine when closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //load GUI in the center of the screen everytime we run the application
        setLocationRelativeTo(null);

        // initialize the backend object
        rockPaperScissors = new RockPaperScissors();

        // add GUI Components
        addGuiComponents();
    }

    private void addGuiComponents(){
        // create computer score label
        computerScoreLabel = new JLabel("Computer: 0");

        // set x,y coordinates and  width/height values
        computerScoreLabel.setBounds(0, 43, 450, 30);

        // set the font to have a font family of dialog, font weight of bold and a font size of 26
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        // place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add to GUI
        add(computerScoreLabel);

        // create computer choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        // create computer choice
        playerChoice1 = new JLabel("?");
        playerChoice1.setBounds(175, 387, 98, 81);
        playerChoice1.setFont(new Font("Dialog", Font.PLAIN, 18));
        playerChoice1.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(computerChoice);

        playerChoice1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(playerChoice1);

        // create player score label
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 317, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // player buttons

        // rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 500, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        // paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 500, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissors button
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290, 500, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    // displays a message dialog which will show the winner and try again button to play again
    private void showDialog(String message) {
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        // try again button
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // reset computer choice
                computerChoice.setText("?");

                // reset player Choice
                playerChoice1.setText("?");

                // close the dialog box
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // get player choice
        String playerChoice = e.getActionCommand().toString();

        // play rock paper scissor and store result to string variable
        String result = rockPaperScissors.playRockPaperScissors(playerChoice);

        // load computer choice
        computerChoice.setText(rockPaperScissors.getComputerChoice());

        // load player choice
        playerChoice1.setText(playerChoice);

        // update score
        computerScoreLabel.setText("Computer: " + rockPaperScissors.getComputerScore());
        playerScoreLabel.setText("Player: " +rockPaperScissors.getPlayerScore());

        // display result dialog
        showDialog(result);
    }
}
