import java.time.LocalDate;
import java.time.LocalTime;

// It provides attributes to store the date, time, description, vendor, and amount of the transaction.
//getter and setter methods to access and modify its attributes.
public class Ledger {

    private final LocalDate date;
    private final LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Ledger(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Date: %s%nTime: %s%nDescription: %s%nVendor: %s%nAmount: %.2f",
                date, time, description, vendor, amount);
    }

    // Getters and setters
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
