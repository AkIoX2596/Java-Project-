import java.io.Serializable;

public class Expense implements Serializable {
    private double amount;
    private String category;
    private String note;
    private String date;

    public Expense(double amount, String category, String note, String date) {
        this.amount = amount;
        this.category = category;
        this.note = note;
        this.date = date;
    }

    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getNote() { return note; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return date + " | " + category + " | $" + amount + " | " + note;
    }
}