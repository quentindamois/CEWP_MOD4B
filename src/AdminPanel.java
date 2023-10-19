import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    public AdminPanel(JFrame frame, JPanel lastPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.remove(this);
            frame.add(lastPanel);
            frame.revalidate();
            frame.repaint();
        });

        UpdatePricePanel updatePricePanel = new UpdatePricePanel(frame, this);
        JButton updatePricesButton = new JButton("Update prices");
        updatePricesButton.setFont(new Font("Arial", Font.PLAIN, 24));
        updatePricesButton.addActionListener(e -> {
            frame.remove(this);
            frame.add(updatePricePanel);
            frame.revalidate();
            frame.repaint();
        });

        UpdateTrainSchedulePanel updateTrainSchedulePanel = new UpdateTrainSchedulePanel(frame, this);
        JButton updateTrainScheduleButton = new JButton("Update trains");
        updateTrainScheduleButton.setFont(new Font("Arial", Font.PLAIN, 24));
        updateTrainScheduleButton.addActionListener(e -> {
            frame.remove(this);
            frame.add(updateTrainSchedulePanel);
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
        add(updatePricesButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(100, 0, 0, 0);
        add(updateTrainScheduleButton, constraints);
    }
}
