import java.util.Scanner;

public class Menu {
    public static int ShowMenu(Scanner input) {
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
            System.out.println("0) Exit");
            System.out.print("Enter the number of your selection: ");

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
}
