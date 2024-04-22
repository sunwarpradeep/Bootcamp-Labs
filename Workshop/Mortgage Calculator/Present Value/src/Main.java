import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter your original deposit amount: ");
        double deposit = scanner.nextDouble();
        System.out.println(" Enter your interest rate: ");
        double interestRate = scanner.nextDouble();
        System.out.println(" Enter your the amount of years: ");
        int years = scanner.nextInt();
        double futureValue = calculate(deposit, interestRate, years);

        System.out.printf("Your future value is $%.2f and your total interest is  $%.2f", futureValue, (futureValue - deposit));
    }

    public static double calculate(double deposit, double interestRate, int years) {
        return Math.pow(1 + (interestRate / 365 / 100), (365 * years)) * deposit;
    }
}