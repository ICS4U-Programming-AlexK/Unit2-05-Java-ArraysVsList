import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This program populates an array with random numbers and sorts it.
 * It then calculates the average of the numbers in the array.
 * @author Alex Kapajika
 * @version 1.0
 * @since 2025-03-18
 */
final class ArraysVsList {
    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private ArraysVsList() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * Main Method.
     * @param listArray
     * @return mean
     */
    static float mean(final Integer[] listArray) {
        float sum = 0;
        for (int count = 0; count < listArray.length; count++) {
            sum += listArray[count];
        }
        return sum / listArray.length;
    }
    /**
     * Main Method.
     *
     * @param listArray
     * @return median
     */
    static float median(final Integer[] listArray) {
        if (listArray.length % 2 == 0) {
            return (listArray[listArray.length / 2]
             + listArray[(listArray.length / 2) - 1]) / 2;
        } else {
            return listArray[listArray.length / 2];
        }
    }
    /**
     * Main Method.
     *
     * @param listArray
     * @return mode
     */
    static float mode(final Integer[] listArray) {
        int maxCount = 0;
        int maxNumber = -1;
        for (int count = 0; count < listArray.length; count++) {
            int count2 = 0;
            for (int count3 = 0; count3 < listArray.length; count3++) {
                if (listArray[count3] == listArray[count]) {
                    count2++;
                }
            }
            if (count2 > maxCount) {
                maxCount = count2;
                maxNumber = listArray[count];
            }
        }
        return maxNumber;
    }
    /**
     * Main Method.
     *
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        ArrayList<Integer> numberList = new ArrayList<>();

        for (String fileName : args) {  // Loop through all file names
            File file = new File(fileName);
            Scanner fileRead = new Scanner(file);
            while (fileRead.hasNextLine()) {
                // Read each line from the file
                String numberLine = fileRead.nextLine().trim();
                // Trim to remove leading/trailing spaces
                if (numberLine.isEmpty()) {
                    continue;
                    // Skip empty lines
                    String[] numberArray = numberLine.split(" ");
                }
                // Splits by any number of spaces
                for (String number : numberArray) {
                    if (!number.isEmpty()) {
                        // Ensure it's not an empty string
                        numberList.add(Integer.parseInt(number));
                    }
                }
            }
            fileRead.close();
        }
        // Convert ArrayList to array
        Integer[] numberlistArray = numberList.toArray(new Integer[0]);
        Arrays.sort(numberlistArray);
        // Print results
        System.out.println("Sorted List: " + Arrays.toString(numberlistArray));
        System.out.println("Mean: " + mean(numberlistArray));
        System.out.println("Median: " + median(numberlistArray));
        System.out.println("Mode: " + mode(numberlistArray));
    }
}
