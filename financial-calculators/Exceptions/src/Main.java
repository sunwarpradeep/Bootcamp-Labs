import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
        System.out.println("please put the number");
        try{
            int number = scanner.nextInt();

            System.out.println("enter the next number");

            int secondNumber = scanner.nextInt();
            System.out.println(" result: " + (number/secondNumber
            ));
        }
        catch (InputMismatchException exception) {
            System.out.println("please int a number");
            catch(Exception exception){

            }

        }

    }
}