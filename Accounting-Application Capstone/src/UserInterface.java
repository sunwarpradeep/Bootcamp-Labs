
import java.util.InputMismatchException;
import java.util.Scanner;
// The UserInterface class provides a method HomeScreenAndOptions to display the home screen of the Accounting Ledger Application and
// prompt the user to select an option. It ensures that the user input is a valid integer between 1 and 4 and handles invalid input
public class UserInterface {
    public static int HomeScreenAndOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Welcome to the Accounting Ledger Application.");
        System.out.println("What would you like to do?");
        System.out.println("1. Add a Deposit.");
        System.out.println("2. Make a Payment.");
        System.out.println("3. Display Ledger.");
        System.out.println("4. Exit Application.");
        System.out.print("Please enter a number: ");
        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.print("Please enter a valid choice between 1 and 4: ");
                }
            } catch (InputMismatchException ex) {
                System.out.print("Please enter a valid integer choice: ");
                scanner.next();
            }
        }
        return choice;
    }
}