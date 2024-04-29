import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Screens {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> cart = new ArrayList<>();
    public void displayHomeInterface(){
        while(true) {
            System.out.println("""
            Welcome to Online Store
            1- Would you like to check-out our products?
            2- Would you like to see your cart?
            3- Exit """);

           switch (validateInput()) {
                case 1:
                    displayInventory();
                    break;
                case 2:
                   displayBuggy();
                    break;
                case 3:
                    System.out.println("Thank you, Have a nice day! ");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
    public void displayInventory(){
        for(Product product : getProduct()){
            System.out.printf("Name: %s|Price: %.2f|Department: %s\n",
                    product.getName(), product.getPrice(), product.getDepartment());
        }
        System.out.println("""
        List of the Products
        1- Products and Search
        2- Add products to screen
        3- Exit """);

        switch(validateInput()){
            case 1:
                searchOption();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                displayHomeInterface();
                break;
            default:
                displayInventory();
                break;
        }
    }
    public void displayBuggy(){
        System.out.println(" Welcome to your Cart Collection");
        getCart(cart);
        System.out.println("Would you like to remove an item? (Yes / No)");
        scanner.nextLine();
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("yes")){
            System.out.println("Enter the product name to remove: ");
            String answer = scanner.nextLine();
            cart.removeIf(product -> product.getName().equalsIgnoreCase(answer));
        }
        else if(input.equalsIgnoreCase("no")){
            displayHomeInterface();
        }

    }
    public void searchOption(){
        System.out.println("""
        Search Button
        1- Search by Name
        2- Search by Department """);
        switch (validateInput()) {
            case 1:
                System.out.print("Enter the name of the product: ");
                scanner.nextLine();
                String productName = scanner.nextLine().trim();
                for (Product product: getProduct()){
                    if(product.getName().equalsIgnoreCase(productName)){
                        System.out.printf("\nYour result: %s",product.getName());
                    }
                }
                addProduct();
                System.out.print("Returning to Products Screen...\n");
                displayInventory();
                break;
            case 2:
                System.out.print("Enter the department of the product: \n");
                scanner.nextLine();
                String productDepartment = scanner.nextLine().trim();
                for (Product product: getProduct()){
                    if(product.getDepartment().equalsIgnoreCase(productDepartment)){
                        System.out.printf("Name: %s|Price: %.2f|Department: %s\n",
                                product.getName(), product.getPrice(), product.getDepartment());
                    }
                }
                addProduct();

                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }
    public void addProduct(){
        System.out.println("\nWould you like to add a product to the screen? (Yes / No)");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            System.out.println("Enter the product name you would like to add today?");
            String name = scanner.nextLine();
            for (Product product: getProduct()){
                if(name.equalsIgnoreCase(product.getName())){
                    cart.add(product);
                    for(Product showCart : cart){
                        System.out.printf("You added: %s|Price: $%.2f|Department: %s\n",
                                showCart.getName(), showCart.getPrice(), showCart.getDepartment());
                    }
                }
            }
        }
        else if (answer.equalsIgnoreCase("no")) {
            displayInventory();
        }
        else {
            System.out.println("Sorry Try again! ");
            addProduct();
        }
        System.out.println("Add more? (Yes / No)");
        String more = scanner.nextLine();
        if(more.equalsIgnoreCase("yes")){
            addProduct();
        }
        else if (more.equalsIgnoreCase("no")) {
            displayHomeInterface();
        }
        else {
            System.out.println("Please try again");
            displayHomeInterface();
        }
    }
    public static ArrayList<Product> getProduct(){
        ArrayList<Product> products = new ArrayList<>();
        String filePath = "src/main/resources/products.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String sku = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2].replace(",",""));
                String department = data[3];
                Product product = new Product(sku, name, price, department);
                products.add(product);
            }
        }
        catch(IOException ex){
            System.out.println("Sorry couldn't read the file.");
        }
        return products;
    }

    public static void getCart(ArrayList<Product> cart){

        for(Product inCart : cart){
            System.out.printf("Name: %s|Price: $%.2f|Department: %s\n",
                    inCart.getName(), inCart.getPrice(), inCart.getDepartment());
        }
        double sum = 0;
        for(Product total : cart){
            sum += total.getPrice();
        }
        System.out.printf("Total is : $%.2f\n", sum);
    }
   public int validateInput(){
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                number = scanner.nextInt();
                while (number > 3 || number < 1){
                    System.out.println(" Please select the number between 1-3, Thank you!");
                    number = scanner.nextInt();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return number;

    }
}