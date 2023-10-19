import javax.swing.*;
import java.awt.*;

public class UpdateTrainSchedulePanel extends JPanel {
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
        updateTrainScheduleButton.addActionListener(e -> {
            try {
                Integer.parseInt(updateScheduleField2.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Please enter a valid price");
                updateScheduleField2.setText(String.valueOf(""));
                return;
            }
            String newSchedule1 = updateScheduleField1.getText();
            String newSchedule2 = updateScheduleField2.getText();
            int index = -1;
            for (int i = 0; i < Main.listTickets.length; i++) {
                if (Main.listTickets[i][1].equals(newSchedule1)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Train " + newSchedule1 + " not found");
                return;
            }
            Main.listTickets[index][0] = newSchedule1;
            Main.listTickets[index][1] = newSchedule2;
            JOptionPane.showMessageDialog(null, "Train " + newSchedule1 + " updated to " + newSchedule2 + " EUR");
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
