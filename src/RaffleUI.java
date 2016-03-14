/**
 * Created by PJWS on 14/03/2016.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RaffleUI {

    private static void createAndShowGUI() {
        Raffle newRaffle = new Raffle();
        String text = "Participant Name: ";

        //Create and populate the panel.
        JPanel front = new JPanel(new SpringLayout());
        JLabel textLabel = new JLabel(text, JLabel.TRAILING);
        front.add(textLabel);
        JTextField textField = new JTextField(10);
        textLabel.setLabelFor(textField);
        front.add(textField);

        JButton enterButton = new JButton("Enter Participant");
        front.add(new JLabel());
        front.add(enterButton);

        JButton clearButton = new JButton("Clear Participants");
        front.add(new JLabel());
        front.add(clearButton);

        JButton drawButton = new JButton("Draw Winner");
        front.add(new JLabel());
        front.add(drawButton);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(front,
                4, 2,         //rows, cols
                30, 7,        //initX, initY
                30, 7);       //xPad, yPad

        //Actions to perform when "Submit Participant" button is pressed
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Check if text field is empty
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(front, "Please enter a name");
                }
                //If not empty, we have a name, so insert it into array
                else {
                    newRaffle.enter(textField.getText());
                    JOptionPane.showMessageDialog(front, newRaffle.listEntrants());
                }
            }
        });

        //Actions to perform when "Clear Participants" button is pressed
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newRaffle.reset();
                JOptionPane.showMessageDialog(front, "Participant data has been cleared.");
            }
        });

        //Actions to perform when "Draw Winner" button is pressed
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(front, newRaffle.drawWinner());
            }
        });

        //Create and set up the window.
        JFrame frame = new JFrame("Raffle Winner Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        front.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(front);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //create and show GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}



