
import java.util.ArrayList;
import java.util.List;
//Code represents a basic control flow structure for a simple accounting ledger application. It reads transactions from a CSV file
// Displays a menu to the user, and performs actions based on the user's choice

public class Main {
    public static void main(String[] args) {
        List<Ledger> transactionList = FileHandlers.readTransactionsFromCSV();

        while (true) {
            int choice = UserInterface.HomeScreenAndOptions();
            switch (choice) {
                case 1:
                    HomeScreen.addDeposit((ArrayList<Ledger>) transactionList);
                    break;
                case 2:
                    HomeScreen.makePayment((ArrayList<Ledger>) transactionList);
                    break;
                case 3:
                    HomeScreen.displayLedger((ArrayList<Ledger>) transactionList);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}