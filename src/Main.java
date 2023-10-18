import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static double ticketPrice = 59.95;
    public static void main(String[] args) {
        JFrame frame = new JFrame("TVM Interface");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton buyTicketButton = new JButton("Buy a Ticket");
        buyTicketButton.setFont(new Font("Arial", Font.PLAIN, 40));

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

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(200, 0, 0, 0);
        panel.add(adminButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(150, 0, 0, 0);
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(buyTicketButton, constraints);

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
