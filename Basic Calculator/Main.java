package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" please give two number add together: ");
        System.out.println("first number please: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Second number please: ");
        int secondNumber = scanner.nextInt();

        int sum = addTwoNumbers( firstNumber, secondNumber);
        System.out.println("the sum is :" + sum);
    }

    public static int addTwoNumbers(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        return sum;

    }

    public  static String askQuestion (String firstPart) {
        String fullQuestion = firstPart + "please:";
        return fullQuestion;
    }

        public static int checkNumber (int number) {

            if (number > 0) {
                return 1;

            }
            else if (number <0 ) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

