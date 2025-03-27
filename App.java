import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Instantiate a Rock, Paper, Scissors GUI obj
                RPS_GUI rockPaperScissors = new RPS_GUI();

                // Display the GUI
                rockPaperScissors.setVisible(true);
            }
        });
    }
}