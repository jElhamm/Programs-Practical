/**
 * Selection Sort that selects the smallest element from an unsorted portion of the array and swaps it with the element at the beginning of the sorted portion. 
 * This process is repeated until the entire array is sorted.
 **/

public class SelectionSortStrategy implements SortingStrategy {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
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
