import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Welcom message
        System.out.println("Project Week 1 - Basic Calculator - Stephen James");

        // User instructions
        System.out.println("Welcome to the Basic Calculator.");
        System.out.println("You will be asked to enter two integers for addition,");
        System.out.println("and then two floating-point numbers for subtraction.");
        System.out.println("Results will be shown after each operation.");

        Scanner input = new Scanner(System.in);

        try {
            // Integer addition
            System.out.print("Enter the first integer: ");
            int int1 = input.nextInt();
            System.out.print("Enter the second integer: ");
            int int2 = input.nextInt();

            // Calculate and display result
            int intResult = int1 + int2;
            System.out.printf("%d + %d = %d%n", int1, int2, intResult);

            // Floating point subtraction
            System.out.print("Enter the first floating-point number: ");
            double float1 = input.nextDouble();
            System.out.print("Enter the second floating-point number: ");
            double float2 = input.nextDouble();

            // Calculate and display result
            double floatResult = float2 - float1;
            System.out.printf("%.2f - %.2f = %.2f%n", float2, float1, floatResult);

            // Closing message
            System.out.println("Thank you for using Stephen's Basic Calculator.");
        } catch (InputMismatchException e) {
            System.out.println("Only numeric values allowed. Better luck next time!");
        } finally {
            input.close();
        }
    }
}
