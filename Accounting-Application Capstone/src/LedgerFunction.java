import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//The LedgerFunction class provides static methods to display different types of ledger entries, run reports, and
// perform custom searches on the ledger transactions. It encapsulates the logic for sorting, filtering, and
// displaying transactions, providing a convenient interface for interacting with the ledger data.
public class LedgerFunction {
    static void displayAllEntries(List<Ledger> transactionList) {
        sortTransactions(transactionList);
        displayTransactions(transactionList);
    }

    static void displayDeposits(List<Ledger> transactionList) {
        sortTransactions(transactionList);
        List<Ledger> deposits = new ArrayList<>();
        for (Ledger transaction : transactionList) {
            if (transaction.getAmount() > 0) {
                deposits.add(transaction);
            }
        }
        displayTransactions(deposits);
    }

    static void displayPayments(List<Ledger> transactionList) {
        sortTransactions(transactionList);
        List<Ledger> payments = new ArrayList<>();
        for (Ledger transaction : transactionList) {
            if (transaction.getAmount() < 0) {
                payments.add(transaction);
            }
        }
        displayTransactions(payments);
    }

    static void runReport(List<Ledger> transactionList) {
        Scanner scanner = new Scanner(System.in);
        boolean isMakingSelection = true;

        while (isMakingSelection) {
            System.out.println("Welcome to the Report Screen.");
            System.out.println("1. Month to Date.");
            System.out.println("2. Previous Month.");
            System.out.println("3. Year to Date.");
            System.out.println("4. Previous Year.");
            System.out.println("5. Search by Vendor.");
            System.out.println("6. Custom Search.");
            System.out.println("7. Back.");
            System.out.print("Please enter a number: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    monthToDate(transactionList);
                    break;
                case 2:
                    previousMonth(transactionList);
                    break;
                case 3:
                    yearToDate(transactionList);
                    break;
                case 4:
                    previousYear(transactionList);
                    break;
                case 5:
                    searchByVendor(transactionList);
                    break;
                case 6:
                    customSearch(transactionList);
                    break;
                case 7:
                    isMakingSelection = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    static void monthToDate(List<Ledger> transactionList) {
        LocalDate currentDate = LocalDate.now();
        List<Ledger> filteredTransactions = new ArrayList<>();

        for (Ledger transaction : transactionList) {
            if (transaction.getDate().getMonth() == currentDate.getMonth()) {
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);
    }

    static void previousMonth(List<Ledger> transactionList) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDateOfPreviousMonth = currentDate.minusMonths(1).withDayOfMonth(1);
        LocalDate endDateOfPreviousMonth = currentDate.withDayOfMonth(1).minusDays(1);

        List<Ledger> filteredTransactions = new ArrayList<>();

        for (Ledger transaction : transactionList) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.isAfter(startDateOfPreviousMonth) && transactionDate.isBefore(endDateOfPreviousMonth)) {
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);
    }

    static void yearToDate(List<Ledger> transactionList) {
        LocalDate currentDate = LocalDate.now();
        List<Ledger> filteredTransactions = new ArrayList<>();

        for (Ledger transaction : transactionList) {
            if (transaction.getDate().getYear() == currentDate.getYear()) {
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);
    }

    static void previousYear(List<Ledger> transactionList) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDateOfPreviousYear = currentDate.minusYears(1).withDayOfYear(1);
        LocalDate endDateOfPreviousYear = currentDate.withDayOfYear(1).minusDays(1);

        List<Ledger> filteredTransactions = new ArrayList<>();

        for (Ledger transaction : transactionList) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.isAfter(startDateOfPreviousYear) && transactionDate.isBefore(endDateOfPreviousYear)) {
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);
    }

    static void searchByVendor(List<Ledger> transactionList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the vendor name: ");
        String vendorName = scanner.nextLine();

        List<Ledger> filteredTransactions = new ArrayList<>();

        for (Ledger transaction : transactionList) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);
    }

    static void customSearch(List<Ledger> transactions) {
        Scanner scanner = new Scanner(System.in);
        LocalDate startDate = null;
        LocalDate endDate = null;
        String description;
        String vendor;
        double amount = -1;

        System.out.print("Enter start date (yyyy-MM-dd) or leave blank: ");
        String startDateInput = scanner.nextLine();
        if (!startDateInput.isEmpty()) {
            startDate = LocalDate.parse(startDateInput);
        }

        System.out.print("Enter end date (yyyy-MM-dd) or leave blank: ");
        String endDateInput = scanner.nextLine();
        if (!endDateInput.isEmpty()) {
            endDate = LocalDate.parse(endDateInput);
        }

        System.out.print("Enter description or leave blank: ");
        description = scanner.nextLine();

        System.out.print("Enter vendor or leave blank: ");
        vendor = scanner.nextLine();

        System.out.print("Enter amount or leave blank: ");
        String amountInput = scanner.nextLine();
        if (!amountInput.isEmpty()) {
            amount = Double.parseDouble(amountInput);
        }

        List<Ledger> filteredTransactions = new ArrayList<>();
        for (Ledger transaction : transactions) {
            boolean isMatch = true;

            if (startDate != null && !transaction.getDate().isAfter(startDate)) {
                isMatch = false;
            }

            if (endDate != null && !transaction.getDate().isBefore(endDate)) {
                isMatch = false;
            }

            if (description != null && !transaction.getDescription().contains(description)) {
                isMatch = false;
            }

            if (vendor != null && !transaction.getVendor().equalsIgnoreCase(vendor)) {
                isMatch = false;
            }

            if (amount != -1 && Math.abs(transaction.getAmount() - amount) >= 0.01) {
                isMatch = false;
            }

            if (isMatch) {
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);
    }

    static void displayTransactions(List<Ledger> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("Transactions:");
        for (Ledger transaction : transactions) {
            System.out.println(transaction);
            System.out.println("------------------------");
        }
    }

    static void sortTransactions(List<Ledger> transactionList) {
        transactionList.sort(Comparator.comparing(Ledger::getDate).reversed());
    }
}
