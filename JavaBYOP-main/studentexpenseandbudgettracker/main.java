import java.util.*;
import java.text.SimpleDateFormat;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        try {
            manager.loadFromFile();
        } catch (Exception e) {}

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Category Summary");
            System.out.println("4. Set Monthly Budget");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Category: ");
                    String cat = sc.nextLine();

                    System.out.print("Note: ");
                    String note = sc.nextLine();

                    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

                    manager.addExpense(new Expense(amt, cat, note, date));
                    manager.budgetWarning();
                    break;

                case 2:
                    manager.showAllExpenses();
                    break;

                case 3:
                    manager.showCategorySummary();
                    break;

                case 4:
                    System.out.print("Enter budget: ");
                    double budget = sc.nextDouble();
                    manager.setBudget(budget);
                    break;

                case 5:
                    try {
                        manager.saveToFile();
                    } catch (Exception e) {}
                    System.out.println("Data saved. Exiting...");
                    return;
            }
        }
    }
}