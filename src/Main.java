import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TVM Interface");

        JPanel panel = new JPanel();

        JButton buyTicketButton = new JButton("Buy a Ticket");

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
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}