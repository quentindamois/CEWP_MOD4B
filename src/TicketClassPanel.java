import javax.swing.*;
import java.awt.*;
public class TicketClassPanel extends JPanel {
    private JTextField TicketClass;
    public TicketClassPanel(JFrame frame, JPanel lastPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel labelTicketClass = new JLabel("Enter ticket class (premier, premimum or standart) : ");
        TicketClass = new JTextField(20);
        JButton ok = new JButton("Validate");

        // Personnalisation des composants
        labelTicketClass.setFont(new Font("Arial", Font.PLAIN, 14));
        TicketClass.setFont(new Font("Arial", Font.PLAIN, 14));
        ok.setFont(new Font("Arial", Font.PLAIN, 14));

        ok.setBackground(new Color(0, 153, 0));
        ok.setForeground(Color.WHITE);
        ok.setFocusPainted(false);

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
        add(ok, gbc);

        setBackground(new Color(200, 200, 200));
        }
}