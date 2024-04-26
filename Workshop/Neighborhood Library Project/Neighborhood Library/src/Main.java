import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[20];

        books[0] = new Book(1, "0123", "Effective Java", true, "Pradeep");
        books[1] = new Book(2, "0124", "Clean Code", true, "Jonthan");
        books[2] = new Book(3, "0125", " Head First Java", true, "Kirk");
        books[3] = new Book(4, "0126", "Thinking in Java ", true, "Max");
        books[4] = new Book(5, "0127", "The Power of habits ", false, "");
        books[5] = new Book(6, "0128", " Rich dad Poor dad", false, "");
        books[6] = new Book(7, "0129", "Principle of life work", false, "");
        books[7] = new Book(8, "0133", "Thinking fast and slow", false, "");
        books[8] = new Book(9, "0134", " The lean startup ", false, "");
        books[9] = new Book(10, "0135", " How to win friends", false, "");
        books[10] = new Book(11, "0136", "Blue Ocean Strategy", false, "");
        books[11] = new Book(12, "0137", "The art of warr", false, "");
        books[12] = new Book(13, "0138", "Grits", false, "");
        books[13] = new Book(14, "0139", "Measure what mattars ", false, "");
        books[14] = new Book(15, "0143", "The Innovator", false, "");
        books[15] = new Book(16, "0144", " Curshing it", false, "");
        books[16] = new Book(17, "0145", " Zero to one", false, "");
        books[17] = new Book(18, "0146", "The E-Myth", false, "");
        books[18] = new Book(19, "0147", " Java Design", true, "Alexendra");
        books[19] = new Book(20, "0148", " Java Network Programming", true, "Alina");


        while (true){
            System.out.println(" Select the Option ?");
            System.out.println(" 1 - Show Available Books");
            System.out.println(" 2 - Show Checked Out Books");
            System.out.println(" 3 - Exit ");
            System.out.println("Enter a command number: ");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    Book.showAvailableBooks(books);
                    System.out.println(" Please the Option below ?");
                    System.out.println(" 1 - Select a book to check out");
                    System.out.println(" 2 - Exit");
                    System.out.println("Enter a command number: ");

                    int availableBooksOptions = scanner.nextInt();
                    scanner.nextLine();

                    switch (availableBooksOptions) {
                        case 1:
                            Book.showAvailableBooks(books);
                            System.out.println("Enter the book number to check out: ");
                            int bookNumber = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (bookNumber >= 1 && bookNumber <= books.length) {
                                Book selectedBook = books[bookNumber - 1];
                                selectedBook.checkOut();
                            } else {
                                System.out.println("Invalid book number.");
                            }
                            break;

                        case 2:
                        default:
                            System.out.println("Returning to home screen.");
                            break;
                    }
                    break;

                case 2:
                    Book.showCheckedOutBooks(books);
                    System.out.println("Would you like to: ");
                    System.out.println(" A - Check in a book");
                    System.out.println(" X - Exit - goes back to home screen");
                    System.out.println("Enter a command letter: ");

                    String checkedOutBooksOptions = scanner.nextLine();

                    if (checkedOutBooksOptions.equalsIgnoreCase("A")) {
                        System.out.println("Enter the book number to check in: ");
                        int bookNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (bookNumber >= 1 && bookNumber <= books.length) {
                            Book selectedBook = books[bookNumber - 1];
                            selectedBook.checkIn();
                        } else {
                            System.out.println("Invalid book number.");
                        }
                    }
                    else if (checkedOutBooksOptions.equalsIgnoreCase("X")) {
                    }
                    else {
                        System.out.println("Invalid command. Returning to the home screen.");
                    }
                    break;

                case 3:
                    System.exit(0);
            }

        }

    }

}