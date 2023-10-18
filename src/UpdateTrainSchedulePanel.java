import javax.swing.*;
import java.awt.*;

public class UpdateTrainSchedulePanel extends JPanel {
    private int index = 0;
    public UpdateTrainSchedulePanel(JFrame frame, JPanel lastPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.remove(this);
            frame.add(lastPanel);
            frame.revalidate();
            frame.repaint();
        });

        JTextField updateScheduleField1 = new JTextField(10);
        updateScheduleField1.setFont(new Font("Arial", Font.PLAIN, 24));
        updateScheduleField1.setText(String.valueOf(""));

        JTextField updateScheduleField2 = new JTextField(10);
        updateScheduleField2.setFont(new Font("Arial", Font.PLAIN, 24));
        updateScheduleField2.setText(String.valueOf(""));

        JButton updateTrainScheduleButton = new JButton("Update this train");
        updateTrainScheduleButton.setFont(new Font("Arial", Font.PLAIN, 24));
        updateTrainScheduleButton.addActionListener(e -> {});


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(-400, 0, 0, 720);
        add(backButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 100, 0);
        add(updateScheduleField1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 30, 0);
        add(updateScheduleField2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(100, 0, 0, 0);
        add(updateTrainScheduleButton, constraints);
    }
}
