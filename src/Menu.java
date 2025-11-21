import java.util.Scanner;

public class Menu {
    public static int showMenu(Scanner input) {
        int userSelection;

        // This will loop until the exit condition is reached.
        while (true) {
            // Print main menu text
            System.out.println("*****************");
            System.out.println("*** Main Menu ***");
            System.out.println("1) Addition");
            System.out.println("2) Subtraction");
            System.out.println("3) Multiplication");
            System.out.println("4) Division");
            System.out.println("5) Formula");
            System.out.println();
            System.out.print("Enter the number of your selection (Zero to exit): ");

            try {
                userSelection = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                // If input is not a number, loop and try again
                System.out.println("Invalid entry. Please enter the number of your choice");
                continue;
            }

            if (userSelection > 5 || userSelection < 0) {
                // If input is not one of the available options, loop and try again
                System.out.println("Invalid entry. Please choose one of the available options.");
                continue;
            }

            return userSelection;
        }
    }

    public static double readNumInput(Scanner input, boolean isDenominator) {
        // Read numerical input from the console and loop until valid input is provided
        // Additionally check to prevent attempts to divide by zero
        double value;

        while (true) {
            value = readNumInput(input);

            if (!isDenominator || value != 0) {
                return value;
            }

            System.out.println("Denominator cannot be zero. Please try again.");
        }
    }

    public static double readNumInput(Scanner input) {
        // Read numerical input from the console and loop until valid input is provided
        double value;

        while (true) {
            System.out.print("Please enter a number: ");
            try {
                value = Double.parseDouble(input.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Entry must be a number. Please try again");
            }
        }
    }

    public static Operation readFormulaInput(Scanner input) {
        // Read formula input from the console and loop until valid input is provided
        while (true) {
            try {
                System.out.print("Please enter the formula: ");
                String formula = input.nextLine();

                return Calculator.evaluateFormula(formula);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid formula: " + e.getMessage());
            }
        }
    }
}
