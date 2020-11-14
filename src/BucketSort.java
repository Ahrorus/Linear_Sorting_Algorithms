// CS-146 - Ahror Abdulhamidov
// Class for Bucket Sort

import java.util.ArrayList;

public class BucketSort {

    // Array of double numbers
    private static double[] array = {8, 8, 2, 9, 4, 2, 3, 5, 4, 9, 3, 7, 4, 7, 2};

    // Main method
    public static void main(String[] args) {

        // Prepare the array of doubles
        DoubleNumber[] A = DoubleNumber.makeNumberArray(array);
        setCounts(A);
        System.out.println("Array of numbers and their counts before sorting:");
        System.out.println(DoubleNumber.getValues(A));
        System.out.println(DoubleNumber.getCounts(A));

        // Bucket Sort
        System.out.println("\nBegin Bucket Sort:");
        bucketSort(A, 10);
        System.out.println("End of Bucket Sort");

        // Show the sorting results and prove the stability
        System.out.println("\nArray of numbers and their counts after sorting:");
        System.out.println(DoubleNumber.getValues(A));
        System.out.println(DoubleNumber.getCounts(A));
        System.out.println("The array of the counts indicates that the Counting Sort is stable.");

    }

    /**
     * @author Ahror Abdulhamidov
     * Manually sets counts for each DoubleNumber in the array
     */
    private static void setCounts(DoubleNumber[] A) {
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
     * Does Bucket Sort for the specified array by creating n specified buckets
     */
    private static void bucketSort(DoubleNumber[] A, int n) {
        DoubleNumber.normalize(A, n);
        ArrayList<DoubleNumber>[] B = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            B[i] = new ArrayList<>();
        }
        for (int i = 0; i < A.length; i++) {
            insert(B[(int) (n * A[i].getValue())], A[i]);
            System.out.println(getBuckets(B));
        }
        ArrayList<DoubleNumber> list = concatenateLists(B);
        for (int i = 0; i < A.length; i++) {
            A[i] = list.get(i);
        }
        DoubleNumber.unNormalize(A, n);
    }

    /**
     * @author Ahror Abdulhamidov
     * Inserts a DoubleNumber into the bucket in the right position
     * Style of inserting the element is similar to Insertion Sort
     */
    private static void insert(ArrayList<DoubleNumber> bucket, DoubleNumber number) {
        if (bucket.size() == 0)
            bucket.add(number);
        else {
            int i = bucket.size();
            while ((bucket.get(i - 1).getValue() > number.getValue()) && (i != 1)) {
                i--;
            }
            bucket.add(i, number);
        }
    }

    /**
     * @author Ahror Abdulhamidov
     * Concatinates ArrayLists of DoubleNumbers into one list and returns it
     */
    private static ArrayList<DoubleNumber> concatenateLists(
            ArrayList<DoubleNumber>[] B) {
        ArrayList<DoubleNumber> list = new ArrayList<>();
        for (ArrayList<DoubleNumber> doubleNumbers : B) {
            list.addAll(doubleNumbers);
        }
        return list;
    }

    /**
     * @author Ahror Abdulhamidov
     * Returns String of buckets of DoubleNumbers
     */
    private static String getBuckets(ArrayList<DoubleNumber>[] B) {
        StringBuilder sb = new StringBuilder();
        sb.append("Buckets: [");
        sb.append(B[0]);
        for (int i = 1; i < B.length; i++) {
            sb.append(", ").append(B[i]);
        }
        sb.append("]");
        return sb.toString();
    }

}

