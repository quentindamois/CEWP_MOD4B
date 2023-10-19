import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuyTicketPanel extends JPanel {
    
    private ArrayList<JButton> buttons = new ArrayList<JButton>();
    private ArrayList<String> price = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    public BuyTicketPanel(JFrame frame, JPanel lastPanel, String[][] listTickets, Ticket ticketCreated){
        // Create a vertical box layout to hold the ticket information and buttons
        BoxLayout layout = new BoxLayout(lastPanel, BoxLayout.Y_AXIS);
        lastPanel.setLayout(layout);
        // Create a list of buttons to display the ticket information
        for (int i = 0; i < listTickets.length; i++) {
            String[] ticket = listTickets[i];
            price.add(ticket[0]);
            date.add(ticket[1]);
            JButton button = new JButton(ticket[0] + " - " + ticket[1]);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // When the button is clicked, display the ticket information
                    JOptionPane.showMessageDialog(frame, "Ticket Information:\n" +
                            "Price: " + ticket[0] + " CAD\n" +
                            "Date: " + ticket[1] );
                    ticketCreated.setTravelDates(ticket[1]);
                    ticketCreated.setPrice(ticket[0]);
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
    public ArrayList<String> getDate() {
        return date;
    }
    public ArrayList<String> getPrice() {
        return price;
    }
}
            
    

    