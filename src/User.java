public class User {
    private int age;
    private String ticketReference;
    private String firstName;
    private String lastName;
    private int passePort;
    private int visa;
    public void setAge(int age) {
        this.age = age;
    }
    public void setTicketReference(String ticketReference) {
        this.ticketReference = ticketReference;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassePort(int passePort) {
        this.passePort = passePort;
    }
    public void setVisa(int visa) {
        this.visa = visa;
    }
    public int getAge() {
        return this.age;
    }
    public String getTicketReference() {
        return this.ticketReference;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getPassePort() {
        return this.passePort;
    }
    public int getVisa() {
        return this.visa;
    }
}
