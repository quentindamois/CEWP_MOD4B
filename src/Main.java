import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {
    public static double ticketPrice = 50.0;
    public static String[][] listTickets = {{"50", "2024-01-01"},{"100", "2024-02-02"},{"150", "2024-03-03"}};
    public static void IgoMainFrame() {
        JFrame frame = new JFrame("TVM Interface");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        Ticket ticketUser = new Ticket();
        ticketUser.setClassTicket("standart");

        AgeAndDatePanel ageAndDatePanel = new AgeAndDatePanel(frame, panel);
        TicketClassPanel ticketClassPanel = new TicketClassPanel(frame, panel);
        BuyTicketPanel buyTicketPanel = new BuyTicketPanel(frame, panel, listTickets, ticketUser);
        AdminPanel adminPanel = new AdminPanel(frame, panel);

        JButton buyTicketButton = new JButton("Buy a Ticket");
        JButton adminButton = new JButton("Access admin interface");
        JButton audioHelperButton = new JButton("Activate audio helper");
        JButton nextPageButton1 = ageAndDatePanel.getNextPage();
        JButton nextPageButton2 = ticketClassPanel.getNextPage();
        JButton returnHome = new JButton("Home");

        middlePanel.add(buyTicketButton);
        middlePanel.setLayout(new GridLayout(2, 1));
        middlePanel.add(buyTicketButton);
        middlePanel.add(adminButton);

        panel.add(middlePanel, BorderLayout.CENTER);
        panel.add(audioHelperButton, BorderLayout.SOUTH);
        JPanel home = panel;

        ArrayList<JButton> nextPageButtons3 = buyTicketPanel.getButtons();
        buyTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.add(ageAndDatePanel);
                frame.add(returnHome,BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });

        nextPageButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String errorMessage = "";
                JTextField age = ageAndDatePanel.getAge();
                try {
                    if (age.getText().isBlank()) {
                        errorMessage = "Enter an age please.";
                        JOptionPane.showMessageDialog(frame,errorMessage);
                    }
                    else{
                    int ageInt = Integer.parseInt(age.getText());
                    if (ageInt <= 0) {
                        errorMessage = "You entered a negative age.";
                        JOptionPane.showMessageDialog(frame,errorMessage);
                    } 
                    else
                    {
                        frame.remove(ageAndDatePanel);
                        frame.add(ticketClassPanel);
                        frame.add(returnHome,BorderLayout.SOUTH);
                        frame.revalidate();
                        frame.repaint();
                    }
                }
                } catch (NumberFormatException expetionNumberCustomer) {
                    errorMessage += errorMessage.length() == 0 ? "You didn't put a number inside of the input." : "\nYou didn't put a number inside of the age input.";
                    JOptionPane.showMessageDialog(frame,errorMessage);
                    }           
                };
            });

        nextPageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String errorMessage = "";
                String ticketClass = ticketClassPanel.getTicketClass();
                try {
                    if (ticketClass.isBlank()) {
                        errorMessage = "Enter an ticket class please.";
                        JOptionPane.showMessageDialog(frame,errorMessage);
                    }
                    else{
                        
                    if (ticketClass.equals("premier") || ticketClass.equals("standart") || ticketClass.equals("premium") ) {
                        frame.remove(ticketClassPanel);
                        frame.add(buyTicketPanel);
                        frame.add(returnHome,BorderLayout.SOUTH);
                        frame.revalidate();
                        frame.repaint();
                    } 
                    else
                    {
                        errorMessage = "You entered wrong ticket class, choose between premier, premium or standart";
                        JOptionPane.showMessageDialog(frame,errorMessage);
                    }
                }
                } catch (NumberFormatException expetionNumberCustomer) {
                    errorMessage += errorMessage.length() == 0 ? "You didn't put a number inside of the input." : "\nYou didn't put a number inside of the age input.";
                    JOptionPane.showMessageDialog(frame,errorMessage);
                    }           
                };
            });
        for (JButton b: nextPageButtons3
        ) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(buyTicketPanel);
                    OptClassHandler.switchToTheOptPanel(ticketUser, frame);
                    frame.add(returnHome,BorderLayout.SOUTH);
                    frame.revalidate();
                    frame.repaint();
                }
            });
        }
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.add(adminPanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        returnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.remove(adminPanel);
                frame.remove(ageAndDatePanel);
                frame.remove(ticketClassPanel);
                frame.remove(buyTicketPanel);
                frame.remove(returnHome);
                frame.add(home);
                frame.revalidate();
                frame.repaint();
            }
        });

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        IgoMainFrame();
    }
}