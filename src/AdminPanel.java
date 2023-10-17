import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    public AdminPanel(JFrame frame, JPanel lastPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton updatePricesButton = new JButton("Update prices");
        updatePricesButton.setFont(new Font("Arial", Font.PLAIN, 24));

        JButton updateTrainScheduleButton = new JButton("Update train schedule");
        updateTrainScheduleButton.setFont(new Font("Arial", Font.PLAIN, 24));


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
