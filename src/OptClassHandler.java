import javax.swing.*;

public class OptClassHandler {
    public static void switchToTheOptPanel(Ticket ticketInput, JFrame frame) {
        OptTicketUser thirdJPanelOpt = new OptTicketUser(ticketInput, frame);
        frame.add(thirdJPanelOpt);
        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        /*
        while (!thirdJPanelOpt.getToBeDeleted()) {
            System.out.println();
            if (thirdJPanelOpt.getToBeDeleted()) {
                frame.remove(thirdJPanelOpt);
                frame.add(panel);
                frame.revalidate();
                frame.repaint();
            }
        }*/
    }
}
