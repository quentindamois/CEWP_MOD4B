import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class BuyTicket extends JFrame {
    private double price;
    private JLabel priceLabel;
    private JComboBox<String> currencyComboBox;
    private JButton payButton;
    private JButton paymentCompleteButton;
    private JPanel panel;

    public BuyTicket(double initialPrice) {
        super("Payment");

        price = initialPrice;
        panel = new JPanel();
        priceLabel = new JLabel("Price: " + price + " EUR");
        currencyComboBox = new JComboBox<>(new String[]{"EUR", "CAD"});
        payButton = new JButton("Pay");
        paymentCompleteButton = new JButton("Payment Complete");
        paymentCompleteButton.setVisible(false); // Start by hiding it

        panel.add(priceLabel);
        panel.add(currencyComboBox);
        panel.add(payButton);
        panel.add(paymentCompleteButton);

        add(panel);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide unnecessary components and show the "Payment Complete" button
                payButton.setVisible(false);
                currencyComboBox.setVisible(false);
                priceLabel.setVisible(false);
                paymentCompleteButton.setVisible(true);
                revalidate();
                repaint();
            }
        });

        paymentCompleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PassportScanner passportScanner = new PassportScanner();
                passportScanner.setVisible(true);
            }
        });

        currencyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the currency is changed, update the displayed price
                String selectedCurrency = (String) currencyComboBox.getSelectedItem();
                if (selectedCurrency.equals("CAD")) {
                    price = initialPrice * 1.4;
                } else {
                    price = initialPrice;
                }
                updatePriceLabel(selectedCurrency);
            }
        });
    }

    private void updatePriceLabel(String selectedCurrency) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00"); // Format the price with two decimals
        if (selectedCurrency.equals("CAD")) {
            priceLabel.setText("Price: " + decimalFormat.format(price) + " CAD");
        } else {
            priceLabel.setText("Price: " + decimalFormat.format(price) + " EUR");
        }
    }
}

