import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandlers {
    private static final String TRANSACTIONS_FILE_PATH = "src/main/resources/transactions.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static List<Ledger> readTransactionsFromCSV() {
        List<Ledger> transactionList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE_PATH);
             Scanner scanner = new Scanner(fis)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] transaction = line.split("\\|");
                LocalDate date = LocalDate.parse(transaction[0], DATE_FORMATTER);
                LocalTime time = LocalTime.parse(transaction[1], TIME_FORMATTER);
                String description = transaction[2];
                String vendor = transaction[3];
                double amount = Double.parseDouble(transaction[4]);

                Ledger newTransaction = new Ledger(date, time, description, vendor, amount);
                transactionList.add(newTransaction);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + TRANSACTIONS_FILE_PATH);
        } catch (IOException ex) {
            System.out.println("Error reading transactions from CSV.");
        }
        return transactionList;
    }

    static void saveTransactionToCSV(Ledger newTransaction) {
        try (FileWriter appendTransactionWriter = new FileWriter(TRANSACTIONS_FILE_PATH, true)) {
            File file = new File(TRANSACTIONS_FILE_PATH);
            if (!file.exists()) {
                appendTransactionWriter.write("Date|Time|Description|Vendor|Amount\n");
            }

            appendTransactionWriter.write(String.format("%s|%s|%s|%s|%.2f%n",
                    newTransaction.getDate().format(DATE_FORMATTER),
                    newTransaction.getTime().format(TIME_FORMATTER),
                    newTransaction.getDescription(),
                    newTransaction.getVendor(),
                    newTransaction.getAmount()));

        } catch (IOException ex) {
            System.out.println("There's a problem with saving the transaction to CSV.");
        }
    }
}
