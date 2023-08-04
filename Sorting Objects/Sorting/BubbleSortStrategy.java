/**
 * Bubble sort that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. 
 * The algorithm passes through the list multiple times, with each pass moving the largest unsorted element to its correct position.
 * This process is repeated until the entire list is sorted.
 **/

public class BubbleSortStrategy implements SortingStrategy {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
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
