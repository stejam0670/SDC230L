import java.util.ArrayList;
import java.util.List;

class Operation {
    // Holds a selected operation and two operands for formula evaluation
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

    // Stores a single numeric value in memory
    // A null value indicates that nothing is currently stored
    private static Double singleMemory = null;

    // Stores up to 10 integer values in memory
    private static ArrayList<Integer> memoryList = new ArrayList<>();

    /*
     * =========================
     * Single Value Memory
     * =========================
     */

    // Stores a numeric value in single memory
    public static void storeSingleValue(double value) {
        singleMemory = value;
    }

    // Retrieves the currently stored single value
    public static Double getSingleValue() {
        return singleMemory;
    }

    // Clears the single value stored in memory
    public static void clearSingleValue() {
        singleMemory = null;
    }

    // Replaces the current single memory value with a new one
    public static void replaceSingleValue(double value) {
        singleMemory = value;
    }

    /*
     * =========================
     * Collection Memory
     * =========================
     */

    // Adds a value to the memory list if space is available
    public static boolean addToMemoryList(int value) {
        if (memoryList.size() >= 10) {
            return false;
        }
        memoryList.add(value);
        return true;
    }

    // Removes the first occurrence of a value from the memory list
    public static boolean removeFromMemoryList(int value) {
        return memoryList.remove((Integer) value);
    }

    // Returns a copy of all values currently stored in memory
    public static List<Integer> getMemoryValues() {
        return new ArrayList<>(memoryList);
    }

    // Returns the number of values currently stored
    public static int getMemoryCount() {
        return memoryList.size();
    }

    // Calculates and returns the sum of all stored values
    public static int getMemorySum() {
        if (memoryList.isEmpty()) {
            throw new IllegalStateException("No values stored.");
        }

        int sum = 0;
        for (int value : memoryList) {
            sum += value;
        }
        return sum;
    }

    // Calculates and returns the average of stored values
    public static double getMemoryAverage() {
        if (memoryList.isEmpty()) {
            throw new IllegalStateException("No values stored.");
        }

        return (double) getMemorySum() / memoryList.size();
    }

    // Calculates and returns the difference between the first and last values
    public static int getFirstLastDifference() {
        if (memoryList.size() < 2) {
            throw new IllegalStateException("At least two values are required.");
        }

        int first = memoryList.get(0);
        int last = memoryList.get(memoryList.size() - 1);
        return first - last;
    }

    /*
     * =========================
     * Arithmetic Operations
     * =========================
     */

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    // Parses a string formula and determines the operation to perform
    public static Operation evaluateFormula(String formula) {
        String formattedFormula = formula.replace(" ", "");
        String[] nums;

        try {
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
            throw new IllegalArgumentException("Operands must be numbers.");
        }

        throw new IllegalArgumentException("Unknown operation selected.");
    }
}
