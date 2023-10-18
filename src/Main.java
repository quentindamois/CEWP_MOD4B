import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TVM Interface");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        Ticket ticketUser = new Ticket();
        ticketUser.setClassTicket("standart");

        String[][] listTickets = {{"50 CAD", "2021-01-01"},{"100 CAD", "2021-02-02"},{"150 CAD", "2021-03-03"}};
        
        AgeAndDatePanel ageAndDatePanel = new AgeAndDatePanel(frame, panel);
        TicketClassPanel ticketClassPanel = new TicketClassPanel(frame, panel);
        BuyTicketPanel buyTicketPanel = new BuyTicketPanel(frame, panel, listTickets);
        AdminPanel adminPanel = new AdminPanel(frame, panel);

        JButton buyTicketButton = new JButton("Buy a Ticket");
        JButton adminButton = new JButton("Access admin interface");
        JButton audioHelperButton = new JButton("Activate audio helper");
        JButton nextPageButton1 = ageAndDatePanel.getNextPage();
        JButton nextPageButton2 = ticketClassPanel.getNextPage();

        buyTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.add(ageAndDatePanel);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        nextPageButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(ageAndDatePanel);
                frame.add(ticketClassPanel);
                frame.revalidate();
                frame.repaint();
            }
        });

         nextPageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(ticketClassPanel);
                frame.add(buyTicketPanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.add(adminPanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        middlePanel.add(buyTicketButton);
        middlePanel.add(adminButton);

        panel.add(middlePanel, BorderLayout.CENTER);

        audioHelperButton.setPreferredSize(new Dimension(100, 50));
        panel.add(audioHelperButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}