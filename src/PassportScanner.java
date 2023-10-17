import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassportScanner extends JFrame {
    public PassportScanner() {
        super("Scan passport");

        JPanel panel = new JPanel();
        JLabel scanLabel = new JLabel("Please scan your passport.");
        JButton scanButton = new JButton("Scan");

        panel.add(scanLabel);
        panel.add(scanButton);

        add(panel);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //FinalPage finalPage = new FinalPage();
                //finalPage.setVisible(true);
            }
        });
    }
}

