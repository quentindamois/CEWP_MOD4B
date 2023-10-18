import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuyTicketPanel extends JPanel {
    
    private ArrayList<JButton> buttons = new ArrayList<JButton>();

    public BuyTicketPanel(JFrame frame, JPanel lastPanel, String[][] listTickets){

        // Create a vertical box layout to hold the ticket information and buttons
        BoxLayout layout = new BoxLayout(lastPanel, BoxLayout.Y_AXIS);
        lastPanel.setLayout(layout);

        // Create a list of buttons to display the ticket information
        for (int i = 0; i < listTickets.length; i++) {
            String[] ticket = listTickets[i];
            JButton button = new JButton(ticket[0] + " - " + ticket[1]);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // When the button is clicked, display the ticket information
                    JOptionPane.showMessageDialog(frame, "Ticket Information:\n" +
                            "Price: " + ticket[0] + "\n" +
                            "Date: " + ticket[1] );
                }
            });
            buttons.add(button);
        }
        // Add the buttons to the panel
        for (JButton button : buttons) {
            add(button);
        }
    }
    public ArrayList<JButton> getButtons() {
        return buttons;
    }
}
            
    

    