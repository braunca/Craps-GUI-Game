import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/***************************************************************
 * GUI front end to a game of Craps
 ***************************************************************/
public class CrapsGUI extends JFrame implements ActionListener{

    /** visual representation of the dice */
    GVdie d1, d2;

    /** buttons */
    JButton comeOutButton, rollButton;

    /** labels for message and credits */
    JLabel message, credits;

    /** the game of craps object */
    Craps game;    

    /****************************************************************
    Create all elements and display within the GUI
     ****************************************************************/        
    public static void main(String arg[]){
        CrapsGUI gui = new CrapsGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Casey Braun");
        gui.pack();
        gui.setVisible(true);
    }

    /****************************************************************
    Create all elements and display within the GUI
     ****************************************************************/    
    public CrapsGUI(){ 

        // create the game object as well as the GUI Frame   
        game = new Craps();
        game.setCredits(10);
        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();

        // create and place the message label
        message = new JLabel();
        message.setText(game.getMessage());
        position.gridx = 0;
        position.gridy = 0;
        add(message, position);

        // get Die #1 from game and place on frame
        d1 = game.getDie(1);
        position.gridx = 0;
        position.gridy = 1;
        add(d1, position);

        // FIX ME: get Die #2 from game and place on frame
        d2 = game.getDie(2);
        position.gridx = 1;
        position.gridy = 1;
        add(d2, position);
        
        // create and place the Come Out button
        comeOutButton = new JButton("Come Out");
        position.gridx = 0;
        position.gridy = 3;
        add(comeOutButton, position);

        // FIX ME: create and place the Roll button
        rollButton = new JButton("Roll");
        position.gridx = 1;
        position.gridy = 3;
        add(rollButton, position);
        // create and position the Credits label
        credits = new JLabel();
        credits.setText("Credits: " + game.getCredits());
        position.gridx = 0;
        position.gridy = 2;
        add(credits, position);

        // FIX ME: register the listeners
        rollButton.addActionListener(this);
        comeOutButton.addActionListener(this);

    }

    /****************************************************************
    actionPerformed method to repond to the user action

    @param e - the JComponent just selected
     ****************************************************************/
    public void actionPerformed(ActionEvent event){
        
        if (event.getSource() == rollButton){
            game.roll();
            if(!game.okToRoll())
            {
                comeOutButton.setEnabled(true);
                rollButton.setEnabled(false);
            }
                
    }
    if (event.getSource() == comeOutButton){
        game.comeOut();
        if(game.okToRoll())
            {
                comeOutButton.setEnabled(false);
                rollButton.setEnabled(true);
            }
    }
    credits.setText("Credits: " + game.getCredits());
    message.setText(game.getMessage());

        // FIX ME: to test for roll and then game.roll()

        // FIX ME: test for come out and then game.comeOut()
           
        // FIX ME: enable/disable each button based on status of game

        // FIX ME: update the labels

    }
}
