// CS-146 - Ahror Abdulhamidov
// Class for Radix Sort

import java.util.Arrays;
import java.util.Random;

public class RadixSort {

    // Empty array of hex Strings
    private static String[] A;

    // Main method
    public static void main(String[] args) {

        // Prepare the array of hex Strings
        A = makeRandomHexArray(30, 5);
        System.out.println("Array of numbers and their counts before sorting:");
        System.out.println(Arrays.toString(A));

        // Radix Sort
        System.out.println("\nBegin Radix Sort: ");
        hexRadixSort(A, 5);
        System.out.println("End of Radix Sort");

        // Show the sorting results
        System.out.println("\nArray of hex numbers after sorting:");
        System.out.println(Arrays.toString(A));

    }

    /**
     * @author Ahror Abdulhamidov
     * Creates an array of specified length consisting of random hex strings
     * of specified number of digits filled with zeros and returns it
     */
    private static String[] makeRandomHexArray(int length, int maxDigit) {
        String[] hexArray = new String[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int d = 0; d < maxDigit; d++) {
                sb.append(Integer.toHexString(r.nextInt(16)));
            }
            hexArray[i] = sb.toString();
        }
        return hexArray;
    }

    /**
     * @author Ahror Abdulhamidov
     * Does Radix Sort for the Array of hex Strings A[]
     */
    private static void hexRadixSort(String[] A, int maxDigit) {
        for (int d = maxDigit - 1; d >= 0; d--) {
            String[] B = new String[A.length];
            hexCountingSort(A, B, d);
            for (int i = 0; i < A.length; i++) {
                A[i] = B[i];
            }
            System.out.println("Array, sorted by the digit " +
                    (d + 1) + ": " + Arrays.toString(A));
        }
    }

    /**
     * @author Ahror Abdulhamidov
     * Does Counting Sort by the d-th digit for the Array of hex Strings A[]
     * and stores it in B[]
     */
    private static void hexCountingSort(String[] A, String[] B, int d) {
        int[] C = new int[16];
        for (int i = 0; i < 16; i++)
            C[i] = 0;
        for (String a : A)
            C[hexToInt(a.charAt(d))]++;
        for (int i = 1; i < 16; i++)
            C[i] += C[i - 1];
        for (int j = A.length - 1; j >= 0; j--) {
            C[hexToInt(A[j].charAt(d))]--;
            B[C[hexToInt(A[j].charAt(d))]] = A[j];
        }
    }

    /**
     * @author Ahror Abdulhamidov
     * Converts a hex character into an integer and returns it
     */
    private static int hexToInt(char c) {
        return Integer.parseInt(Character.toString(c), 16);
    }

}
