
import java.util.stream.IntStream;

/**
 * buble sort
 * @author elamaran
 */

public class Sort {
    /**
     * Traversing the array with i
     * With each value of i traversing the array once again with j
     * When arrayToBeSorted[i] > arrayToBeSorted[j+1] it swaps the value
     * @param arrayToBeSorted
     * @param noOfElements
     */
    public void bubbleSort(int arrayToBeSorted[],int noOfElements) {
        IntStream.range(0, noOfElements - 1).forEach(i -> {
            IntStream.range(0, noOfElements - i - 1).forEach(j -> {
                if (arrayToBeSorted[j] > arrayToBeSorted[j + 1]) {
                    int temp = arrayToBeSorted[j];
                    arrayToBeSorted[j] = arrayToBeSorted[j + 1];
                    arrayToBeSorted[j + 1] = temp;
                }
            });
        });
    }
    /**
     * Printing the sorted array
     * @param arrayToBeSorted
     * @param noOfElements
     */
    public void printArray(int arrayToBeSorted[],int noOfElements) {
        IntStream.range(0, noOfElements).forEach(i -> {
            System.out.print(arrayToBeSorted[i] + " ");
        });
    }

    /**
     * In main function initialising pbject of the class Sort
     * Initialising a new array arrayToBeSorted
     * calling the functions bubbleSort and printArray
     * @param args
     */
    public static void main(String args[]) {
        Sort sortObject = new Sort();
        int arrayToBeSorted[] = { 64, 34, 25, 12, 22, 11, 90 };
        sortObject.bubbleSort(arrayToBeSorted,arrayToBeSorted.length);
        sortObject.printArray(arrayToBeSorted,arrayToBeSorted.length);
    }
}