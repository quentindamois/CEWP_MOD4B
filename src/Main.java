import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TVM Interface");

        JPanel panel = new JPanel();

        JButton buyTicketButton = new JButton("Buy a Ticket");
        JButton adminButton = new JButton("Access admin interface");

        panel.add(buyTicketButton);
        panel.add(adminButton);

        frame.add(panel);

        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
