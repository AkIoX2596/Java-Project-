import java.io.*;
import java.util.*;

public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private double monthlyBudget = 0;

    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public void setBudget(double budget) {
        this.monthlyBudget = budget;
    }

    public void showAllExpenses() {
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void showCategorySummary() {
        HashMap<String, Double> map = new HashMap<>();
        for (Expense e : expenses) {
            map.put(e.getCategory(),
                map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }
        for (String cat : map.keySet()) {
            System.out.println(cat + " : ₹" + map.get(cat));
        }
    }

    public double totalSpent() {
        double sum = 0;
        for (Expense e : expenses) sum += e.getAmount();
        return sum;
    }

    public void budgetWarning() {
        if (monthlyBudget > 0) {
            double spent = totalSpent();
            if (spent > monthlyBudget) {
                System.out.println("⚠ Budget exceeded!");
            } else if (spent > 0.8 * monthlyBudget) {
                System.out.println("⚠ You have used 80% of your budget.");
            }
        }
    }

    public void saveToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("expenses.dat"));
        oos.writeObject(expenses);
        oos.close();
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        File file = new File("expenses.dat");
        if (file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            expenses = (ArrayList<Expense>) ois.readObject();
            ois.close();
        }
    }
}