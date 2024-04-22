import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" First Mortgage Calculator! ");

        System.out.println(" Enter loan amount: ");
        double principal = scanner.nextDouble();

        System.out.println("Enter annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();
        System.out.println(" Enter loan term amount in years : ");
        int loanTermYears = scanner.nextInt();

        double monthlyPayment = calculateMonthlyPayment(principal, annualInterestRate, loanTermYears);
        double totalInterest = ( monthlyPayment * 12 * loanTermYears ) - principal;

        System.out.printf(" Your monthly payments would be $%.2f and with a total interest of $%.2f", monthlyPayment, totalInterest);


    }


    public static double calculateMonthlyPayment(double principal, double annualInterestRate, int loanTermYears) {
        double rate = annualInterestRate / 12 / 100;
        int numberMonths = loanTermYears * 12;
        double basePower = Math.pow(1 + rate, numberMonths);
        return (principal * (rate * basePower / (basePower - 1)));
    }
}