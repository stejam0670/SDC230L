import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Welcome message
        System.out.println("Project Week 2 - Software Design and Control Statements - Stephen James");

        // User instructions
        System.out.println("Welcome to phase 2 of the Calculator program.");
        System.out.println("You will be asked to enter two integers for addition,");

        Scanner input = new Scanner(System.in);

        programLoop(input);

        System.out.println("Thank you for using Stephen's Calculator.");
        input.close();
    }

    public static void programLoop(Scanner input) {
        // Use constants to allow easy changing of control values
        final int EXIT_VALUE = 0;
        final int DIVISION_VALUE = 4;
        final int FORMULA_VALUE = 5;

        while (true) {
            double num1, num2;

            int userSelection = Menu.showMenu(input);

            switch (userSelection) {
                case EXIT_VALUE:
                    return;

                case FORMULA_VALUE:
                    System.out.println("Formula chosen - not implemented yet.");
                    break;

                case DIVISION_VALUE:
                    num1 = Menu.readNumInput(input);
                    num2 = Menu.readNumInput(input, true);
                    break;

                default:
                    num1 = Menu.readNumInput(input);
                    num2 = Menu.readNumInput(input);
                    break;
            }
        }
    }
}
