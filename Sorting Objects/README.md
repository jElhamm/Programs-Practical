# Sort Program

This project performs the sorting process for each type of input by implementing different sorting algorithms and using the strategy design pattern. 
Sorting algorithms used include:

   * [Merge Sort](https://en.wikipedia.org/wiki/Merge_sort)
   * [Quick Sort](https://en.wikipedia.org/wiki/Quicksort)
   * [Bubble Sort](https://en.wikipedia.org/wiki/Bubble_sort)
   * [Selection Sort](https://en.wikipedia.org/wiki/Selection_sort)
   * [Insertion Sort](https://en.wikipedia.org/wiki/Insertion_sort)

## Available Sorting Algorithms

   * Merge Sort     ==> Divides the array into smaller sub-arrays, sorts them, and merges them back into a sorted array.
   * Quick Sort     ==> Divides the array into two sub-arrays based on a pivot element, recursively sorts the sub-arrays, and combines them to obtain the final sorted array.
   * Bubble Sort    ==> Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
   * Selection Sort ==> Repeatedly selects the smallest element from the unsorted part of the array and swaps it with the element at the beginning of the sorted part.
   * Insertion Sort ==> Builds the final sorted array one element at a time by repeatedly inserting the next element into its correct position.
   

## Usage

   To use this program, follow these steps:

   1. Run the SortingExample class.
   2. You will be presented with a menu to choose the sorting algorithm.
   3. Enter the number of elements in the array that you want to sort.
   4. Enter the array elements (you can enter non-decimal numbers, decimal numbers, or strings).
   5. The program will sort the array using the selected sorting algorithm and display the sorted array.

## Strategy Design Pattern
The sorting algorithms are implemented using the strategy design pattern. This pattern allows us to encapsulate each sorting algorithm into a separate class that implements the SortingStrategy interface.
The SortingContext class uses the selected strategy to perform the sorting operation.

The SortingStrategy interface defines a generic method sort() that takes an array of comparable elements and performs the sorting operation. Each sorting algorithm class implements this interface and provides its own implementation of the sort() method.