package com.selection_sort;

import java.util.Scanner;

public class SelectionSort 
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
        selectionSort(array);
        System.out.println("**********************************************************************");
        System.out.print("### The array is Sorted by Selection Sort: [ ");
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            System.out.print(element + ", ");
        }
        System.out.print("] \n");
        System.out.println("**********************************************************************\n");
    }
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        int arrySize = array.length;
        for (int i=0; i < arrySize-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arrySize; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Displacement of two elements
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
