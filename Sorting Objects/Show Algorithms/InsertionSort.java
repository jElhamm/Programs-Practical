/**
 * The implemented program shows the performance of the Insertion Sort algorithm
 **/

import java.util.Scanner;

public class InsertionSort 
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
        insertionSort(array);
        System.out.println("**********************************************************************");
        System.out.print("### The array is Sorted by Insertion Sort: [ ");
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            System.out.print(element + ", ");
        }
        System.out.print("] \n");
        System.out.println("**********************************************************************\n");
    }
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        int arrySize = array.length;
        for (int i=1; i < arrySize; ++i) {
            T currentElement = array[i];
            int j = i-1;
            while (j >= 0 && array[j].compareTo(currentElement) > 0) {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = currentElement;
        }
    }
}
