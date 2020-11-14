// CS-146 - Ahror Abdulhamidov
// DoubleNumber class - to store double numbers with their count numbers

public class DoubleNumber {

    private double value;   // Double value of the number
    private int count;      // Relative number of the number

    public DoubleNumber(double value, int count) {
        this.value = value;
        this.count = count;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @author Ahror Abdulhamidov
     * Creates and returns an array of DoubleNumbers from an array of doubles
     */
    public static DoubleNumber[] makeNumberArray(double[] array) {
        DoubleNumber[] numbers = new DoubleNumber[array.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new DoubleNumber(array[i], 1);
        }
        return numbers;
    }

    /**
     * @author Ahror Abdulhamidov
     * Creates and returns an array of DoubleNumbers (zeros) of the specified length
     */
    public static DoubleNumber[] makeNumberArray(int length) {
        DoubleNumber[] numbers = new DoubleNumber[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new DoubleNumber(0, 1);
        }
        return numbers;
    }

    /**
     * @author Ahror Abdulhamidov
     * Normalizes the array (divides every element by n)
     */
    public static void normalize(DoubleNumber[] A, int n) {
        for (DoubleNumber number : A) {
            number.setValue(number.getValue() / n);
        }
    }

    /**
     * @author Ahror Abdulhamidov
     * Unnormalizes the array (mulitplies every element by n)
     */
    public static void unNormalize(DoubleNumber[] A, int n) {
        for (DoubleNumber number : A) {
            number.setValue(number.getValue() * n);
        }
    }

    /**
     * @author Ahror Abdulhamidov
     * Returns String of values for each DoubleNumber in the array
     */
    public static String getValues(DoubleNumber[] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(numbers[0].value);
        for (int i = 1; i < numbers.length; i++) {
            sb.append(", ").append(numbers[i].value);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * @author Ahror Abdulhamidov
     * Returns String of counts for each DoubleNumber in the array
     */
    public static String getCounts(DoubleNumber[] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(numbers[0].count);
        for (int i = 1; i < numbers.length; i++) {
            sb.append(", ").append(numbers[i].count);
        }
        sb.append("]");
        return sb.toString();
    }

    // Returns String value of the DoubleNumber
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
