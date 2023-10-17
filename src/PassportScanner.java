import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassportScanner extends JFrame {
    public PassportScanner() {
        super("Scanner de passeport");

        JPanel panel = new JPanel();
        JLabel scanLabel = new JLabel("Veuillez scanner votre passeport.");
        JButton scanButton = new JButton("Scanner");

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

