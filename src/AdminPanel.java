import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    public AdminPanel(JFrame frame, JPanel lastPanel) {
        JButton updatePricesButton = new JButton("Update prices");
        JButton updateTrainScheduleButton = new JButton("Update train schedule");
        add(updatePricesButton);
        add(updateTrainScheduleButton);
        setBackground(new Color(120, 120, 120));
    }

}
