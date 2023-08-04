/**
 * The implemented program shows the performance of the Merge Sort algorithm
 **/

import java.util.Scanner;

public class MergeSort 
{
    public static void main( String[] args )
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("\n**********************************************************************");
        System.out.print("# Please enter the number of array elements: ");
        int userInput = cin.nextInt();
        Comparable[] array = new Comparable[userInput];
        System.out.println("**********************************************************************");
        System.out.println("## Please enter the items you want to sort:\n (you can sort non-decimal numbers, decimal numbers, and strings):");
        for (int i = 0; i < userInput; i++) {
            if (cin.hasNextInt()) {
                array[i] = cin.nextInt();
            } else if (cin.hasNextDouble()) {
                array[i] = cin.nextDouble();
            } else {
                array[i] = cin.next();
            }
        }
        mergeSort(array, 0, array.length - 1);
        System.out.println("**********************************************************************");
        System.out.print("### The array is Sorted by Merge Sort: [ ");
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            System.out.print(element + ", ");
        }
        System.out.print("] \n");
        System.out.println("**********************************************************************\n");
    }
    public static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    public static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int low = mid - left + 1;
        int high = right - mid;
        // Temporary arrays for left and right halves
        T[] leftArray = (T[]) new Comparable[low];
        T[] rightArray = (T[]) new Comparable[high];
        // Copy elements to temporary arrays
        for (int i=0; i<low; i++){
            leftArray[i] = array[left + i];
        }
        for (int j=0; j<high; j++){
            rightArray[j] = array[mid + 1 + j];
        }
        // Merging two temporary arrays into the main array
        int i=0, j=0 , k=left;
        while (i<low && j<high) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy the remaining elements from the left array
        while (i<low) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        // Copy the remaining elements from the right array
        while (j<high) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}