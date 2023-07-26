package com.quick_sort;

import java.util.Scanner;

public class QuickSort 
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
        quickSort(array, 0, array.length - 1);
        System.out.println("**********************************************************************");
        System.out.print("### The array is Sorted by Quick Sort: [ ");
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            System.out.print(element + ", ");
        }
        System.out.print("] \n");
        System.out.println("**********************************************************************\n");
    }
    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low-1;
        for (int j=low; j<high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // swap
        T temp = array[i + 1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    } 
}