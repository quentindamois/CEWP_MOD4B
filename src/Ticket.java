import java.util.Date;

public class Ticket {
    private String travelDates;
    private String Price;
    private String classTicket;
    private String boarding;
    private String seat;
    private String train;
    public String getTravelDates() {
        return this.travelDates;
    }
    public void setTravelDates(String travelDates) {
        this.travelDates = travelDates;
    }
    public String getPrice() {
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
    public void setSeat(String seat) {
        this.seat = seat;
    }
    public void setClassTicket(String classTicket) {
        this.classTicket = classTicket;
    }
    public void setPrice(String Price) {this.Price = Price;}
}
