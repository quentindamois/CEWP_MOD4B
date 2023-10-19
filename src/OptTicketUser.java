import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class OptTicketUser extends JPanel {
    private boolean toBeDeleted;
    private Set<String> seatTaken;
    private Ticket userTicket;
    private JLabel selectSeatInformation;
    private JLabel inputLuggageInformation;
    private JLabel displaySeatSelected;
    private final String[] standartLayout = {"a1", "b1", "c1", "d1", "e1", "f1", "a2", "b2", "c2", "d2", "e2", "f2", "a3", "b3", "c3", "d3", "e3", "f3", "a4", "b4", "c4", "d4", "e4", "f4", "a5", "b5", "c5", "d5", "e5", "f5"};
    private final String[] premiumLayout = {"a1", "b1", "c1", "d1", "a2", "b2", "c2", "d2", "a3", "b3", "c3", "d3", "a4", "b4", "c4", "d4",  "a5", "b5", "c5", "d5"};
    private final String[] premierLayout = {"a1", "b1", "a2", "b2", "a3", "b3","a4", "b4", "a5", "b5"};
    private JButton[] seatButton;
    private JButton[] alleyInvisibleButton;
    private String seatSelected;
    private JButton validate;
    private JTextField lugageWeghtInput;
    private JFrame nestFrame;
    public boolean getToBeDeleted() {
        return this.toBeDeleted;
    }
    OptTicketUser(Ticket userTicket, JFrame nestFrame) {
        super(new GridLayout(11,7));
        this.nestFrame = nestFrame;
        this.seatTaken = new HashSet<>();
        this.toBeDeleted = false;
        this.seatTaken.add("a3");
        this.seatTaken.add("b2");
        this.seatTaken.add("c5");
        this.seatTaken.add("d6");
        this.seatTaken.add("f4");
        //super();
        this.userTicket = userTicket;
        this.alleyInvisibleButton = new JButton[5];
        for (int i = 0; i < 5; i++) {
            this.alleyInvisibleButton[i] = new JButton("se");
            this.alleyInvisibleButton[i].setVisible(false);
        }
        if (this.userTicket.getClassTicket().equals("premier")) {
            this.seatButton = new JButton[this.premierLayout.length];
            for (int i = 0; i < this.premierLayout.length; i++) {
                this.seatButton[i] = new JButton(premierLayout[i]);
                this.seatButton[i].addActionListener(new choosingASeat(i));
                if (isItTaken(this.seatButton[i].getText())) {
                    this.seatButton[i].setBackground(Color.RED);
                } else {
                    this.seatButton[i].setBackground(Color.CYAN);
                }
            }
        } else if (this.userTicket.getClassTicket().equals("premium")) {
            this.seatButton = new JButton[this.premiumLayout.length];
            for (int i = 0; i < this.premiumLayout.length; i++) {
                this.seatButton[i] = new JButton(premiumLayout[i]);
                this.seatButton[i].addActionListener(new choosingASeat(i));
                if (isItTaken(this.seatButton[i].getText())) {
                    this.seatButton[i].setBackground(Color.RED);
                } else {
                    this.seatButton[i].setBackground(Color.CYAN);
                }
            }
        } else {
            this.seatButton = new JButton[this.standartLayout.length];
            for (int i = 0; i < this.standartLayout.length; i++) {
                this.seatButton[i] = new JButton(standartLayout[i]);
                this.seatButton[i].addActionListener(new choosingASeat(i));
                if (isItTaken(this.seatButton[i].getText())) {
                    this.seatButton[i].setBackground(Color.RED);
                } else {
                    this.seatButton[i].setBackground(Color.CYAN);
                }
            }
        }

        this.lugageWeghtInput = new JTextField();
        this.seatSelected = "";
        this.validate = new JButton("validate");
        this.validate.addActionListener(new getToNextStep());
        this.selectSeatInformation = new JLabel("Select a seat");
        this.inputLuggageInformation = new JLabel("Enter your luggage information:");
        this.displaySeatSelected = new JLabel(this.seatSelected);
        /*
        for (int i = 0; i < this.seatButton.length; i++) {
            this.add(this.seatButton[i]);
        }
         */
        displayInTheCenter(new JLabel("Select a seat if you want. The front is at the top."));
        orderedAdding();
        displayInTheCenter(this.displaySeatSelected);
        displayInTheCenter(this.inputLuggageInformation);
        displayInTheCenter(new JLabel("Enter the weight of your luggage to register it."));
        displayInTheCenter(this.lugageWeghtInput);
        displayInTheCenter(this.validate);
        /*
        this.add(this.displaySeatSelected);
        this.add(this.inputLuggageInformation);
        this.add(this.lugageWeghtInput);
        this.add(this.validate);
         */
    }
    private void displayInTheCenter(Component c) {
        JButton tempButtonIndicator;
        for (int i = 0; i < 3; i++) {
            tempButtonIndicator = new JButton("se");
            tempButtonIndicator.setVisible(false);
            this.add(tempButtonIndicator);
        }
        this.add(c);
        for (int i = 0; i < 3; i++) {
            tempButtonIndicator = new JButton("se");
            tempButtonIndicator.setVisible(false);
            this.add(tempButtonIndicator);
        }
    }
    private void orderedAdding() {
        if (this.userTicket.getClassTicket().equals( "premier")) {
            JButton tempInvisibleJButton;
            for (int i = 0; i < 5; i++) {
                tempInvisibleJButton = new JButton("se");
                tempInvisibleJButton.setVisible(false);
                this.add(tempInvisibleJButton);
                tempInvisibleJButton = new JButton("se");
                tempInvisibleJButton.setVisible(false);
                this.add(tempInvisibleJButton);
                for (int j = 0; j < 1; j++) {
                    this.add(this.seatButton[i * 2 + j]);
                }
                this.add(this.alleyInvisibleButton[i]);
                for (int j = 1; j < 2; j++) {
                    this.add(this.seatButton[i * 2 + j]);
                }
                tempInvisibleJButton = new JButton("se");
                tempInvisibleJButton.setVisible(false);
                this.add(tempInvisibleJButton);
                tempInvisibleJButton = new JButton("se");
                tempInvisibleJButton.setVisible(false);
                this.add(tempInvisibleJButton);
            }
        } else if (this.userTicket.getClassTicket().equals( "premium")) {
            JButton tempInvisibleJButton;
            for (int i = 0; i < 5; i++) {
                tempInvisibleJButton = new JButton("se");
                tempInvisibleJButton.setVisible(false);
                this.add(tempInvisibleJButton);
                for (int j = 0; j < 2; j++) {
                    this.add(this.seatButton[i * 4 + j]);
                }
                this.add(this.alleyInvisibleButton[i]);
                for (int j = 2; j < 4; j++) {
                    this.add(this.seatButton[i * 4 + j]);
                }
                tempInvisibleJButton = new JButton("se");
                tempInvisibleJButton.setVisible(false);
                this.add(tempInvisibleJButton);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    this.add(this.seatButton[i * 6 + j]);
                }
                this.add(this.alleyInvisibleButton[i]);
                for (int j = 3; j < 6; j++) {
                    this.add(this.seatButton[i * 6 + j]);
                }
            }
        }
    }
    private boolean isItTaken(String seatReference) {
        boolean res = false;
        if (this.seatTaken.contains(seatReference)) {
            res = true;
        }
        return res;
    }
    private class choosingASeat implements ActionListener {
        private int buttonNumber;
        public choosingASeat(int buttonNumber) {
            super();
            this.buttonNumber = buttonNumber;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!seatButton[this.buttonNumber].getText().contains(seatSelected) || seatSelected.isBlank()) {
            if (userTicket.getClassTicket() == "premier") {
                if (isItTaken(premierLayout[this.buttonNumber])) {
                    seatSelected = "";
                    displaySeatSelected.setText("This seat is already taken.");
                } else {
                    seatSelected = "" + premierLayout[this.buttonNumber];
                    displaySeatSelected.setText("You selected " + seatSelected);
                }
            } else if (userTicket.getClassTicket() == "premium") {
                if (isItTaken(premiumLayout[this.buttonNumber])) {
                    seatSelected = "";
                    displaySeatSelected.setText("This seat is already taken.");
                } else {
                    seatSelected = "" + premiumLayout[this.buttonNumber];
                    displaySeatSelected.setText("You selected " +seatSelected);
                }
            } else {
                if (isItTaken(standartLayout[this.buttonNumber])) {
                    seatSelected = "";
                    displaySeatSelected.setText("This seat is already taken.");
                } else {
                    seatSelected = "" + standartLayout[this.buttonNumber];
                    displaySeatSelected.setText("You selected " + seatSelected);
                }
            }



            for (int i = 0; i < seatButton.length; i++) {
                if (isItTaken(seatButton[i].getText())) {
                    seatButton[i].setBackground(Color.RED);
                } else {
                    seatButton[i].setBackground(Color.CYAN);
                }
            }
                if (userTicket.getClassTicket() == "premier") {
                    if (!isItTaken(premierLayout[this.buttonNumber])) {
                    seatButton[this.buttonNumber].setBackground(Color.ORANGE);
                }

                } else if (userTicket.getClassTicket() == "premium") {
                    if (!isItTaken(premiumLayout[this.buttonNumber])) {
                        seatButton[this.buttonNumber].setBackground(Color.ORANGE);
                    }
                } else {
                    if (!isItTaken(standartLayout[this.buttonNumber])) {
                        if (!isItTaken(standartLayout[this.buttonNumber])) {
                            seatButton[this.buttonNumber].setBackground(Color.ORANGE);
                        }
                    }
                }

        }else {
                displaySeatSelected.setText("");
                seatSelected = "";
                for (int i = 0; i < seatButton.length; i++) {
                    if (isItTaken(seatButton[i].getText())) {
                        seatButton[i].setBackground(Color.RED);
                    } else {
                        seatButton[i].setBackground(Color.CYAN);
                    }
                }
            }
        }
    }
    private class getToNextStep implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            String errorMessage = "";
            boolean seatQuestionAnswered  = false;
            boolean luggageWeightAnswered = false;
            if (seatSelected.length() == 2) {
                System.out.println(seatSelected.length());
                userTicket.setSeat(seatSelected);
                seatQuestionAnswered = true;
            } else if (seatSelected.length() == 0) {
                seatQuestionAnswered = true;
            } else {
                errorMessage += "You didn't select an available seat.";
            }
            double luggageWeight;
            if (!lugageWeghtInput.getText().isBlank()) {
                try {
                    luggageWeight = Double.parseDouble(lugageWeghtInput.getText());
                    if (luggageWeight <= 0) {
                        errorMessage += errorMessage.length() == 0 ? "You entered a negative." : "\nYou entered a negative number.";
                    } else {
                        System.out.println(luggageWeight);
                        System.out.println(userTicket);
                        luggageWeightAnswered = true;
                    }
                } catch (NumberFormatException expetionNumberCustomer) {
                    errorMessage += errorMessage.length() == 0 ? "You didn't put a number inside of the input." : "\nYou didn't put a number inside of the input.";
                }
            }
            else {
                luggageWeightAnswered = true;
            }
            System.out.println(errorMessage);
            displaySeatSelected.setText(errorMessage);
            if ( seatQuestionAnswered && luggageWeightAnswered) {
                nestFrame.dispose();
                BuyTicket ticketFrame = new BuyTicket(Double.parseDouble(userTicket.getPrice()));
                ticketFrame.setVisible(true);
            }
            System.out.println(toBeDeleted);
        }
    }
}
