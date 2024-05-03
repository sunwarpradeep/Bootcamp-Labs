import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
//This HomeScreenMethods class contains methods for adding deposits, making payments, and
// displaying the ledger menu with options to view transactions or run reports.
public class HomeScreen {
    static void addDeposit(ArrayList<Ledger> transactionList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the following deposit information:");
        System.out.println("Enter the date (YYYY-MM-DD): ");
        LocalDate dateInput = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter the time (Hour:Minute AM/PM): ");
        LocalTime timeInput = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("h:mm a"));
        System.out.println("Enter a description: ");
        String userDescription = scanner.nextLine();
        System.out.println("Enter the vendor name: ");
        String vendorName = scanner.nextLine();
        System.out.println("Enter an amount: ");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine();

        Ledger newTransaction = new Ledger(dateInput, timeInput, userDescription, vendorName, depositAmount);
        transactionList.add(newTransaction);
        FileHandlers.saveTransactionToCSV(newTransaction);
        System.out.println("Deposit successfully added. \n");
    }

    static void makePayment(ArrayList<Ledger> transactionList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the following payment information:");
        System.out.println("Enter the date (YYYY-MM-DD): ");
        LocalDate dateInput = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter the time (Hour:Minute AM/PM): ");
        LocalTime timeInput = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("h:mm a"));
        System.out.println("Enter a description: ");
        String userDescription = scanner.nextLine();
        System.out.println("Enter the vendor name: ");
        String vendorName = scanner.nextLine();
        System.out.println("Enter an amount: ");
        double paymentAmount = scanner.nextDouble();
        scanner.nextLine();

        Ledger newTransaction = new Ledger(dateInput, timeInput, userDescription, vendorName, -paymentAmount);
        transactionList.add(newTransaction);
        FileHandlers.saveTransactionToCSV(newTransaction);
        System.out.println("Payment successfully added. \n");
    }

    static void displayLedger(ArrayList<Ledger> transactionList) {
        Scanner scanner = new Scanner(System.in);
        boolean isMakingSelection = true;

        while (isMakingSelection) {
            System.out.println("Welcome to the Ledger Menu.");
            System.out.println("1. Display all Entries.");
            System.out.println("2. Display Deposits.");
            System.out.println("3. Display Payments.");
            System.out.println("4. Run Report.");
            System.out.println("5. Go back to the home screen.");
            System.out.print("Please enter a number: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid option.");
                continue;
            }

            switch (choice) {
                case 1:
                    LedgerFunction.displayAllEntries(transactionList);
                    break;
                case 2:
                    LedgerFunction.displayDeposits(transactionList);
                    break;
                case 3:
                    LedgerFunction.displayPayments(transactionList);
                    break;
                case 4:
                    LedgerFunction.runReport(transactionList);
                    break;
                case 5:
                    isMakingSelection = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
