// CS-146 - Ahror Abdulhamidov
// Class for Counting Sort

import java.util.Arrays;

public class CountingSort {

    // Array of numbers
    private static int[] array = {8, 8, 2, 9, 4, 2, 3, 5, 4, 9, 3, 7, 4, 7, 2};

    // Main method
    public static void main(String[] args) {

        // Prepare the array of numbers
        Number[] A = Number.makeNumberArray(array);
        setCounts(A);
        System.out.println("Array of numbers and their counts before sorting:");
        System.out.println(Number.getValues(A));
        System.out.println(Number.getCounts(A));

        // Counting Sort
        System.out.println("\nBegin Counting Sort:");
        Number[] B = Number.makeNumberArray(15);
        countingSort(A, B, 9);
        System.out.println("End of Counting Sort");

        // Show the sorting results and prove the stability
        System.out.println("\nArray of numbers and their counts after sorting:");
        System.out.println(Number.getValues(B));
        System.out.println(Number.getCounts(B));
        System.out.println(
                "The array of the counts indicates that the Counting Sort is stable."
        );

    }

    /**
     * @author Ahror Abdulhamidov
     * Manually sets counts for each Number in the array
     */
    private static void setCounts(Number[] A) {
        A[1].setCount(2);
        A[5].setCount(2);
        A[8].setCount(2);
        A[9].setCount(2);
        A[10].setCount(2);
        A[12].setCount(3);
        A[13].setCount(2);
        A[14].setCount(3);
    }

    /**
     * @author Ahror Abdulhamidov
     * Does Counting Sort for the array of Numbers A[] and stores the sorted array in B[]
     * Auxiliary array for the Counting Sort is of specified size k
     */
    private static void countingSort(Number[] A, Number[] B, int k) {
        System.out.println("Array B: " + Number.getValues(B));
        int[] C = new int[k + 1];
        for (int i = 0; i <= k; i++)
            C[i] = 0;
        for (Number number : A)
            C[number.getValue()]++;
        for (int i = 1; i <= k; i++)
            C[i] += C[i - 1];
        System.out.println("Array C: " + Arrays.toString(C));
        for (int j = A.length - 1; j >= 0; j--) {
            C[A[j].getValue()]--;
            B[C[A[j].getValue()]] = A[j];
            System.out.println("\nArray B: " + Number.getValues(B));
            System.out.println("Array C: " + Arrays.toString(C));
        }
    }

}
