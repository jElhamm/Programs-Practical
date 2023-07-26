package com.bubble_sort;

import java.util.Scanner;

public class BubbleSort 
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
        bubbleSort(array);
        System.out.println("**********************************************************************");
        System.out.print("### The array is Sorted by Bubble Sort: [ ");
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            System.out.print(element + ", ");
        }
        System.out.print("] \n");
        System.out.println("**********************************************************************\n");
    }
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int arrySize = array.length;
        for (int i=0; i < arrySize-1; i++) {
            for (int j=0; j < arrySize-i-1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    // Displacement of two elements
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
