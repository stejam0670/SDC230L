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
        final int EXIT = 0;
        final int ADD = 1;
        final int SUBTRACT = 2;
        final int MULTIPLY = 3;
        final int DIVIDE = 4;
        final int FORMULA = 5;

        while (true) {
            double num1, num2;
            int operation;

            int userSelection = Menu.showMenu(input);

            switch (userSelection) {
                // Read user selection and set operation and operands
                case EXIT:
                    return;

                case FORMULA:
                    Operation data = Menu.readFormulaInput(input);
                    operation = data.userSelection;
                    num1 = data.num1;
                    num2 = data.num2;
                    break;

                case DIVIDE:
                    operation = DIVIDE;
                    num1 = Menu.readNumInput(input);
                    num2 = Menu.readNumInput(input, true);
                    break;

                default:
                    operation = userSelection;
                    num1 = Menu.readNumInput(input);
                    num2 = Menu.readNumInput(input);
                    break;
            }

            switch (operation) {
                // Perform operation based on selection
                case ADD:
                    System.out.println(num1 + " + " + num2 + " = " + Calculator.add(num1, num2));
                    break;

                case SUBTRACT:
                    System.out.println(num1 + " - " + num2 + " = " + Calculator.subtract(num1, num2));
                    break;

                case MULTIPLY:
                    System.out.println(num1 + " * " + num2 + " = " + Calculator.multiply(num1, num2));
                    break;

                case DIVIDE:
                    System.out.println(num1 + " / " + num2 + " = " + Calculator.divide(num1, num2));
                    break;
            }
        }
    }
}
