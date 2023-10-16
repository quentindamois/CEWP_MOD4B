package Bank;

import javax.swing.*;

public class Bank {
    private String name;
    public boolean receiveTransaction(String transactionOrder) {
        return true;
    }
    public boolean performTransaction(String TransactionPrder) {
        return true;
    }
    private void notifyClient() {
    }
    private double convertCurrency(double amountCurrecny, String currencyName) {
        double res = amountCurrecny;
        if ("CAD" == currencyName) {
            res *= 1.43;
        } else if ("EUR" == currencyName) {
            res *= 0.68;
        }
        else {
            JOptionPane.showMessageDialog(null,"No valid currency inputed.");
        }
        return res;
    }
    private double sendAConversionFee(double Currency) {
        return 1.5;
    }
    private String getName() {
        return this.name;
    }
}
