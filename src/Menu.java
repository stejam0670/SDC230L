import java.util.List;
import java.util.Scanner;

public class Menu {

    /*
     * =========================
     * Calculator Menu
     * =========================
     */

    public static int showCalculatorMenu(Scanner input) {
        int userSelection;

        while (true) {
            System.out.println("***********************");
            System.out.println("*** Calculator Menu ***");
            System.out.println("1) Addition");
            System.out.println("2) Subtraction");
            System.out.println("3) Multiplication");
            System.out.println("4) Division");
            System.out.println("5) Formula");
            System.out.println("6) Memory Menu");
            System.out.println();
            System.out.print("Enter your selection (0 to quit): ");

            try {
                userSelection = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a number.");
                continue;
            }

            if (userSelection < 0 || userSelection > 6) {
                System.out.println("Invalid entry. Please choose a valid option.");
                continue;
            }

            return userSelection;
        }
    }

    /*
     * =========================
     * Memory Menu
     * =========================
     */

    public static int showMemoryMenu(Scanner input) {
        int userSelection;

        while (true) {
            System.out.println("***********************");
            System.out.println("*** Memory Menu ***");
            System.out.println("1) Store single value");
            System.out.println("2) Retrieve single value");
            System.out.println("3) Clear single value");
            System.out.println("4) Replace single value");
            System.out.println("5) Add value to list");
            System.out.println("6) Display all values");
            System.out.println("7) Display count");
            System.out.println("8) Remove a value");
            System.out.println("9) Get sum");
            System.out.println("10) Get average");
            System.out.println("11) Get first-last difference");
            System.out.println("12) Return to Calculator Menu");
            System.out.println();
            System.out.print("Enter your selection (0 to quit): ");

            try {
                userSelection = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a number.");
                continue;
            }

            if (userSelection < 0 || userSelection > 12) {
                System.out.println("Invalid entry. Please choose a valid option.");
                continue;
            }

            return userSelection;
        }
    }

    /*
     * =========================
     * Memory Menu Handler
     * =========================
     */

    public static void handleMemorySelection(int selection, Scanner input) {

        switch (selection) {

            case 1:
                System.out.print("Enter a value to store: ");
                double storeValue = readNumInput(input);
                Calculator.storeSingleValue(storeValue);
                System.out.println("Value stored.");
                break;

            case 2:
                Double retrieved = Calculator.getSingleValue();
                if (retrieved == null) {
                    System.out.println("No value is currently stored.");
                } else {
                    System.out.println("Stored value: " + retrieved);
                }
                break;

            case 3:
                Calculator.clearSingleValue();
                System.out.println("Single value cleared.");
                break;

            case 4:
                System.out.print("Enter a new value: ");
                double replaceValue = readNumInput(input);
                Calculator.replaceSingleValue(replaceValue);
                System.out.println("Value replaced.");
                break;

            case 5:
                System.out.print("Enter an integer to add: ");
                int addValue = readInt(input);

                if (Calculator.addToMemoryList(addValue)) {
                    System.out.println("Value added to list.");
                } else {
                    System.out.println("List is full. Maximum of 10 values allowed.");
                }
                break;

            case 6:
                List<Integer> values = Calculator.getMemoryValues();

                if (values.isEmpty()) {
                    System.out.println("No values stored in the list.");
                } else {
                    System.out.println("Values in memory:");
                    for (int value : values) {
                        System.out.println(value);
                    }
                }
                break;

            case 7:
                System.out.println("Number of values stored: " + Calculator.getMemoryCount());
                break;

            case 8:
                System.out.print("Enter the value to remove: ");
                int removeValue = readInt(input);

                if (Calculator.removeFromMemoryList(removeValue)) {
                    System.out.println("Value removed.");
                } else {
                    System.out.println("Value not found in the list.");
                }
                break;

            case 9:
                try {
                    System.out.println("Sum: " + Calculator.getMemorySum());
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 10:
                try {
                    System.out.println("Average: " + Calculator.getMemoryAverage());
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 11:
                try {
                    System.out.println("First - Last Difference: " + Calculator.getFirstLastDifference());
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }

    /*
     * =========================
     * Arithmetic Input Helpers
     * =========================
     */

    // Reads a numeric value from the user
    public static double readNumInput(Scanner input) {
        double value;

        while (true) {
            System.out.print("Please enter a number: ");
            try {
                value = Double.parseDouble(input.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Entry must be a number. Please try again.");
            }
        }
    }

    // Reads a numeric value and prevents zero if used as a denominator
    public static double readNumInput(Scanner input, boolean isDenominator) {
        while (true) {
            double value = readNumInput(input);

            if (!isDenominator || value != 0) {
                return value;
            }

            System.out.println("Denominator cannot be zero. Please try again.");
        }
    }

    // Reads and validates formula input
    public static Operation readFormulaInput(Scanner input) {
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

    /*
     * =========================
     * Integer Helper for Memory
     * =========================
     */

    private static int readInt(Scanner input) {
        int value;

        while (true) {
            try {
                value = Integer.parseInt(input.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid entry. Enter an integer value: ");
            }
        }
    }
}
