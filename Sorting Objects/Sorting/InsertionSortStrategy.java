/**
 * Insertion Sort is a simple sorting algorithm that builds the final sorted array one element at a time. 
 * It works by dividing the array into a sorted and an unsorted region. 
 * Initially, the sorted region contains only the first element, and the unsorted region contains the remaining elements.
 **/

public class InsertionSortStrategy implements SortingStrategy {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
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