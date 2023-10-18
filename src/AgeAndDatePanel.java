import javax.swing.*;
import java.awt.*;
public class AgeAndDatePanel extends JPanel {
    private JTextField age;
    private JTextField travelDate;
    JButton nextPage;
    public AgeAndDatePanel(JFrame frame, JPanel lastPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel labelAge = new JLabel("Enter your age:");
        age = new JTextField(20);
        JLabel labelTravel = new JLabel("Enter your travel date:");
        travelDate = new JTextField(20);
        nextPage = new JButton("Validate");

        // Personnalisation des composants
        labelAge.setFont(new Font("Arial", Font.PLAIN, 14));
        labelTravel.setFont(new Font("Arial", Font.PLAIN, 14));
        age.setFont(new Font("Arial", Font.PLAIN, 14));
        travelDate.setFont(new Font("Arial", Font.PLAIN, 14));
        nextPage.setFont(new Font("Arial", Font.PLAIN, 14));

        nextPage.setBackground(new Color(0, 153, 0));
        nextPage.setForeground(Color.WHITE);
        nextPage.setFocusPainted(false);

        // Ajout des composants avec GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelAge, gbc);

        gbc.gridx = 1;
        add(age, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelTravel, gbc);

        gbc.gridx = 1;
        add(travelDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(nextPage, gbc);

        setBackground(new Color(200, 200, 200));
        }

        public JButton getNextPage() {
            return nextPage;
        }
}