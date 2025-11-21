import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Welcome message
        System.out.println("Project Week 2 - Software Design and Control Statements - Stephen James");

        // User instructions
        System.out.println("Welcome to phase 2 of the Calculator program.");
        System.out.println("You will be asked to enter two integers for addition,");

        Scanner input = new Scanner(System.in);

        final int EXIT_VALUE = 0;

        while (true) {
            int userSelection = Menu.ShowMenu(input);
            if (userSelection == EXIT_VALUE) {
                break;
            }

            System.out.println("You selected " + userSelection);
        }

        System.out.println("Thank you for using Stephen's Calculator.");
        input.close();
    }
}
