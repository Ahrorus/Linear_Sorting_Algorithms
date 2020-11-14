// CS-146 - Ahror Abdulhamidov
// Number class - to store numbers with their count numbers

public class Number {

    private int value;  // Integer value of the number
    private int count;  // Relative number of the number

    public Number(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @author Ahror Abdulhamidov
     * Creates and returns an array of Numbers from an array of integers
     */
    public static Number[] makeNumberArray(int[] array) {
        Number[] numbers = new Number[array.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Number(array[i], 1);
        }
        return numbers;
    }

    /**
     * @author Ahror Abdulhamidov
     * Creates and returns an array of Numbers (zeros) of the specified length
     */
    public static Number[] makeNumberArray(int length) {
        Number[] numbers = new Number[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Number(0, 1);
        }
        return numbers;
    }

    /**
     * @author Ahror Abdulhamidov
     * Returns String of values for each Number in the array
     */
    public static String getValues(Number[] numbers) {
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
     * Returns String of counts for each Number in the array
     */
    public static String getCounts(Number[] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(numbers[0].count);
        for (int i = 1; i < numbers.length; i++) {
            sb.append(", ").append(numbers[i].count);
        }
        sb.append("]");
        return sb.toString();
    }

    // Returns String value of the Number
    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
