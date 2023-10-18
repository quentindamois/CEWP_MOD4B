import javax.swing.*;
import java.awt.*;

public class UpdatePricePanel extends JPanel {
    public UpdatePricePanel(JFrame frame, JPanel lastPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.remove(this);
            frame.add(lastPanel);
            frame.revalidate();
            frame.repaint();
        });

        JTextField updatePricesField = new JTextField(10);
        updatePricesField.setFont(new Font("Arial", Font.PLAIN, 24));
        updatePricesField.setText(String.valueOf(Main.ticketPrice));

        JButton updatePricesButton = new JButton("Update price");
        updatePricesButton.setFont(new Font("Arial", Font.PLAIN, 24));
        updatePricesButton.addActionListener(e -> {
            try {
                Double.parseDouble(updatePricesField.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Please enter a valid price");
                updatePricesField.setText(String.valueOf(Main.ticketPrice));
                return;
            }
            String newPrice = updatePricesField.getText();
            Main.ticketPrice = Double.parseDouble(newPrice);
            JOptionPane.showMessageDialog(null, "Price updated to " + newPrice + " EUR");
            frame.remove(this);
            frame.add(lastPanel);
            frame.revalidate();
            frame.repaint();
        });


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(-400, 0, 0, 720);
        add(backButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 100, 0);
        add(updatePricesField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(100, 0, 0, 0);
        add(updatePricesButton, constraints);
    }
}
