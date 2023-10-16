import java.util.Date;

public class Ticket {
    private Date travelDates;
    private double Price;
    private String classTicket;
    private String boarding;
    private String seat;
    private String train;
    public Date getTravelDates() {
        return this.travelDates;
    }
    public double getPrice() {
        return this.Price;
    }
    public String getClassTicket() {
        return this.classTicket;
    }
    public String getBoarding() {
        return this.boarding;
    }
    public String getSeat() {
        return this.seat;
    }
    public String getTrain() {
        return this.train;
    }
}
