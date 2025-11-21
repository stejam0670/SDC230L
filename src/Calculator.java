class Operation {
    // This class is used to return a composite of userSelection and both operands
    public int userSelection;
    public double num1;
    public double num2;

    public Operation(int userSelection, double num1, double num2) {
        this.userSelection = userSelection;
        this.num1 = num1;
        this.num2 = num2;
    }
}

public class Calculator {
    public static double add(double a, double b) {
        // Simple addition function
        return a + b;
    }

    public static double subtract(double a, double b) {
        // Simple subtraction function
        return a - b;
    }

    public static double multiply(double a, double b) {
        // Simple multiplication function
        return a * b;
    }

    public static double divide(double a, double b) {
        // Simple division function. Assumes denominator is not zero
        return a / b;
    }

    public static Operation evaluateFormula(String formula) {
        // Remove spaces just to keep things simple and easy to parse
        String formattedFormula = formula.replace(" ", "");

        String[] nums;

        try {
            // Determine which operation selected by searching for relevant characters
            if (formula.contains("+")) {
                nums = formattedFormula.split("\\+");
                return new Operation(1, Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            }
            if (formula.contains("-")) {
                nums = formattedFormula.split("-");
                return new Operation(2, Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            }
            if (formula.contains("*")) {
                nums = formattedFormula.split("\\*");
                return new Operation(3, Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            }
            if (formula.contains("/")) {
                nums = formattedFormula.split("/");

                if (Double.parseDouble(nums[1]) == 0) {
                    throw new IllegalArgumentException("Division denominator cannot be zero.");
                }
                return new Operation(4, Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            }
        } catch (NumberFormatException e) {
            // This will catch Double.parseDouble errors from any of the logic branches
            throw new IllegalArgumentException("Operands must be numbers.");
        }

        // If it's not one of the above we don't want it
        throw new IllegalArgumentException("Unknown operation selected.");
    }
}
