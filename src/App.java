import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Program header
        System.out.println("Calculator Application - Exception Handling - Stephen James");

        // Welcome message
        System.out.println("Welcome to the calculator program.");
        System.out.println("You may perform arithmetic operations or use memory features.");
        System.out.println();

        Scanner input = new Scanner(System.in);

        programLoop(input);

        // Closing message
        System.out.println("Thank you for using Stephen's Calculator.");
        input.close();
    }

    // Main program control loop
    public static void programLoop(Scanner input) {

        final int EXIT = 0;
        final int ADD = 1;
        final int SUBTRACT = 2;
        final int MULTIPLY = 3;
        final int DIVIDE = 4;
        final int FORMULA = 5;
        final int MEMORY_MENU = 6;

        boolean usingMemoryMenu = false;

        while (true) {

            if (!usingMemoryMenu) {
                // Show Calculator Menu
                int userSelection = Menu.showCalculatorMenu(input);

                if (userSelection == EXIT) {
                    return;
                }

                if (userSelection == MEMORY_MENU) {
                    usingMemoryMenu = true;
                    continue;
                }

                double num1;
                double num2;
                int operation = userSelection;

                switch (userSelection) {

                    case FORMULA:
                        Operation data = Menu.readFormulaInput(input);
                        operation = data.userSelection;
                        num1 = data.num1;
                        num2 = data.num2;
                        break;

                    case DIVIDE:
                        num1 = Menu.readNumInput(input);
                        num2 = Menu.readNumInput(input, true);
                        break;

                    default:
                        num1 = Menu.readNumInput(input);
                        num2 = Menu.readNumInput(input);
                        break;
                }

                switch (operation) {

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

            } else {
                // Show Memory Menu
                int memorySelection = Menu.showMemoryMenu(input);

                if (memorySelection == EXIT) {
                    return;
                }

                if (memorySelection == 12) { // Return to Calculator Menu
                    usingMemoryMenu = false;
                    continue;
                }

                Menu.handleMemorySelection(memorySelection, input);
            }
        }
    }
}
