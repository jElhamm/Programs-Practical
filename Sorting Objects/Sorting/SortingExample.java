/**
 * In this section, an example of how this project works is shown. 
 * You can change this part according to your project. 
 **/

import java.util.Scanner;

public class SortingExample 
{
    public static void main( String[] args )
    {
        try {
            Scanner cin = new Scanner(System.in);
            printMenu();
            int choice = cin.nextInt();
            System.out.print(" ==>   Enter the number of array elements: ");
            int userInput = cin.nextInt();
            Comparable[] array = new Comparable[userInput];
            System.out.print(" ==>   Please Enter the items you want to sort:\n      (you can sort non-decimal numbers, decimal numbers, and strings):  " );

            for (int i=0; i < userInput; i++) {
                if (cin.hasNextInt()) {
                    array[i] = cin.nextInt();
                } else if (cin.hasNextDouble()) {
                    array[i] = cin.nextDouble();
                } else {
                    array[i] = cin.next();
                }
            }
            cin.close();
            switch (choice) {
                case 1:
                    SortingContext context1 = new SortingContext(new MergeSortStrategy());
                    context1.sortArray(array);
                    break;
                case 2:
                    SortingContext context2 = new SortingContext(new SelectionSortStrategy());
                    context2.sortArray(array);
                    break;
                case 3:
                    SortingContext context3 = new SortingContext(new BubbleSortStrategy());
                    context3.sortArray(array);
                    break;
                case 4:
                    SortingContext context4 = new SortingContext(new SelectionSortStrategy());
                    context4.sortArray(array);
                    break;
                case 5:
                    SortingContext context5 = new SortingContext(new InsertionSortStrategy());
                    context5.sortArray(array);
                    break;
                default:
                    System.out.println("\n***************************************************************************************************");
                    System.out.println("  ( ! Invalid choice. Exiting... ! )  ");
                    return;
            }
            printSortedArray(array);
        }
        catch (Exception e) {
            System.out.println("\n  ( ! An error occurred: " + e.getMessage() + " ! )  \n");
        }
    }

    private static void printMenu() {
        System.out.println("\n##################################################################################################");
        System.out.println("#  In the program below, you can sort your items with different algorithms and use this program.  #");
        System.out.println("#                                Implemented algorithms:                                          #");
        System.out.println("#               **                  1. Quick Sort                          **                     #");
        System.out.println("#               **                  2. Merge Sort                          **                     #");
        System.out.println("#               **                  3. Bubble Sort                         **                     #");
        System.out.println("#               **                  4. Selection Sort                      **                     #");
        System.out.println("#                                   5. Insertion Sort                                             #");
        System.out.println("###################################################################################################\n");
        System.out.print(" ==>   Select a Sorting Algorithm: ");
    }
    private static void printSortedArray(Comparable[] array) {
        System.out.print("\n ==>  The array is Sorted : [ ");
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            System.out.print(element + ", ");
        }
        System.out.print("] \n");
        System.out.println("***************************************************************************************************\n");
    }
}