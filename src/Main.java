import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TVM Interface");

        JPanel panel = new JPanel();
        Ticket ticketUser = new Ticket();
        ticketUser.setClassTicket("standart");
        
         AgeAndDatePanel ageAndDatePanel = new AgeAndDatePanel(frame, panel);
        JButton buyTicketButton = new JButton("Buy a Ticket");
        buyTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.add(ageAndDatePanel);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        TicketClassPanel ticketClassPanel = new TicketClassPanel(frame, panel);
        JButton nextPageButton = ageAndDatePanel.getNextPage();
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(ageAndDatePanel);
                frame.add(ticketClassPanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        AdminPanel adminPanel = new AdminPanel(frame, panel);
        JButton adminButton = new JButton("Access admin interface");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.add(adminPanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        panel.add(buyTicketButton);
        panel.add(adminButton);

        frame.add(panel);
        //OptClassHandler.switchToTheOptPanel(ticketUser, frame, panel);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}