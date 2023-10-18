import javax.swing.*;
import java.awt.*;
public class TicketClassPanel extends JPanel {
    private JTextField TicketClass;
    private JButton nextPage;
    public TicketClassPanel(JFrame frame, JPanel lastPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel labelTicketClass = new JLabel("Enter ticket class (premier, premimum or standart) : ");
        TicketClass = new JTextField(20);
        nextPage = new JButton("Validate");

        // Personnalisation des composants
        labelTicketClass.setFont(new Font("Arial", Font.PLAIN, 14));
        TicketClass.setFont(new Font("Arial", Font.PLAIN, 14));
        nextPage.setFont(new Font("Arial", Font.PLAIN, 14));

        nextPage.setBackground(new Color(0, 153, 0));
        nextPage.setForeground(Color.WHITE);
        nextPage.setFocusPainted(false);

        // Ajout des composants avec GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelTicketClass, gbc);

        gbc.gridx = 1;
        add(TicketClass, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(nextPage, gbc);

        setBackground(new Color(200, 200, 200));
        }
        public JTextField getTicketClass() {
            return TicketClass;
        }
}